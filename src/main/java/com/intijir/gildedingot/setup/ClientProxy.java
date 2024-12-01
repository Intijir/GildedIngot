package com.intijir.gildedingot.setup;

import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
        modid = "gildedingot",
        bus = Bus.MOD,
        value = {Dist.CLIENT}
)
public class ClientProxy implements IProxy {
    public ClientProxy() {
    }

    public void init() {
        RenderTypeLookup.setRenderLayer((Block)ModBlocks.WARPED_NETHER_WART_CROP.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer((Block)ModBlocks.GILDED_GLASS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer((Block)ModBlocks.GILDED_DOOR.get(), RenderType.translucent());
    }

    public World getClientWorld() {
        return Minecraft.getInstance().level;
    }
}
