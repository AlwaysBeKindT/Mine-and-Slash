package com.robertx22.mine_and_slash.items.gearitems.armor.plate;

import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.items.gearitems.bases.BaseArmorItem;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;

import java.util.HashMap;

public class PlatePantsItem extends BaseArmorItem {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public PlatePantsItem(int rarity) {
        super(Type.PLATE, rarity, EquipmentSlotType.LEGS);

    }

    @Override
    public String locNameForLangFile() {
        Rarity rar = Rarities.Gears.get(rarity);
        return rar.textFormatting() + "Plate Greaves";
    }
}
