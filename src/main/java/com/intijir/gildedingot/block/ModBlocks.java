package com.intijir.gildedingot.block;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GILDED_BLOCK = registerBlock("gilded_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).strength(10, 15000000)
            .requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block GILDED_BRICKS = registerBlock("gilded_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY).strength(3, 30000000)
            .requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)));

    public static final Block BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY).strength(10, 10)
            .requiresTool().sounds(BlockSoundGroup.NETHER_BRICKS)));

    public static final Block SMOOTH_BLACKSTONE = registerBlock("smooth_blackstone",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY).strength(2, 7)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GILDED_PILE = registerBlock("gilded_pile",
            new GildedPile());

    public static final Block BASALT_LAPIS = registerBlock("basalt_lapis",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).strength(1.25F, 4.2F)
                    .requiresTool().sounds(BlockSoundGroup.BASALT)));

    public static final Block GILDED_GLASS = registerBlock("gilded_glass",
            new Block(AbstractBlock.Settings.create().strength(0.3F, 0.3F).nonOpaque().blockVision(Blocks::never).allowsSpawning(Blocks::never).solidBlock(Blocks::never)
                    .sounds(BlockSoundGroup.GLASS)));

    public static final Block GILDED_GLOWSHROOM = registerBlock("gilded_glowshroom",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_BLUE_GRAY).strength(1)
                    .requiresTool().sounds(BlockSoundGroup.SHROOMLIGHT).luminance(state -> {return 15;})));

    public static final Block GILDED_DOOR = registerBlock("gilded_door",
            new GildedDoor());

    public static final Block WARPED_SOUL_SOIL = registerBlock("warped_soul_soil",
            new WarpedSoulSoil());

    public static final Block WARPED_NETHER_WART_CROP = registerBlockWithoutBlockItem("warped_nether_wart_crop",
            new WarpedNetherWartCrop());


    // Helper functions
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(GildedIngot.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GildedIngot.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GildedIngot.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        GildedIngot.LOGGER.info("Registering ModBlocks for " + GildedIngot.MOD_ID);
    }
}
