package com.intijir.gildedingot.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlueNetherBricks extends Block{
    public BlueNetherBricks() {
        super(Properties.create(Material.CLAY)

        .hardnessAndResistance(10.0f, 10.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE));
    }
}
