package com.robertx22.database.map_mods.bonus.ele_dmg;

import com.robertx22.database.map_mods.bases.BonusEleDmgBase;
import com.robertx22.database.stats.types.offense.bonus.BonusFireDamage;
import com.robertx22.stats.Stat;

public class BonusFireDamageMap extends BonusEleDmgBase {

	public BonusFireDamageMap() {
	}

	@Override
	public String GUID() {
		return "BonusFireDamageMap";
	}

	@Override
	public Stat GetBaseStat() {
		return new BonusFireDamage();
	}

}