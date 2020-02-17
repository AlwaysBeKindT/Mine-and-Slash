package com.robertx22.mine_and_slash.data_packs.compatible_items;

import com.google.gson.JsonObject;
import com.robertx22.mine_and_slash.onevent.data_gen.ISerializable;
import com.robertx22.mine_and_slash.onevent.data_gen.ISerializedRegistryEntry;
import com.robertx22.mine_and_slash.registry.SlashRegistryType;

public class CompatibleItem implements ISerializable<CompatibleItem>, ISerializedRegistryEntry<CompatibleItem> {

    public static CompatibleItem EMPTY = new CompatibleItem();

    public String item_type = "sword";
    public String guid = "guid_for_this_entry";
    public String item_id = "item_id";

    public int unique_item_weight = 0;
    public int normal_item_weight = 80;
    public int runed_item_weight = 20;

    public int min_rarity = 0;
    public int max_rarity = 5;

    public boolean only_add_stats_if_loot_drop = false;
    public boolean add_to_loot_drops = true;
    public int loot_drop_weight = 1000;
    public boolean can_be_salvaged = false;

    public int level_variance = 0;
    public int min_level = 1;
    public int max_level = 100;

    public int if_unique_random_up_to_tier = 10;
    public String unique_id = "";

    @Override
    public JsonObject toJson() {
        JsonObject json = new JsonObject();

        json.addProperty("item_type", item_type);
        json.addProperty("guid", guid);

        JsonObject gearType = new JsonObject();
        gearType.addProperty("normal_item_weight", normal_item_weight);
        gearType.addProperty("runed_item_weight", runed_item_weight);
        gearType.addProperty("unique_item_weight", unique_item_weight);
        json.add("gear_type", gearType);

        JsonObject rarity = new JsonObject();
        rarity.addProperty("min_rarity", min_rarity);
        rarity.addProperty("max_rarity", max_rarity);
        json.add("rarity", rarity);

        JsonObject Misc = new JsonObject();
        Misc.addProperty("only_add_stats_if_loot_drop", only_add_stats_if_loot_drop);
        Misc.addProperty("add_to_loot_drops", add_to_loot_drops);
        Misc.addProperty("loot_drop_weight", loot_drop_weight);
        Misc.addProperty("can_be_salvaged", can_be_salvaged);
        json.add("misc", Misc);

        JsonObject level = new JsonObject();
        level.addProperty("min_level", min_level);
        level.addProperty("max_level", max_level);
        level.addProperty("level_variance", level_variance);
        json.add("level", level);

        JsonObject unique = new JsonObject();
        unique.addProperty("if_unique_random_up_to_tier", if_unique_random_up_to_tier);
        unique.addProperty("unique_id", unique_id);
        json.add("unique", unique);

        return json;
    }

    @Override
    public CompatibleItem fromJson(JsonObject json) {
        CompatibleItem obj = new CompatibleItem();

        obj.item_type = json.get("item_type")
            .getAsString();
        obj.guid = json.get("guid")
            .getAsString();

        JsonObject gearType = json.getAsJsonObject("gear_type");
        obj.normal_item_weight = gearType.get("normal_item_weight")
            .getAsInt();
        obj.runed_item_weight = gearType.get("runed_item_weight")
            .getAsInt();
        obj.unique_item_weight = gearType.get("unique_item_weight")
            .getAsInt();

        JsonObject rarity = json.getAsJsonObject("rarity");
        obj.min_rarity = rarity.get("min_rarity")
            .getAsInt();
        obj.max_rarity = rarity.get("max_rarity")
            .getAsInt();

        JsonObject misc = json.getAsJsonObject("misc");
        obj.only_add_stats_if_loot_drop = misc.get("only_add_stats_if_loot_drop")
            .getAsBoolean();
        obj.add_to_loot_drops = misc.get("add_to_loot_drops")
            .getAsBoolean();
        obj.loot_drop_weight = misc.get("loot_drop_weight")
            .getAsInt();
        obj.can_be_salvaged = misc.get("can_be_salvaged")
            .getAsBoolean();

        JsonObject level = json.getAsJsonObject("level");
        obj.min_level = level.get("min_level")
            .getAsInt();
        obj.max_level = level.get("max_level")
            .getAsInt();
        obj.level_variance = level.get("level_variance")
            .getAsInt();

        JsonObject unique = json.getAsJsonObject("unique");
        obj.if_unique_random_up_to_tier = unique.get("if_unique_random_up_to_tier")
            .getAsInt();
        obj.unique_id = unique.get("unique_id")
            .getAsString();

        return obj;
    }

    @Override
    public SlashRegistryType getSlashRegistryType() {
        return SlashRegistryType.COMPATIBLE_ITEM;
    }

    @Override
    public boolean isFromDatapack() {
        return true;
    }

    @Override
    public String GUID() {
        return guid;
    }

    //this is how the file should look and be separated into
    /*

        public String item_type = "Sword";


    class GearType {
            public int unique_item_weight = 0;
            public int normal_item_weight = 80;
            public int runed_item_weight = 20;
        }

    class Rarity {
        public int min_rarity = 0;
        public int max_rarity = 5;
    }

    class Misc {
        public boolean only_add_stats_if_loot_drop = false;
        public boolean add_to_loot_drops = true;
        public int loot_drop_weight = 1000;

        public boolean can_be_salvaged = false;
    }

    class Level {
        public int level_variance = 0;
        public int min_level = 1;
        public int max_level = 100;
    }

    class IfUnique {
        public int if_unique_random_up_to_tier = 10;
        public String unique_id = "";
    }

     */

}
