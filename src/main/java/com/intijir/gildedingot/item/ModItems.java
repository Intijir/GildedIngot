package com.intijir.gildedingot.item;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.block.ModBlocks;
import net.minecraft.world.item.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GildedIngot.MOD_ID);


    public static final DeferredItem<Item> GILDED_INGOT = ITEMS.register("gilded_ingot",
            com.intijir.gildedingot.item.GildedIngot::new);

    public static final DeferredItem<Item> BASALT_HEART = ITEMS.register("basalt_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SOUL_HEART = ITEMS.register("soul_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WARPED_HEART = ITEMS.register("warped_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CRIMSON_HEART = ITEMS.register("crimson_heart",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GILDED_NUGGET = ITEMS.register("gilded_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WARPED_WART_SEED = ITEMS.register("warped_wart_seed", WarpedSeed::new);


    public static final DeferredItem<Item> SHROOM_FRUIT = ITEMS.register("shroom_fruit", ShroomFruit::new);

    public static final DeferredItem<Item> WARPED_WART = ITEMS.register("warped_wart", WarpedWart::new);

    public static final DeferredItem<Item> GILDED_PEBBLE = ITEMS.register("gilded_pebble", GildedPebble::new);


    // Tools
    public static final DeferredItem<SwordItem> GILDED_SWORD = ITEMS.register("gilded_sword",
            () -> new SwordItem(ModTiers.GILDED, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModTiers.GILDED, 4, -2.4f))));

    public static final DeferredItem<PickaxeItem> GILDED_PICKAXE = ITEMS.register("gilded_pickaxe",
            () -> new PickaxeItem(ModTiers.GILDED, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModTiers.GILDED, 1, -2.8f))));

    public static final DeferredItem<AxeItem> GILDED_AXE = ITEMS.register("gilded_axe",
            () -> new AxeItem(ModTiers.GILDED, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModTiers.GILDED, 6, -3.1f))));

    public static final DeferredItem<ShovelItem> GILDED_SHOVEL = ITEMS.register("gilded_shovel",
            () -> new ShovelItem(ModTiers.GILDED, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModTiers.GILDED, 2, -3.0f))));

    public static final DeferredItem<HoeItem> GILDED_HOE = ITEMS.register("gilded_hoe",
            () -> new HoeItem(ModTiers.GILDED, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModTiers.GILDED, 0, -1.0f))));


    // Armor
    public static final DeferredItem<ArmorItem> GILDED_HELMET = ITEMS.register("gilded_helmet", GildedHelmet::new);

    public static final DeferredItem<ArmorItem> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate", GildedChestplate::new);

    public static final DeferredItem<ArmorItem> GILDED_LEGGINGS = ITEMS.register("gilded_leggings", GildedLeggings::new);

    public static final DeferredItem<ArmorItem> GILDED_BOOTS = ITEMS.register("gilded_boots", GildedBoots::new);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
