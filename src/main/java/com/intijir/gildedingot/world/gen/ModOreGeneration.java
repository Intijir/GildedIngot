package com.intijir.gildedingot.world.gen;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(
        modid = "gildedingot",
        bus = Bus.MOD
)
public class ModOreGeneration {
    public ModOreGeneration() {
    }

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for(OreType ore : OreType.values()) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(FillerBlockType.NETHER_ORE_REPLACEABLES, ore.getBlock().defaultBlockState(), ore.getMaxVeinSize());
            ConfiguredPlacement configuredPlacement = Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(ore.getMinHeight(), ore.getMaxHeight()));

            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().getRegistryName(),
                    (Feature.ORE.configured(oreFeatureConfig).decorated(configuredPlacement).squared()).count(ore.getMaxVeinSize()));

            for(Biome biome : ForgeRegistries.BIOMES) {
                String biomeName = biome.getRegistryName().toString();
                if (biomeName.contains("basalt_deltas")) {
                    addFeatureToBiome(biome, Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.get(ore.getBlock().getRegistryName()));
                }
            }
        }

    }

    private static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList(biome.getGenerationSettings().features());

        while(biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }

        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList((Collection)biomeFeatures.get(decoration.ordinal()));
        features.add((Supplier)() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures, "field_242484_f");
    }
}
