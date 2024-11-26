package com.intijir.gildedingot.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class GildedDoor extends DoorBlock {
    public GildedDoor() {
        super(Properties.copy(Blocks.IRON_BLOCK).noOcclusion().strength(1, 4.2E7F).sound(SoundType.STONE), BlockSetType.IRON);
    }
}
