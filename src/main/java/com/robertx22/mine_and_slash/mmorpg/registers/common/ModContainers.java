package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.blocks.item_modify_station.ContainerGearModify;
import com.robertx22.mine_and_slash.blocks.map_device.ContainerMapDevice;
import com.robertx22.mine_and_slash.blocks.repair_station.ContainerGearRepair;
import com.robertx22.mine_and_slash.blocks.salvage_station.ContainerGearSalvage;
import com.robertx22.mine_and_slash.db_lists.CreativeTabs;
import com.robertx22.mine_and_slash.items.bags.currency_bag.ContainerCurrencyBag;
import com.robertx22.mine_and_slash.items.bags.loot_bag.ContainerLootBag;
import com.robertx22.mine_and_slash.items.bags.map_bag.ContainerMapBag;
import com.robertx22.mine_and_slash.items.bags.master_bag.ContainerMasterBag;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.new_content.chests.MapChestContainer;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModContainers {

    public static DeferredRegister<ContainerType<?>> REG = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Ref.MODID);

    public static RegistryObject<ContainerType<ContainerGearModify>> GEAR_MODIFY = REG.register(of(ModBlocks.GEAR_MODIFY), () -> IForgeContainerType.create(ContainerGearModify::new));
    public static RegistryObject<ContainerType<ContainerGearRepair>> GEAR_REPAIR = REG.register(of(ModBlocks.GEAR_REPAIR), () -> IForgeContainerType.create(ContainerGearRepair::new));
    public static RegistryObject<ContainerType<ContainerGearSalvage>> GEAR_SALVAGE = REG.register(of(ModBlocks.GEAR_SALVAGE), () -> IForgeContainerType.create(ContainerGearSalvage::new));
    public static RegistryObject<ContainerType<MapChestContainer>> MAP_CHEST = REG.register(of(ModBlocks.MAP_CHEST), () -> IForgeContainerType.create(MapChestContainer::new));
    public static RegistryObject<ContainerType<ContainerMapDevice>> MAP_DEVICE = REG.register(of(ModBlocks.MAP_DEVICE), () -> IForgeContainerType.create(ContainerMapDevice::new));

    static Item.Properties stationProp = new Item.Properties().group(CreativeTabs.MyModTab);

    static <T extends Block> String of(RegistryObject<T> block) {
        return block.getId()
            .getPath();
    }

    static final String LOOT_BAG_ID = Ref.MODID + ":" + "loot_bag";
    static final String MAP_BAG_ID = Ref.MODID + ":" + "map_bag";
    static final String CURRENCY_BAG_ID = Ref.MODID + ":" + "currency_bag";
    static final String MASTER_BAG_ID = Ref.MODID + ":" + "master_bag";

    static final String PROFESSION_RECIPE_CONTAINER_ID = Ref.MODID + ":" + "profession_recipe_container";

    @ObjectHolder(LOOT_BAG_ID)
    public static final ContainerType<ContainerLootBag> LOOT_BAG = null;
    @ObjectHolder(MAP_BAG_ID)
    public static final ContainerType<ContainerMapBag> MAP_BAG = null;
    @ObjectHolder(CURRENCY_BAG_ID)
    public static final ContainerType<ContainerCurrencyBag> CURRENCY_BAG = null;
    @ObjectHolder(MASTER_BAG_ID)
    public static final ContainerType<ContainerMasterBag> MASTER_BAG = null;

    @SubscribeEvent
    public static void registerContainers(
        final RegistryEvent.Register<ContainerType<?>> event) {

        IForgeRegistry<ContainerType<?>> r = event.getRegistry();

        r.register(IForgeContainerType.create(ContainerMasterBag::new)
            .setRegistryName(MASTER_BAG_ID));

        r.register(new ContainerType<>(ContainerMapBag::new).setRegistryName(MAP_BAG_ID));
        r.register(new ContainerType<>(ContainerLootBag::new).setRegistryName(LOOT_BAG_ID));
        r.register(new ContainerType<>(ContainerCurrencyBag::new).setRegistryName(CURRENCY_BAG_ID));

    }

}
