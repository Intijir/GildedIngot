package com.intijir.gildedingot.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GildedBricks extends Block {
    public GildedBricks() {
        super(Properties.create(Material.CLAY)
        .hardnessAndResistance(3.0f, 30.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE));
    }
}
