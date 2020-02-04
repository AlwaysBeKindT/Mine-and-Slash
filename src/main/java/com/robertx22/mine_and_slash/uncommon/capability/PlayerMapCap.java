package com.robertx22.mine_and_slash.uncommon.capability;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.dimensions.MapManager;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.packets.sync_cap.PlayerCaps;
import com.robertx22.mine_and_slash.saveclasses.PlayerWholeMapData;
import com.robertx22.mine_and_slash.saveclasses.item_classes.MapItemData;
import com.robertx22.mine_and_slash.uncommon.capability.bases.BaseProvider;
import com.robertx22.mine_and_slash.uncommon.capability.bases.BaseStorage;
import com.robertx22.mine_and_slash.uncommon.capability.bases.ICommonPlayerCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;
import com.robertx22.mine_and_slash.uncommon.localization.Chats;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.PlayerUtils;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.WorldUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber
public class PlayerMapCap {

    public static final ResourceLocation RESOURCE = new ResourceLocation(Ref.MODID, "playermapdata");

    @CapabilityInject(IPlayerMapData.class)
    public static final Capability<IPlayerMapData> Data = null;

    static final String LOC = Ref.MODID + "data";

    public interface IPlayerMapData extends ICommonPlayerCap {

        void onTickIfDead(ServerPlayerEntity player);

        float getLootMultiplier(PlayerEntity player);

        String getLastMapGUID();

        boolean hasTimeForMap();

        int getMinutesPassed();

        MapItemData getMap();

        BlockPos getMapDevicePos();

        DimensionType getOriginalDimension();

        void teleportPlayerBack(PlayerEntity player);

        void onPlayerDeath(PlayerEntity player);

        boolean isPermaDeath();

        void onMinute(PlayerEntity player);

        void init(BlockPos pos, MapItemData map, DimensionType type, PlayerEntity player);

        void onQuestFinished();
    }

    @Mod.EventBusSubscriber
    public static class EventHandler {

        @SubscribeEvent
        public static void onEntityConstruct(AttachCapabilitiesEvent<Entity> event) {

            if (event.getObject() instanceof PlayerEntity) {
                event.addCapability(RESOURCE, new Provider());
            }
        }

    }

    public static class Provider extends BaseProvider<IPlayerMapData> {

        @Override
        public IPlayerMapData defaultImpl() {
            return new DefaultImpl();
        }

        @Override
        public Capability<IPlayerMapData> dataInstance() {
            return Data;
        }
    }

    public static class DefaultImpl implements IPlayerMapData {

        PlayerWholeMapData data = new PlayerWholeMapData();

        @Override
        public CompoundNBT saveToNBT() {

            CompoundNBT nbt = new CompoundNBT();

            if (data != null) {
                LoadSave.Save(data, nbt, LOC);
            }

            return nbt;

        }

        @Override
        public void loadFromNBT(CompoundNBT nbt) {
            data = LoadSave.Load(PlayerWholeMapData.class, new PlayerWholeMapData(), nbt, LOC);
        }

        @Override
        public PlayerCaps getCapType() {
            return PlayerCaps.MAP_DATA;
        }

        @Override
        public void onPlayerDeath(PlayerEntity player) {

            this.data.isDead = true;

            if (this.isPermaDeath()) {

                this.data.minutesPassed += 555555;

                player.sendMessage(Chats.Player_died_in_a_map_world.locName()
                                           .appendText(" " + player.getDisplayName().getFormattedText() + " ")
                                           .appendSibling(Chats.Time_ran_out_due_to_Permadeath.locName()));

            } else {
                int punishment = 5;

                player.sendMessage(Chats.Player_died_in_a_map_world.locName()
                                           .appendText(" " + player.getDisplayName().getFormattedText() + " ")
                                           .appendSibling(Chats.Map_time_penalty_activated.locName()));

                this.data.minutesPassed += punishment;

                announceTimeLeft(player);
            }

            if (ModConfig.INSTANCE.Server.DISABLE_DEATH_IN_MAPS.get()) {
                player.setHealth(player.getMaxHealth()); // needs to have more hp to actually teleport lol and not die
            }

        }

        @Override
        public boolean isPermaDeath() {
            return data.mapdata.isPermaDeath;
        }

        @Override
        public void onMinute(PlayerEntity player) {
            this.data.minutesPassed++;

            if (this.getMinutesLeft() < 1) {

                this.announceEnd(player);
                this.teleportPlayerBack(player);

            } else {
                onMinutePassAnnounce(player);

            }

        }

        @Override
        public void init(BlockPos pos, MapItemData map, DimensionType type, PlayerEntity player) {

            this.data = new PlayerWholeMapData();

            this.data.minutesPassed = 0;
            this.data.mapDevicePos = new BlockPos(pos);
            this.data.setOriginalDimension(player.world.getDimension().getType());
            this.data.mapdata = map.clone();
            this.data.questFinished = false;
            this.data.setPlayerId(player);

            MMORPG.syncMapData((ServerPlayerEntity) player);
        }

        @Override
        public void onQuestFinished() {
            this.data.questFinished = true;
        }

        private void onMinutePassAnnounce(PlayerEntity player) {
            int minutesLeft = getMinutesLeft();

            if (minutesLeft > 0) {
                if (minutesLeft < 5 || minutesLeft % 5 == 0) {
                    announceTimeLeft(player);
                }
            }
        }

        @Override
        public void onTickIfDead(ServerPlayerEntity player) {
            if (data.isDead) {
                this.data.isDead = false;
                teleportPlayerBack(player);
            }
        }

        @Override
        public float getLootMultiplier(PlayerEntity player) {

            if (WorldUtils.isMapWorldClass(player.world)) {
                if (data.questFinished) {
                    return 0.3F;
                }
            }

            return 1;
        }

        @Override
        public String getLastMapGUID() {
            return this.getMap().mapUUID;
        }

        @Override
        public boolean hasTimeForMap() {
            return this.getMinutesLeft() > 0;
        }

        @Override
        public int getMinutesPassed() {
            return this.data.minutesPassed;
        }

        @Override
        public MapItemData getMap() {
            if (data != null && data.mapdata != null) {
                return this.data.mapdata;
            } else {
                return MapItemData.empty();
            }
        }

        @Override
        public BlockPos getMapDevicePos() {
            return data.mapDevicePos.south(3);
        }

        @Override
        public DimensionType getOriginalDimension() {
            return data.getOriginalDimension();
        }

        private static void error(String str) {
            System.out.println("[Mine and Slash Map Error]: " + str);
        }

        @Override
        public void teleportPlayerBack(PlayerEntity player) {

            if (WorldUtils.isMapWorld(player.world)) {

                BlockPos pos = getMapDevicePos();

                if (pos == null) {
                    error("Map device pos is null");

                    pos = player.getBedLocation();

                    if (pos == null) {
                        error("Bed location attempt:1 is null");
                    }

                    try {
                        Optional<BlockPos> opt = player.getBedPosition();
                        if (opt.isPresent()) {
                            pos = opt.get();
                        }
                    } catch (Exception e) {
                        error("Bed location attempt:2 is null");
                    }
                }
                if (pos == null) {
                    try {
                        pos = MapManager.getWorld(DimensionType.OVERWORLD).getSpawnPoint();
                    } catch (Exception e) {
                        error("Last safeguard failed, can't even get spawn point of overworld");
                        e.printStackTrace();
                        pos = new BlockPos(0, 90, 0);
                    }
                }

                pos = pos.north(2);
                PlayerUtils.changeDimension((ServerPlayerEntity) player, data.getOriginalDimension(), pos);

            }
        }

        private void announceEnd(PlayerEntity player) {

            player.sendMessage(Chats.Ran_Out_Of_Time.locName());

        }

        private void announceTimeLeft(PlayerEntity player) {

            player.sendMessage(Chats.Remaining_Map_Time_is.locName()
                                       .appendText(" " + this.getMinutesLeft() + " ")
                                       .appendSibling(Words.Minutes.locName()));

        }

        private int getMinutesLeft() {
            return this.getMap().minutes - this.data.minutesPassed;

        }
    }

    public static class Storage extends BaseStorage<IPlayerMapData> {

    }

}
