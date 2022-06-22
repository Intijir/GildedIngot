package com.intijir.gildedingot.blocks;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class GildedDoor extends DoorBlock {
    public GildedDoor() {
        super(Properties.of(Material.METAL).strength(1, 4.2E7F).sound(SoundType.STONE));
    }
}
