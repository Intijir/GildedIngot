package com.intijir.gildedingot;

import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.events.ModEvents;
import com.intijir.gildedingot.items.ModItems;
import com.intijir.gildedingot.world.feature.ModConfiguredFeatures;
import com.intijir.gildedingot.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gildedingot")
public class GildedIngot {

    public static final CreativeModeTab TAB = new CreativeModeTab("GildedIngot") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GILDED_INGOT.get());
        }
    };

    public static final String MOD_ID = "gildedingot";
    public static final String MOD_NAME = "Gilded Ingot";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GildedIngot() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing the {} Mod", MOD_NAME);
    }

}
