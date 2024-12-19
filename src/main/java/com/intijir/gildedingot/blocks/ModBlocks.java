package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.Registration;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {
    public static final RegistryObject<Block> GILDED_BLOCK = register("gilded_block", () -> new Block(Properties.of(Material.METAL).strength(10.0F, 15.0F).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GILDED_BRICKS = register("gilded_bricks", () -> new Block(Properties.of(Material.CLAY).strength(3.0F, 30.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> BLUE_NETHER_BRICKS = register("blue_nether_bricks", () -> new Block(Properties.of(Material.CLAY).strength(10.0F, 10.0F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> SMOOTH_BLACKSTONE_BLOCK = register("smooth_blackstone", () -> new Block(Properties.of(Material.STONE).strength(2.0F, 7.0F).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<SnowBlock> GILDED_PILE;
    public static final RegistryObject<Block> WARPED_NETHER_WART_CROP;
    public static final RegistryObject<Block> BASALT_LAPIS;
    public static final RegistryObject<FurnaceBlock> BLAZE_FURNACE;
    public static final RegistryObject<GlassBlock> GILDED_GLASS;
    public static final RegistryObject<Block> GILDED_GLOWSHROOM;
    public static final RegistryObject<Block> WARPED_SOUL_SOIL;
    public static final RegistryObject<Block> GILDED_DOOR;

    public ModBlocks() {
    }

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem((Block)toReturn.get(), (new Item.Properties()).tab(GildedIngot.TAB)));
        return toReturn;
    }

    static {
        GILDED_PILE = Registration.BLOCKS.register("gilded_pile", GildedPile::new);
        WARPED_NETHER_WART_CROP = Registration.BLOCKS.register("warped_nether_wart_crop", () -> new WarpedNetherWartCrop(Properties.copy(Blocks.NETHER_WART)));
        BASALT_LAPIS = register("basalt_lapis", () -> new Block(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.25F, 4.2F).harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.BASALT)));
        BLAZE_FURNACE = register("blaze_furnace", () -> new FurnaceBlock(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0F, 5.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
        GILDED_GLASS = register("gilded_glass", () -> new GlassBlock(Properties.of(Material.GLASS).strength(0.3F, 0.3F).harvestLevel(0).sound(SoundType.GLASS).noOcclusion()));
        GILDED_GLOWSHROOM = register("gilded_glowshroom", () -> new Block(Properties.of(Material.CLAY).strength(1.0F).harvestTool(ToolType.HOE).sound(SoundType.SHROOMLIGHT).noOcclusion().lightLevel((state) -> 15)));
        WARPED_SOUL_SOIL = register("warped_soul_soil", WarpedSoulSoil::new);
        GILDED_DOOR = register("gilded_door", GildedDoor::new);
    }
}
