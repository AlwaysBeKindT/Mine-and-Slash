package com.robertx22.mine_and_slash.database.rarities.containers;

import com.robertx22.mine_and_slash.database.rarities.BaseRaritiesContainer;
import com.robertx22.mine_and_slash.database.rarities.MobRarity;
import com.robertx22.mine_and_slash.database.rarities.RarityTypeEnum;
import com.robertx22.mine_and_slash.database.rarities.mobs.*;

import java.util.Arrays;
import java.util.List;

public class MobRarities extends BaseRaritiesContainer<MobRarity> {

    public MobRarities() {
        super();
        add(CommonMob.getInstance());
        add(UncommonMob.getInstance());
        add(RareMob.getInstance());
        add(EpicMob.getInstance());
        add(LegendaryMob.getInstance());
        add(BossMobRarity.getInstance());
        add(MinionMobRarity.getInstance());

        this.onInit();
    }

    @Override
    public RarityTypeEnum getType() {
        return null;
    }

    public List<MobRarity> getElite() {
        return Arrays.asList(LegendaryMob.getInstance(), EpicMob.getInstance(), RareMob.getInstance());
    }

}


