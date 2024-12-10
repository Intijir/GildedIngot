package com.intijir.gildedingot;

import com.intijir.gildedingot.block.ModBlocks;
import com.intijir.gildedingot.item.ModCreativeModeTabs;
import com.intijir.gildedingot.item.ModItems;
import com.intijir.gildedingot.world.gen.ModWorldGeneration;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;

public class GildedIngot implements ModInitializer {
    public static final String MOD_ID = "gildedingot";
    public static final String MOD_NAME = "Gilded Ingot";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing the {} Mod", MOD_NAME);
        ModCreativeModeTabs.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGeneration.generateModWorldGen();

        FuelRegistry.INSTANCE.add(ModItems.GILDED_PEBBLE,4800);
    }
}
