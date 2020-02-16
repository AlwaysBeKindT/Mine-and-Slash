package com.robertx22.mine_and_slash.database.gearitemslots.bases;

import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.defense.ArmorFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.defense.BlockStrengthFlat;

import java.util.Arrays;
import java.util.List;

public abstract class BaseOffHand extends GearItemSlot {

    @Override
    public final int Weight() {
        return super.Weight() / 2;
    }

    @Override
    public List<PosStats> PrimaryStats() {
        return Arrays.asList(new PosStats(new BlockStrengthFlat()));
    }

    @Override
    public List<StatMod> PossibleSecondaryStats() {
        return Arrays.asList(new ArmorFlat());
    }

    @Override
    public GearSlotType slotType() {
        return GearSlotType.OffHand;
    }
}
