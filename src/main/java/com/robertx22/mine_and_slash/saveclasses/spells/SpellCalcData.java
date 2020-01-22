package com.robertx22.mine_and_slash.saveclasses.spells;

import com.robertx22.mine_and_slash.database.stats.Stat;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.ITooltipList;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.TooltipInfo;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;
import info.loenwind.autosave.annotations.Storable;
import info.loenwind.autosave.annotations.Store;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import java.util.ArrayList;
import java.util.List;

@Storable
public class SpellCalcData implements ITooltipList {

    public static SpellCalcData one(Stat stat, float multi, int base) {
        SpellCalcData data = new SpellCalcData();

        data.scalingValues.add(new StatCalc(stat, multi));
        data.baseValue = base;

        return data;
    }

    private SpellCalcData() {

    }

    public SpellCalcData(StatCalc calc, int base) {
        this.scalingValues.add(calc);
        this.baseValue = base;
    }

    @Store
    public List<StatCalc> scalingValues = new ArrayList<>();

    @Store
    public StatScaleType baseScaling = StatScaleType.NORMAL;

    @Store
    public int baseValue = 0;

    public int getCalculatedBaseValue(EntityCap.UnitData data) {
        return (int) baseScaling.scale(baseValue, data.getLevel());
    }

    public int getCalculatedScalingValue(EntityCap.UnitData data) {
        return scalingValues.stream().mapToInt(x -> x.getCalculatedValue(data)).sum();
    }

    public int getCalculatedValue(EntityCap.UnitData data) {
        int val = getCalculatedScalingValue(data);
        val += getCalculatedBaseValue(data);
        return val;

    }

    @Override
    public List<ITextComponent> GetTooltipString(TooltipInfo info) {

        List<ITextComponent> list = new ArrayList<>();

        for (StatCalc calc : this.scalingValues) {
            Stat stat = calc.getStat();

            list.add(new StringTextComponent(
                    "Scales with " + (int) (calc.multi * 100F) + "%" + stat.getElement().format + stat.getElement().icon + " ")
                             .appendSibling(stat.locName()));
        }

        list.add(new StringTextComponent("Base value: " + baseValue));

        return list;
    }
}
