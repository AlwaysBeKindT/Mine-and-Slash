package com.robertx22.mine_and_slash.database.spells.items.aoe_projectile;

import com.robertx22.mine_and_slash.database.spells.spell_classes.aoe_projectile.SpellAcidExplosion;
import com.robertx22.mine_and_slash.database.spells.spell_classes.bases.BaseSpell;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemAcidExplosion extends BaseExplosionItem {

    public ItemAcidExplosion() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_acidexplosion")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellAcidExplosion();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_acidexplosion";
    }

}