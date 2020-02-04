package com.robertx22.mine_and_slash.onevent.player;

import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnPlayerClone {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerClone(PlayerEvent.Clone event) {

        PlayerEntity original = event.getOriginal();
        PlayerEntity current = event.getPlayer();

        try {
            EntityCap.UnitData data = Load.Unit(current);
            data.loadFromNBT(Load.Unit(original).saveToNBT());
            data.syncToClient(current);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Load.playerMapData(current).loadFromNBT(Load.playerMapData(original).saveToNBT());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Load.statPoints(current).loadFromNBT(Load.statPoints(original).saveToNBT());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Load.professions(current).loadFromNBT(Load.professions(original).saveToNBT());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Load.talents(current).loadFromNBT(Load.talents(original).saveToNBT());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Load.spells(current).loadFromNBT(Load.spells(original).saveToNBT());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    /*
    public static final String ENTITY_DATA_BACKUP = "mmorpg:entity_data_backup";
    public static final String PLAYER_MAP_DATA_BACKUP = "mmorpg:player_map_data_backup";

    @SubscribeEvent
    public static void onSave(PlayerEvent.SaveToFile event) {
        PlayerEntity player = event.getEntityPlayer();

        CompoundNBT unitdatanbt = null;
        try {
            unitdatanbt = Load.Unit(player).getNBT();
        } catch (Exception e) {
            e.printStackTrace();
        }
        CompoundNBT playermapdatanbt = null;
        try {
            playermapdatanbt = Load.playerMapData(player).getNBT();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CompoundNBT pesrsistentNBT = null;
        try {
            pesrsistentNBT = PlayerUtils.getPersistentNBT(player);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (pesrsistentNBT != null) {

            if (unitdatanbt != null) {
                pesrsistentNBT.put(ENTITY_DATA_BACKUP, unitdatanbt);
            }
            if (playermapdatanbt != null) {
                pesrsistentNBT.put(PLAYER_MAP_DATA_BACKUP, playermapdatanbt);
            }

            PlayerUtils.setPestistentNBT(player, pesrsistentNBT);

        }

    }

    // TODO THIS NEEDS A FORGE FIX. EITHER THAT OR I BASICALLY MAKE MY OWN SAVE SYSTEM (OR USE ENTITYDATA.PERSISTENT TAG
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerClone(PlayerEvent.Clone event) {

        PlayerEntity original = event.getOriginal();

        CompoundNBT backupNBT = PlayerUtils.getPersistentNBT(original);

        try {
            CompoundNBT unitdataNBT = backupNBT.getCompound(ENTITY_DATA_BACKUP);
            Load.Unit(event.getEntityPlayer()).setNBT(unitdataNBT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CompoundNBT playermapdataNBT = backupNBT.getCompound(PLAYER_MAP_DATA_BACKUP);
            Load.playerMapData(event.getEntityPlayer()).setNBT(playermapdataNBT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    */

}
