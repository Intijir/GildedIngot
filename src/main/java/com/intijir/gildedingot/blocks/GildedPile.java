package com.intijir.gildedingot.blocks;

import net.minecraft.block.SnowBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GildedPile extends SnowBlock {
    public GildedPile() {
        super(Properties.create(Material.SNOW)
        .harvestTool(ToolType.SHOVEL)
        .hardnessAndResistance(2,5)
        );
    }
}
