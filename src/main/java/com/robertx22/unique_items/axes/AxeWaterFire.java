package com.robertx22.unique_items.axes;

import java.util.Arrays;
import java.util.List;

import com.robertx22.database.stat_mods.flat.elemental.attack_dmg.AttackFireDamageFlat;
import com.robertx22.database.stat_mods.flat.elemental.attack_dmg.AttackWaterDamageFlat;
import com.robertx22.database.stat_mods.percent.CriticalDamagePercent;
import com.robertx22.database.stat_mods.percent.CriticalHitPercent;
import com.robertx22.database.stat_mods.percent.less.LessLifeOnHitPercent;
import com.robertx22.database.stat_mods.percent.less.LessLifestealPercent;
import com.robertx22.database.stat_mods.percent.less.LessManaOnHitPercent;
import com.robertx22.stats.StatMod;
import com.robertx22.unique_items.bases.BaseUniqueAxe;

public class AxeWaterFire extends BaseUniqueAxe {
    public AxeWaterFire() {

    }

    @Override
    public int Tier() {
	return 16;
    }

    @Override
    public String name() {
	return "Axe of Frostfire";

    }

    @Override
    public String GUID() {
	return "axewaterfire0";
    }

    @Override
    public List<StatMod> uniqueStats() {
	return Arrays.asList(new AttackFireDamageFlat(), new AttackWaterDamageFlat(), new CriticalHitPercent(),
		new CriticalDamagePercent(), new LessLifestealPercent(), new LessLifeOnHitPercent(),
		new LessManaOnHitPercent());
    }

    @Override
    public String description() {
	return "My efforts to merge elements shall not be in vain.";
    }
}
