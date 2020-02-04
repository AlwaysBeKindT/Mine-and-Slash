package com.robertx22.mine_and_slash.database.spells.spell_classes.ocean_mystic;

import com.robertx22.mine_and_slash.database.spells.entities.proj.GeyserEntity;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseProjectileSpell;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.registers.common.Sounds;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.saveclasses.spells.SpellCalcData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.SpellSchools;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GeyserSpell extends BaseProjectileSpell {

    private GeyserSpell() {
    }

    public static GeyserSpell getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public SpellSchools getSchool() {
        return SpellSchools.OCEAN_MYSTIC;
    }

    @Override
    public int getCooldownInSeconds() {
        return 60;
    }

    public static float RADIUS = 1.5F;

    @Override
    public BaseSpell.SpellType getSpellType() {
        return SpellType.LASTING_AOE;
    }

    @Override
    public AbstractArrowEntity newEntity(World world) {
        return new GeyserEntity(world);
    }

    @Override
    public SoundEvent getShootSound() {
        return Sounds.SPLASH;
    }

    @Override
    public float getShootSpeed() {
        return 1F;
    }

    @Override
    public String GUID() {
        return "geyser";
    }

    @Override
    public int getManaCost() {
        return 50;
    }

    @Override
    public int useTimeTicks() {
        return 30;
    }

    @Override
    public SpellCalcData getCalculation() {
        return SpellCalcData.one(dmgStat(), 0.4F, 5);
    }

    @Override
    public Elements getElement() {
        return Elements.Water;
    }

    @Override
    public List<ITextComponent> GetDescription(TooltipInfo info) {

        List<ITextComponent> list = new ArrayList<>();

        list.add(new StringTextComponent("Summons a Geyser that heals allies inside."));

        list.addAll(getCalculation().GetTooltipString(info));

        return list;

    }

    @Override
    public Words getName() {
        return Words.Geyser;
    }

    private static class SingletonHolder {
        private static final GeyserSpell INSTANCE = new GeyserSpell();
    }
}