package com.intijir.gildedingot.setup;

import net.minecraft.world.World;

public interface IProxy {
    void init();

    World getClientWorld();
}
