package com.intijir.gildedingot.world.feature;



import com.google.common.base.Suppliers;
import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, GildedIngot.MOD_ID);

    // Basalt Lapis
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_BASALT_LAPIS = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.BASALT), ModBlocks.BASALT_LAPIS.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BASALT_LAPIS = CONFIGURED_FEATURES.register("basalt_lapis",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_BASALT_LAPIS.get(), 9)));

    // Gilded Blackstone
    public static final List<OreConfiguration.TargetBlockState> NETHER_GILDED_BLACKSTONE = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, Blocks.GILDED_BLACKSTONE.defaultBlockState()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> GILDED_BLACKSTONE = CONFIGURED_FEATURES.register("gilded_blackstone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_GILDED_BLACKSTONE, 3)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
