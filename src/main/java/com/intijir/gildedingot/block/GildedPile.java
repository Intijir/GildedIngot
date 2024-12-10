package com.intijir.gildedingot.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.SnowBlock;

public class GildedPile extends SnowBlock {
    public GildedPile() {
        super(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(2, 5));
    }
}
