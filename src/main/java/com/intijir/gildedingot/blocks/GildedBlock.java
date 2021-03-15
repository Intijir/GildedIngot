package com.intijir.gildedingot.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GildedBlock extends Block{
    public GildedBlock() {
        super(Properties.create(Material.IRON)

        .hardnessAndResistance(10.0f, 15.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }
}
