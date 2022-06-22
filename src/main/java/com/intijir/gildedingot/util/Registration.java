package com.intijir.gildedingot.util;


import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS;
    public static final DeferredRegister<Item> ITEMS;

    public Registration() {
    }

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "gildedingot");
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "gildedingot");
    }
}