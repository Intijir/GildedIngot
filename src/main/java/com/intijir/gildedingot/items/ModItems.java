package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
