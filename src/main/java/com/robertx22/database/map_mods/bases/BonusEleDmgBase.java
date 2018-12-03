package com.robertx22.database.map_mods.bases;

import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public abstract class BonusEleDmgBase extends StatMod {

    @Override
    public int Min() {
	return 25;
    }

    @Override
    public int Max() {
	return 75;
    }

    @Override
    public StatTypes Type() {
	return StatTypes.Flat;
    }

}