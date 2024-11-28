package com.intijir.gildedingot.block;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GildedIngot.MOD_ID);

    public static final DeferredBlock<Block> GILDED_BLOCK = registerBlock("gilded_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(10, 15000000)
            .requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> GILDED_BRICKS = registerBlock("gilded_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(3, 30000000)
            .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<Block> BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(10, 10)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<Block> SMOOTH_BLACKSTONE = registerBlock("smooth_blackstone",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(2, 7)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> GILDED_PILE = registerBlock("gilded_pile",
            GildedPile::new);

    public static final DeferredBlock<Block> BASALT_LAPIS = registerBlock("basalt_lapis",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.25F, 4.2F)
                    .requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final DeferredBlock<Block> GILDED_GLASS = registerBlock("gilded_glass",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.3F, 0.3F)
                    .sound(SoundType.GLASS).noOcclusion()));

    public static final DeferredBlock<Block> GILDED_GLOWSHROOM = registerBlock("gilded_glowshroom",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CLAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.SHROOMLIGHT).lightLevel(state -> {return 15;})));

    public static final DeferredBlock<Block> GILDED_DOOR = registerBlock("gilded_door",
            GildedDoor::new);

    public static final DeferredBlock<Block> WARPED_SOUL_SOIL = registerBlock("warped_soul_soil",
            WarpedSoulSoil::new);

    public static final DeferredBlock<Block> WARPED_NETHER_WART_CROP = registerBlockWithoutBlockItem("warped_nether_wart_crop",
            WarpedNetherWartCrop::new);



    // Helper functions
    private static <T extends Block> DeferredBlock<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    // register function
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
