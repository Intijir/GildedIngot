package com.intijir.gildedingot.item;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GILDED_INGOT = registerItem("gilded_ingot",
            new com.intijir.gildedingot.item.GildedIngot());

    public static final Item BASALT_HEART = registerItem("basalt_heart",
            new Item(new FabricItemSettings()));

    public static final Item SOUL_HEART = registerItem("soul_heart",
            new Item(new FabricItemSettings()));

    public static final Item WARPED_HEART = registerItem("warped_heart",
            new Item(new FabricItemSettings()));

    public static final Item CRIMSON_HEART = registerItem("crimson_heart",
            new Item(new FabricItemSettings()));

    public static final Item GILDED_NUGGET = registerItem("gilded_nugget",
            new Item(new FabricItemSettings()));

    public static final Item WARPED_WART_SEED = registerItem("warped_wart_seed",
            new WarpedSeed());

    public static final Item SHROOM_FRUIT = registerItem("shroom_fruit",
            new ShroomFruit());

    public static final Item WARPED_WART = registerItem("warped_wart",
            new WarpedWart());

    public static final Item GILDED_PEBBLE = registerItem("gilded_pebble",
            new GildedPebble());

    // Tools
    public static final Item GILDED_SWORD = registerItem("gilded_sword",
            new SwordItem(ModToolMaterial.GILDED, 4, -2.4F, new FabricItemSettings()));

    public static final Item GILDED_PICKAXE = registerItem("gilded_pickaxe",
            new PickaxeItem(ModToolMaterial.GILDED,1, -2.8F, new FabricItemSettings()));

    public static final Item GILDED_AXE = registerItem("gilded_axe",
            new AxeItem(ModToolMaterial.GILDED, 6.0F, -3.1F , new FabricItemSettings()));

    public static final Item GILDED_SHOVEL = registerItem("gilded_shovel",
            new ShovelItem(ModToolMaterial.GILDED, 2.0F, -3.0F, new FabricItemSettings()));

    public static final Item GILDED_HOE = registerItem("gilded_hoe",
            new HoeItem(ModToolMaterial.GILDED, 0, -1.0f, new FabricItemSettings()));

    // Armor
    public static final Item GILDED_HELMET = registerItem("gilded_helmet",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, (new FabricItemSettings())));

    public static final Item GILDED_CHESTPLATE = registerItem("gilded_chestplate",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, (new FabricItemSettings())));

    public static final Item GILDED_LEGGINGS = registerItem("gilded_leggings",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, (new FabricItemSettings())));

    public static final Item GILDED_BOOTS = registerItem("gilded_boots",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, (new FabricItemSettings())));


    // Helper functions
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(GildedIngot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GildedIngot.LOGGER.info("Registering Mod Items for " + GildedIngot.MOD_ID);
    }

}
