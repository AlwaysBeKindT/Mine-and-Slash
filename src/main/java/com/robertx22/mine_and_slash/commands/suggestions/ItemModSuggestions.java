package com.robertx22.mine_and_slash.commands.suggestions;

import com.robertx22.mine_and_slash.registry.SlashRegistry;

import java.util.List;
import java.util.stream.Collectors;

public class ItemModSuggestions extends CommandSuggestions {

    @Override
    public List<String> suggestions() {
        return SlashRegistry.ItemModifications()
            .getList()
            .stream()
            .map(x -> x.GUID())
            .collect(Collectors.toList());
    }

}
