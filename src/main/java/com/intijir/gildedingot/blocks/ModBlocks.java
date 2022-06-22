package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GildedIngot.MOD_ID);



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
