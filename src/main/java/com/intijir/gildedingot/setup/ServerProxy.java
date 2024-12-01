package com.intijir.gildedingot.setup;

import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = "gildedingot",
        bus = Bus.MOD,
        value = {Dist.DEDICATED_SERVER}
)
public class ServerProxy implements IProxy {
    public ServerProxy() {
    }

    public void init() {
    }

    public World getClientWorld() {
        throw new IllegalStateException("Cannot run on server!");
    }
}