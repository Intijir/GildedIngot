package com.intijir.gildedingot.world.feature;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, GildedIngot.MOD_ID);



    public static final RegistryObject<PlacedFeature> NETHER_BASALT_LAPIS_PLACED = PLACED_FEATURES.register("basalt_lapis_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BASALT_LAPIS.getHolder().get(), ModOrePlacement.commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(110)))));



    public static final RegistryObject<PlacedFeature> NETHER_GILDED_BLACKSTONE_PLACED = PLACED_FEATURES.register("nether_gilded_blackstone_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GILDED_BLACKSTONE.getHolder().get(), ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
