package com.intijir.gildedingot.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class GildedDoor extends DoorBlock {
    public GildedDoor() {
        super(Properties.of(Material.METAL).strength(1.0F, 4.2E7F)
                .harvestLevel(1).harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE).noOcclusion());
    }
}
