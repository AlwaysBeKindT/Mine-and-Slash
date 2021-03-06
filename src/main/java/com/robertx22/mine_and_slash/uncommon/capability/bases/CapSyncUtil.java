package com.robertx22.mine_and_slash.uncommon.capability.bases;

import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.uncommon.capability.player.PlayerMapCap;
import com.robertx22.mine_and_slash.uncommon.capability.player.PlayerSpellCap;
import com.robertx22.mine_and_slash.uncommon.capability.player.PlayerStatsPointsCap;
import com.robertx22.mine_and_slash.uncommon.capability.player.PlayerTalentsCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.entity.player.PlayerEntity;

public class CapSyncUtil {

    public static void syncAll(PlayerEntity player) {
        syncEntityCap(player);
        syncMapCap(player);
        syncTalents(player);
        syncSpells(player);
        syncStatAlloc(player);
    }

    public static void syncSpells(PlayerEntity player) {
        PlayerSpellCap.ISpellsCap data = Load.spells(player);
        data.syncToClient(player);
    }

    public static void syncStatAlloc(PlayerEntity player) {
        PlayerStatsPointsCap.IPlayerStatPointsData data = Load.statPoints(player);
        data.syncToClient(player);
    }

    public static void syncEntityCap(PlayerEntity player) {
        EntityCap.UnitData data = Load.Unit(player);
        data.syncToClient(player);
    }

    public static void syncMapCap(PlayerEntity player) {
        PlayerMapCap.IPlayerMapData data = Load.playerMapData(player);
        data.syncToClient(player);
    }

    public static void syncTalents(PlayerEntity player) {
        PlayerTalentsCap.IPlayerTalentsData data = Load.talents(player);
        data.syncToClient(player);
    }

}
