package com.intijir.gildedingot.world;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BASALT_LAPIS_ORE_KEY = registerKey("nether_basalt_lapis_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_GILDED_BLACKSTONE_ORE_KEY = registerKey("nether_gilded_blackstone_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest basaltReplacables = new BlockMatchRuleTest(Blocks.BASALT);
        RuleTest netherStoneReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> netherRubyOres =
                List.of(OreFeatureConfig.createTarget(basaltReplacables, ModBlocks.BASALT_LAPIS.getDefaultState()));
        List<OreFeatureConfig.Target> endRubyOres =
                List.of(OreFeatureConfig.createTarget(netherStoneReplacables, Blocks.GILDED_BLACKSTONE.getDefaultState()));

        register(context, NETHER_BASALT_LAPIS_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherRubyOres, 9));
        register(context, NETHER_GILDED_BLACKSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endRubyOres, 6));
    }

    // Helper funtions
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(GildedIngot.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
