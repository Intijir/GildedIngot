package com.intijir.gildedingot.world;


import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.world.generation.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GildedIngot.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadEvent(final BiomeLoadingEvent event){
        ModOreGeneration.generateOres(event);
    }
}
