package com.intijir.gildedingot.worldgen;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BASALT_LAPIS_ORE_KEY = registerKey("nether_basalt_lapis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_GILDED_BLACKSTONE_ORE_KEY = registerKey("nether_gilded_blackstone_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest basaltReplaceables = new BlockMatchTest(Blocks.BASALT);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);

        register(context, NETHER_BASALT_LAPIS_ORE_KEY, Feature.ORE, new OreConfiguration(basaltReplaceables,
                ModBlocks.BASALT_LAPIS.get().defaultBlockState(), 9));
        register(context, NETHER_GILDED_BLACKSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                Blocks.GILDED_BLACKSTONE.defaultBlockState(), 3));
    }

    // Helper funtions
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(GildedIngot.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
