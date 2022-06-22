package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.armor.ModArmorMaterials;
import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GildedIngot.MOD_ID);

    public static final RegistryObject<Item> GILDED_INGOT = ITEMS.register("gilded_ingot", () -> new com.intijir.gildedingot.items.GildedIngot());

    public static final RegistryObject<Item> BASALT_HEART = ITEMS.register("basalt_heart",
            () -> new Item(new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> SOUL_HEART = ITEMS.register("soul_heart",
            () -> new Item(new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> WARPED_HEART = ITEMS.register("warped_heart",
            () -> new Item(new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> CRIMSON_HEART = ITEMS.register("crimson_heart",
            () -> new Item(new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> GILDED_NUGGET = ITEMS.register("gilded_nugget",
            () -> new Item(new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> WARPED_WART_SEED =
            ITEMS.register("warped_wart_seed",
                    () -> new BlockItem(ModBlocks.WARPED_NETHER_WART_CROP.get(),
                            new Item.Properties().tab(GildedIngot.TAB)));

    public static final RegistryObject<Item> SHROOM_FRUIT = ITEMS.register("shroom_fruit",
            () -> new ShroomFruit());

    public static final RegistryObject<Item> WARPED_WART = ITEMS.register("warped_wart",
            () -> new WarpedWart());

    public static final RegistryObject<Item> GILDED_PEBBLE = ITEMS.register("gilded_pebble",
            () -> new GildedPebble());

    // TOOLS DOWN HERE

    public static final RegistryObject<Item> GILDED_SWORD = ITEMS.register("gilded_sword",
            () -> new SwordItem(ModTiers.GILDED, 4, -2.4F, new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> GILDED_PICKAXE = ITEMS.register("gilded_pickaxe",
            () -> new PickaxeItem(ModTiers.GILDED,1, -2.8F, new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> GILDED_AXE = ITEMS.register("gilded_axe",
            () -> new AxeItem(ModTiers.GILDED, 6.0F, -3.1F , new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> GILDED_SHOVEL = ITEMS.register("gilded_shovel",
            () -> new ShovelItem(ModTiers.GILDED, 2.0F, -3.0F, new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    public static final RegistryObject<Item> GILDED_HOE = ITEMS.register("gilded_hoe",
            () -> new HoeItem(ModTiers.GILDED, 0, -1.0f, new Item.Properties().tab(com.intijir.gildedingot.GildedIngot.TAB)));

    // ARMOR DOWN HERE

    public static final RegistryObject<Item> GILDED_HELMET = ITEMS.register("gilded_helmet", () -> {
        return new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlot.HEAD, (new Item.Properties()).tab(GildedIngot.TAB));
    });

    public static final RegistryObject<Item> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate", () -> {
        return new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlot.CHEST, (new Item.Properties()).tab(GildedIngot.TAB));
    });

    public static final RegistryObject<Item> GILDED_LEGGINGS = ITEMS.register("gilded_leggings", () -> {
        return new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlot.LEGS, (new Item.Properties()).tab(GildedIngot.TAB));
    });

    public static final RegistryObject<Item> GILDED_BOOTS = ITEMS.register("gilded_boots", () -> {
        return new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlot.FEET, (new Item.Properties()).tab(GildedIngot.TAB));
    });

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
