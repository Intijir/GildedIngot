package com.intijir.gildedingot.block;

import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.material.MapColor;

public class GildedPile extends SnowLayerBlock {
    public GildedPile() {
        super(Properties.of().mapColor(MapColor.SNOW).strength(2, 5));
    }
}
