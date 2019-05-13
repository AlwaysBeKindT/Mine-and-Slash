package com.robertx22.stats.stat_effects.spell_buffs;

import com.robertx22.effectdatas.interfaces.IBuffableSpell.SpellBuffType;
import com.robertx22.spells.bases.BaseSpell.SpellType;
import com.robertx22.stats.stat_effects.spell_buffs.base.BaseSpellBuff;

public class HomingBuff extends BaseSpellBuff {

    @Override
    public int GetPriority() {
	return 10;
    }

    @Override
    public SpellType typeOfSpellAffected() {
	return SpellType.Single_Target_Projectile;
    }

    @Override
    public SpellBuffType buffType() {
	return SpellBuffType.Homing_Projectile;
    }

}