package com.intijir.gildedingot;

import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.events.ModEvents;
import com.intijir.gildedingot.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gildedingot")
public class GildedIngot {

    public static final CreativeModeTab TAB = new CreativeModeTab("GildedIngotMod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GILDED_INGOT.get());
        }
    };

    public static final String MOD_ID = "gildedingot";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GildedIngot() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);


        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.WARPED_NETHER_WART_CROP.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.GILDED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer((Block)ModBlocks.GILDED_DOOR.get(), RenderType.translucent());
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
