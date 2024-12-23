package com.intijir.gildedingot.item;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item GILDED_INGOT = registerItem("gilded_ingot",
            new com.intijir.gildedingot.item.GildedIngot());

    public static final Item BASALT_HEART = registerItem("basalt_heart",
            new Item(new Item.Settings()));

    public static final Item SOUL_HEART = registerItem("soul_heart",
            new Item(new Item.Settings()));

    public static final Item WARPED_HEART = registerItem("warped_heart",
            new Item(new Item.Settings()));

    public static final Item CRIMSON_HEART = registerItem("crimson_heart",
            new Item(new Item.Settings()));

    public static final Item GILDED_NUGGET = registerItem("gilded_nugget",
            new Item(new Item.Settings()));

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
            new SwordItem(ModToolMaterial.GILDED, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.GILDED, 4, -2.4f))));

    public static final Item GILDED_PICKAXE = registerItem("gilded_pickaxe",
            new PickaxeItem(ModToolMaterial.GILDED, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.GILDED, 1, -2.8f))));

    public static final Item GILDED_AXE = registerItem("gilded_axe",
            new AxeItem(ModToolMaterial.GILDED, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.GILDED, 6.0F, -3.1F))));

    public static final Item GILDED_SHOVEL = registerItem("gilded_shovel",
            new ShovelItem(ModToolMaterial.GILDED, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.GILDED, 2.0F, -3.0F))));

    public static final Item GILDED_HOE = registerItem("gilded_hoe",
            new HoeItem(ModToolMaterial.GILDED, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.GILDED, 0, -1.0f))));

    // Armor
    public static final Item GILDED_HELMET = registerItem("gilded_helmet",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(16))));

    public static final Item GILDED_CHESTPLATE = registerItem("gilded_chestplate",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(16))));

    public static final Item GILDED_LEGGINGS = registerItem("gilded_leggings",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(16))));

    public static final Item GILDED_BOOTS = registerItem("gilded_boots",
            new ArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(16))));


    // Helper functions
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GildedIngot.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GildedIngot.LOGGER.info("Registering Mod Items for " + GildedIngot.MOD_ID);
    }

}
