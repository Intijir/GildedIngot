package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Properties;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GildedIngot.MOD_ID);

    public static final RegistryObject<Block> GILDED_BLOCK = registerBlock("gilded_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10, 15000000)
            .requiresCorrectToolForDrops().sound(SoundType.METAL)), GildedIngot.TAB);

    public static final RegistryObject<Block> GILDED_BRICKS = registerBlock("gilded_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(3, 30000000)
            .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), GildedIngot.TAB);

    public static final RegistryObject<Block> BLUE_NETHER_BRICKS = registerBlock("blue_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(10, 10)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), GildedIngot.TAB);

    public static final RegistryObject<Block> SMOOTH_BLACKSTONE = registerBlock("smooth_blackstone",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(2, 7)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)), GildedIngot.TAB);

    public static final RegistryObject<Block> GILDED_PILE = registerBlock("gilded_pile",
            () -> new GildedPile(), GildedIngot.TAB);

    public static final RegistryObject<Block> BASALT_LAPIS = registerBlock("basalt_lapis",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.25F, 4.2F)
                    .requiresCorrectToolForDrops().sound(SoundType.BASALT)), GildedIngot.TAB);

    public static final RegistryObject<Block> GILDED_GLASS = registerBlock("gilded_glass",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(0.3F, 0.3F)
                    .requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion()), GildedIngot.TAB);

    public static final RegistryObject<Block> GILDED_GLOWSHROOM = registerBlock("gilded_glowshroom",
            () -> new Block(BlockBehaviour.Properties.of(Material.CLAY).strength(1)
                    .requiresCorrectToolForDrops().sound(SoundType.SHROOMLIGHT).lightLevel(state -> {return 15;})), GildedIngot.TAB);

    public static final RegistryObject<Block> GILDED_DOOR = registerBlock("gilded_door",
            () -> new GildedDoor(), GildedIngot.TAB);

    public static final RegistryObject<Block> WARPED_SOUL_SOIL = registerBlock("warped_soul_soil",
            () -> new WarpedSoulSoil(), GildedIngot.TAB);

    public static final RegistryObject<Block> WARPED_NETHER_WART_CROP = registerBlockWithoutBlockItem("warped_nether_wart_crop",
            () -> new WarpedNetherWartCrop());


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
