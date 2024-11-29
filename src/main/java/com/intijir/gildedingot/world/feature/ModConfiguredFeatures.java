package com.intijir.gildedingot.world.feature;

import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;

import java.util.List;

public class ModConfiguredFeatures {


    public static final List<OreConfiguration.TargetBlockState> NETHER_BASALT_LAPIS = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.BASALT_LAPIS.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> BASALT_LAPIS = FeatureUtils.register("basalt_lapis",
            Feature.ORE, new OreConfiguration(NETHER_BASALT_LAPIS, 9));

    public static final List<OreConfiguration.TargetBlockState> NETHER_GILDED_BLACKSTONE = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, Blocks.GILDED_BLACKSTONE.defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> GILDED_BLACKSTONE = FeatureUtils.register("gilded_blackstone",
            Feature.ORE, new OreConfiguration(NETHER_GILDED_BLACKSTONE, 3));
}
