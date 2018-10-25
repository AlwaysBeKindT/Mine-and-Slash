package com.robertx22.customitems.spells;

import com.robertx22.customitems.bases.BaseSpellItem;
import com.robertx22.mmorpg.Ref;
import com.robertx22.spells.bases.BaseSpell;
import com.robertx22.spells.projectile.acidbolt.SpellAcidBolt;
import com.robertx22.uncommon.utilityclasses.RegisterUtils;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class ItemAcidBolt extends BaseSpellItem {

	public ItemAcidBolt() {
		super();
	}

	@GameRegistry.ObjectHolder(Ref.MODID + ":spell_acidbolt")
	public static final Item ITEM = null;

	@Override
	public String Name() {
		return "Acid Bolt";

	}

	@Override
	public BaseSpell Spell() {
		return new SpellAcidBolt();
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemAcidBolt());
	}

	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		RegisterUtils.registerRender(ITEM);
	}

	@Override
	public String GUID() {
		return Ref.MODID + ":spell_acidbolt";
	}

}