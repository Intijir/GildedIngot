package com.intijir.gildedingot;

import com.intijir.gildedingot.block.ModBlocks;
import com.intijir.gildedingot.event.ModEvents;
import com.intijir.gildedingot.item.ModCreativeModTabs;
import com.intijir.gildedingot.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gildedingot")
public class GildedIngot {
    public static final String MOD_ID = "gildedingot";
    public static final String MOD_NAME = "Gilded Ingot";

    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent evt) {
        if     ((evt.getName().toString().equals("minecraft:chests/bastion_bridge")) ||
                (evt.getName().toString().equals("minecraft:chests/bastion_hoglin_stable")) ||
                (evt.getName().toString().equals("minecraft:chests/bastion_treasure")) ||
                (evt.getName().toString().equals("minecraft:chests/bastion_other"))) {
        }
    }

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GildedIngot() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(eventBus);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        //ModPlacedFeatures.register(eventBus);
        //ModConfiguredFeatures.register(eventBus);

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(new ModEvents());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initializing the {} Mod", MOD_NAME);
    }

}
