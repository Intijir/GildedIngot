package com.intijir.gildedingot.world.gen;

import com.intijir.gildedingot.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_BASALT_LAPIS_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_GILDED_BLACKSTONE_ORE_PLACED_KEY);
    }
}
