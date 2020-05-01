package com.robertx22.mine_and_slash.data_generation.unique_dungeons;

import com.google.gson.JsonObject;
import com.robertx22.mine_and_slash.onevent.data_gen.ISerializable;
import com.robertx22.mine_and_slash.onevent.data_gen.ISerializedRegistryEntry;
import com.robertx22.mine_and_slash.registry.SlashRegistryType;
import net.minecraft.util.math.BlockPos;

public class UniqueDungeon implements ISerializedRegistryEntry<UniqueDungeon>, ISerializable<UniqueDungeon> {

    String guid;
    public int lvl;
    public BlockPos entrancePos;
    int tier = 0;

    public static UniqueDungeon EMPTY = new UniqueDungeon("", 1, BlockPos.ZERO, 0);

    public UniqueDungeon(String guid, int lvl, BlockPos entrancePos, int tier) {
        this.guid = guid;
        this.lvl = lvl;
        this.tier = tier;
        this.entrancePos = entrancePos;
    }

    @Override
    public JsonObject toJson() {

        JsonObject json = new JsonObject();
        json.addProperty(ID, GUID());
        json.addProperty("level", lvl);
        json.addProperty("tier", tier);

        JsonObject entrance = new JsonObject();
        entrance.addProperty("x", entrancePos.getX());
        entrance.addProperty("y", entrancePos.getY());
        entrance.addProperty("z", entrancePos.getZ());
        json.add("entrance_pos", entrance);

        return json;
    }

    @Override
    public UniqueDungeon fromJson(JsonObject json) {

        int lvl = json.get("level")
            .getAsInt();
        int tier = json.get("tier")
            .getAsInt();
        String guid = getGUIDFromJson(json);

        JsonObject entrance = json.getAsJsonObject("entrance_pos");
        int x = entrance.get("x")
            .getAsInt();
        int y = entrance.get("y")
            .getAsInt();
        int z = entrance.get("z")
            .getAsInt();

        return new UniqueDungeon(guid, lvl, new BlockPos(x, y, z), tier);
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    public SlashRegistryType getSlashRegistryType() {
        return SlashRegistryType.UNIQUE_DUNGEON;
    }

    @Override
    public String GUID() {
        return this.guid;
    }
}
