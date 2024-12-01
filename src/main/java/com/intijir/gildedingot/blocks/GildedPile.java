package com.intijir.gildedingot.blocks;

import net.minecraft.block.SnowBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GildedPile extends SnowBlock {
    public GildedPile() {
        super(Properties.of(Material.SNOW).harvestTool(ToolType.SHOVEL).strength(2.0F, 5.0F));
    }
}
