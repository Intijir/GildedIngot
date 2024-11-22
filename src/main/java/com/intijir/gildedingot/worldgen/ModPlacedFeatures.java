package com.intijir.gildedingot.worldgen;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> NETHER_BASALT_LAPIS_ORE_PLACED_KEY = registerKey("nether_basalt_lapis_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_GILDED_BLACKSTONE_ORE_PLACED_KEY = registerKey("nether_gilded_blackstone_ore_placed");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NETHER_BASALT_LAPIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BASALT_LAPIS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(50), VerticalAnchor.absolute(110))));
        register(context, NETHER_GILDED_BLACKSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_GILDED_BLACKSTONE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(GildedIngot.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    /*
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registries.PLACED_FEATURE, GildedIngot.MOD_ID);


    public static final RegistryObject<PlacedFeature> NETHER_BASALT_LAPIS_PLACED = PLACED_FEATURES.register("basalt_lapis_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BASALT_LAPIS.getHolder().get(), ModOrePlacement.commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(110)))));



    public static final RegistryObject<PlacedFeature> NETHER_GILDED_BLACKSTONE_PLACED = PLACED_FEATURES.register("nether_gilded_blackstone_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GILDED_BLACKSTONE.getHolder().get(), ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
 */
}
