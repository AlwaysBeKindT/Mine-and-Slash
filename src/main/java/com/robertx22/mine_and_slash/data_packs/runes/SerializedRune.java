package com.robertx22.mine_and_slash.data_packs.runes;

import com.robertx22.mine_and_slash.database.runes.base.BaseRune;
import com.robertx22.mine_and_slash.database.runes.base.RuneItem;
import com.robertx22.mine_and_slash.database.stats.StatMod;

import java.util.HashMap;
import java.util.List;

public class SerializedRune extends BaseRune {

    String guid;
    int weight;
    int tier;
    List<StatMod> weapon;
    List<StatMod> armor;
    List<StatMod> jewerly;

    public SerializedRune(boolean isUnique, String guid, int weight, int tier, List<StatMod> weapon, List<StatMod> armor, List<StatMod> jewerly, HashMap<Integer, RuneItem> ItemMap) {
        super(false);
        this.guid = guid;
        this.weight = weight;
        this.tier = tier;
        this.weapon = weapon;
        this.armor = armor;
        this.jewerly = jewerly;
        this.itemMap = ItemMap;
    }

    @Override
    public String name() {
        return guid;
    }

    @Override
    public List<StatMod> weaponStat() {
        return weapon;
    }

    @Override
    public List<StatMod> armorStat() {
        return armor;
    }

    @Override
    public List<StatMod> jewerlyStat() {
        return jewerly;
    }
}
