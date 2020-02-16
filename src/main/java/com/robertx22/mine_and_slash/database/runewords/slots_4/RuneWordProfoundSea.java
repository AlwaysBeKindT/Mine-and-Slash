package com.robertx22.mine_and_slash.database.runewords.slots_4;

import com.robertx22.mine_and_slash.database.items.runes.AnoItem;
import com.robertx22.mine_and_slash.database.items.runes.CenItem;
import com.robertx22.mine_and_slash.database.items.runes.DosItem;
import com.robertx22.mine_and_slash.database.items.runes.RahItem;
import com.robertx22.mine_and_slash.database.items.runes.base.BaseRuneItem;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.database.stats.StatMod;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.HighManaFlat;
import com.robertx22.mine_and_slash.database.stats.mods.flat.resources.ManaRegenFlat;

import java.util.Arrays;
import java.util.List;

public class RuneWordProfoundSea extends RuneWord {

    @Override
    public List<StatMod> mods() {
        return Arrays.asList(new ManaRegenFlat(), new HighManaFlat());
    }

    @Override
    public String GUID() {
        return "profound_sea";
    }

    @Override
    public List<BaseRuneItem> runes() {
        return Arrays.asList(new DosItem(0), new AnoItem(0), new RahItem(0), new CenItem(0));

    }

    @Override
    public String locNameForLangFile() {
        return "Profound Sea";
    }
}
