package com.intijir.gildedingot.items;

import com.intijir.gildedingot.blocks.BlockItemBase;
import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> GILDED_INGOT;
    public static final RegistryObject<Item> GILDED_PEBBLE;
    public static final RegistryObject<Item> SHROOM_FRUIT;
    public static final RegistryObject<Item> WARPED_WART;
    public static final RegistryObject<Item> GILDED_NUGGET;
    public static final RegistryObject<Item> WARPED_WART_SEED;
    public static final RegistryObject<Item> GILDED_PILE_ITEM;

    public ModItems() {
    }

    public static void register() {
    }

    static {
        GILDED_INGOT = Registration.ITEMS.register("gilded_ingot", GildedIngot::new);
        GILDED_PEBBLE = Registration.ITEMS.register("gilded_pebble", GildedPebble::new);
        SHROOM_FRUIT = Registration.ITEMS.register("shroom_fruit", ShroomFruit::new);
        WARPED_WART = Registration.ITEMS.register("warped_wart", WarpedWart::new);
        GILDED_NUGGET = Registration.ITEMS.register("gilded_nugget", () -> new Item((new Item.Properties()).tab(com.intijir.gildedingot.GildedIngot.TAB)));
        WARPED_WART_SEED = Registration.ITEMS.register("warped_wart_seed", WarpedSeed::new);
        GILDED_PILE_ITEM = Registration.ITEMS.register("gilded_pile", () -> new BlockItemBase((Block)ModBlocks.GILDED_PILE.get()));
    }
}
