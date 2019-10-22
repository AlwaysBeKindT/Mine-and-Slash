package com.robertx22.compat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableList;
import com.robertx22.api.MineAndSlashAPI;
import com.robertx22.config.non_mine_items.ConfigItem;
import com.robertx22.database.gearitemslots.Axe;
import com.robertx22.database.gearitemslots.Bow;
import com.robertx22.database.gearitemslots.Hammer;
import com.robertx22.database.gearitemslots.Necklace;
import com.robertx22.database.gearitemslots.Staff;
import com.robertx22.database.gearitemslots.Sword;
import com.robertx22.database.gearitemslots.Helmet;
import com.robertx22.database.gearitemslots.Chest;
import com.robertx22.database.gearitemslots.Pants;
import com.robertx22.database.gearitemslots.Boots;

public class fireice {

	private static final Logger LOGGER = LogManager.getLogger();

	private static final List<String> HAMMER = ImmutableList.of("troll_weapon.trunk_frost", "troll_weapon.trunk",
			"troll_weapon.hammer", "troll_weapon.column", "troll_weapon.column_frost", "troll_weapon.column_forest");

	public fireice() {
		String a = "iceandfire:";
		List<String> s = HAMMER;

		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_staff", new ConfigItem().setType(new Staff())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_staff", new ConfigItem().setType(new Staff())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "dragon_stick",
				new ConfigItem().setType(new Sword()).setSalvagable(false).setMinLevel(60));
		LOGGER.debug("Registered Staffs");
		MineAndSlashAPI.addCompatibleItem("iceandfire:" + s, new ConfigItem().setType(new Hammer()).setMinLevel(80));
		LOGGER.debug("Registered Hammers");
		MineAndSlashAPI.addCompatibleItem("iceandfire:dragonbone_bow",
				new ConfigItem().setType(new Bow()).setSalvagable(false).setMinLevel(30));
		MineAndSlashAPI.addCompatibleItem("iceandfire:stymphalian_feather_bundle",
				new ConfigItem().setType(new Bow()).setSalvagable(false).setMinLevel(5));
		LOGGER.debug("Registered Bows");
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_sword", new ConfigItem().setType(new Sword())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_sword_venom", new ConfigItem().setType(new Sword())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_sword", new ConfigItem().setType(new Sword())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_sword_venom", new ConfigItem().setType(new Sword())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "silver_sword", new ConfigItem().setType(new Sword()).setMaxRarity(1)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		MineAndSlashAPI.addCompatibleItem(a + "stymphalian_bird_dagger", new ConfigItem().setType(new Sword())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "hippogryph_sword", new ConfigItem().setType(new Sword()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "dragonbone_sword",
				new ConfigItem().setType(new Sword()).setSalvagable(false).setMinLevel(60));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_ice_sword",
				new ConfigItem().setType(new Sword()).setSalvagable(false).setMinLevel(90));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_fire_sword",
				new ConfigItem().setType(new Sword()).setSalvagable(false).setMinLevel(90));
		LOGGER.debug("Registered Swords");
		MineAndSlashAPI.addCompatibleItem(a + "sheep_helmet", new ConfigItem().setType(new Helmet()).setMaxRarity(0)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_metal_helmet",
				new ConfigItem().setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		MineAndSlashAPI.addCompatibleItem(a + "armor_red_helmet", new ConfigItem().setType(new Helmet()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_bronze_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_green_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_gray_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_blue_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_white_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_sapphire_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_blue_helmet", new ConfigItem().setType(new Helmet()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_bronze_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_deepblue_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_purple_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_red_helmet", new ConfigItem().setType(new Helmet()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_teal_helmet", new ConfigItem().setType(new Helmet()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_yellow_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_white_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_red_helmet", new ConfigItem().setType(new Helmet())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "minecraft:diamond_helmet",
				new ConfigItem().setType(new Helmet()).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(a + "forest_troll_leather_helmet",
				new ConfigItem().setType(new Helmet()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "frost_troll_leather_helmet",
				new ConfigItem().setType(new Helmet()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "mountain_troll_leather_helmet",
				new ConfigItem().setType(new Helmet()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_ice_helmet",
				new ConfigItem().setType(new Helmet()).setSalvagable(false).setMinLevel(90));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_fire_helmet",
				new ConfigItem().setType(new Helmet()).setSalvagable(false).setMinLevel(90));
		LOGGER.debug("Registered Helmet");
		MineAndSlashAPI.addCompatibleItem(a + "sheep_boots", new ConfigItem().setType(new Boots()).setMaxRarity(0)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_metal_boots",
				new ConfigItem().setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		MineAndSlashAPI.addCompatibleItem(a + "armor_red_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_bronze_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_green_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_gray_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_blue_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_white_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "sheep_chestplate", new ConfigItem().setType(new Chest()).setMaxRarity(0)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_metal_chestplate",
				new ConfigItem().setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		MineAndSlashAPI.addCompatibleItem(a + "armor_red_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_bronze_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_green_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_gray_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_blue_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_white_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_sapphire_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_blue_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_bronze_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_deepblue_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_purple_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_red_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_teal_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_yellow_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_white_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_red_chestplate", new ConfigItem().setType(new Chest())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "minecraft:diamond_chestplate",
				new ConfigItem().setType(new Chest()).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(a + "forest_troll_leather_chestplate",
				new ConfigItem().setType(new Chest()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "frost_troll_leather_chestplate",
				new ConfigItem().setType(new Chest()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "mountain_troll_leather_chestplate",
				new ConfigItem().setType(new Chest()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_ice_chestplate",
				new ConfigItem().setType(new Chest()).setSalvagable(false).setMinLevel(90));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_fire_chestplate",
				new ConfigItem().setType(new Chest()).setSalvagable(false).setMinLevel(90));
		LOGGER.debug("Registered Chestplate");
		MineAndSlashAPI.addCompatibleItem(a + "sheep_leggings", new ConfigItem().setType(new Pants()).setMaxRarity(0)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_desert_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "myrmex_jungle_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(0).setSalvagable(false).setAlwaysNormal().setMaxLevel(10));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_metal_leggings",
				new ConfigItem().setSalvagable(false).setAlwaysNormal().setMaxLevel(20));
		MineAndSlashAPI.addCompatibleItem(a + "armor_red_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_bronze_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_green_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_gray_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_blue_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_white_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_sapphire_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_blue_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_bronze_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_deepblue_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_purple_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_red_leggings", new ConfigItem().setType(new Pants()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_teal_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_yellow_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_white_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_red_leggings", new ConfigItem().setType(new Pants())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "minecraft:diamond_leggings",
				new ConfigItem().setType(new Pants()).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(a + "forest_troll_leather_leggings",
				new ConfigItem().setType(new Pants()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "frost_troll_leather_leggings",
				new ConfigItem().setType(new Pants()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "mountain_troll_leather_leggings",
				new ConfigItem().setType(new Pants()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_ice_leggings",
				new ConfigItem().setType(new Pants()).setSalvagable(false).setMinLevel(90));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_fire_leggings",
				new ConfigItem().setType(new Pants()).setSalvagable(false).setMinLevel(90));
		LOGGER.debug("Registered Leggings");
		MineAndSlashAPI.addCompatibleItem(a + "armor_sapphire_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "armor_silver_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_blue_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_bronze_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_deepblue_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_purple_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_red_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "tide_teal_boots", new ConfigItem().setType(new Boots()).setMaxRarity(2)
				.setSalvagable(false).setAlwaysNormal().setMaxLevel(30));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_yellow_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_white_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "deathworm_red_boots", new ConfigItem().setType(new Boots())
				.setMaxRarity(2).setSalvagable(false).setAlwaysNormal().setMaxLevel(40));
		MineAndSlashAPI.addCompatibleItem(a + "minecraft:diamond_boots",
				new ConfigItem().setType(new Boots()).setSalvagable(false).setMinLevel(50));
		MineAndSlashAPI.addCompatibleItem(a + "forest_troll_leather_boots",
				new ConfigItem().setType(new Boots()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "frost_troll_leather_boots",
				new ConfigItem().setType(new Boots()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "mountain_troll_leather_boots",
				new ConfigItem().setType(new Boots()).setMinLevel(80));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_ice_boots",
				new ConfigItem().setType(new Boots()).setSalvagable(false).setMinLevel(90));
		MineAndSlashAPI.addCompatibleItem(a + "dragonsteel_fire_boots",
				new ConfigItem().setType(new Boots()).setSalvagable(false).setMinLevel(90));
		LOGGER.debug("Registered Boots");
	}

}
