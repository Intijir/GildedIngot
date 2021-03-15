package com.intijir.gildedingot.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SmoothBlackstoneBlock extends Block {


    public SmoothBlackstoneBlock() {
        super(Properties.create(Material.ROCK)

        .hardnessAndResistance(2.0f, 7.0f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
