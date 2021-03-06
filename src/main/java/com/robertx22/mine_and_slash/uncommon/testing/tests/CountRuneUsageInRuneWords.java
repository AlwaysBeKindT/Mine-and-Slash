package com.robertx22.mine_and_slash.uncommon.testing.tests;

import com.robertx22.mine_and_slash.database.runes.base.BaseRune;
import com.robertx22.mine_and_slash.database.runewords.RuneWord;
import com.robertx22.mine_and_slash.registry.SlashRegistry;

import java.util.HashMap;

public class CountRuneUsageInRuneWords {

    public static void doit() {

        HashMap<String, Integer> all = new HashMap();

        for (RuneWord word : SlashRegistry.RuneWords()
            .getAll()
            .values()) {

            for (BaseRune rune : word.runes()) {

                int i = 0;
                if (all.containsKey(rune.name())) {
                    i = all.get(rune.name());
                }
                i++;
                all.put(rune.name(), i);

            }

        }

        System.out.println(all);
        // System.out.println(all.keySet());
        // System.out.println(all.entrySet());

    }
}
