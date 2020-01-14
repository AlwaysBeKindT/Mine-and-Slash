package com.robertx22.mine_and_slash.database.spells.items.aoe_projectile;

import com.robertx22.mine_and_slash.database.spells.spell_classes.aoe_projectile.SpellLightningExplosion;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemLightningExplosion extends BaseExplosionItem {

    public ItemLightningExplosion() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_lightningexplosion")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellLightningExplosion();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_lightningexplosion";
    }

}