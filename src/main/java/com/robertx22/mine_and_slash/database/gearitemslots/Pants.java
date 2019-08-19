package com.robertx22.mine_and_slash.database.gearitemslots;

import com.robertx22.mine_and_slash.database.gearitemslots.bases.BaseArmor;
import com.robertx22.mine_and_slash.items.gearitems.armor.ItemPants;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;

public class Pants extends BaseArmor {

    @Override
    public String GUID() {
        return "Pants";
    }

    @Override
    public Item DefaultItem() {
        return ItemPants.Items.get(0);
    }

    @Override
    public boolean isGearOfThisType(Item item) {
        return item instanceof ArmorItem && ((ArmorItem) item).getEquipmentSlot()
                .equals(EquipmentSlotType.LEGS);
    }

    @Override
    public HashMap<Integer, Item> ItemsForRarities() {
        return ItemPants.Items;
    }

    @Override
    public String locNameForLangFile() {
        return "Pants";
    }
}
