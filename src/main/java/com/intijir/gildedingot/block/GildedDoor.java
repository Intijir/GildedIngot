package com.intijir.gildedingot.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;

public class GildedDoor extends DoorBlock {
    public GildedDoor() {
        super(Properties.of().mapColor(MapColor.METAL).strength(1, 4.2E7F).sound(SoundType.STONE), BlockSetType.IRON);
    }
}
