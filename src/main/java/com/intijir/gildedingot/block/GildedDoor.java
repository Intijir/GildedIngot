package com.intijir.gildedingot.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.sound.BlockSoundGroup;

public class GildedDoor extends DoorBlock {
    public GildedDoor() {
        super(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque().strength(1, 4.2E7F).sounds(BlockSoundGroup.STONE), BlockSetType.IRON);
    }
}
