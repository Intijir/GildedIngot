package com.intijir.gildedingot.blocks;

import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.material.Material;

public class GildedPile extends SnowLayerBlock {
    public GildedPile() {
        super(Properties.of(Material.SNOW).strength(2, 5));
    }
}
