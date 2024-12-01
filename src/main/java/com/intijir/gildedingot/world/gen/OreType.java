package com.intijir.gildedingot.world.gen;

import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public enum OreType {
    GILDED(Blocks.GILDED_BLACKSTONE.getBlock(), 3, 6, 128),
    GILDED_BASALT_LAPIS(ModBlocks.BASALT_LAPIS.get(), 4, 80, 128),
    GILDED_OBSIDIAN(Blocks.OBSIDIAN.getBlock(), 32, 10, 29);

    private final Block block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    private OreType(Block block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.maxVeinSize = maxVeinSize;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public Block getBlock() {
        return this.block;
    }

    public int getMaxVeinSize() {
        return this.maxVeinSize;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public static OreType get(Block block) {
        for(OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }

        return null;
    }
}
