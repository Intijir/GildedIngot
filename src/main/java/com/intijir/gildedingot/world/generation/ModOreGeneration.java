package com.intijir.gildedingot.world.generation;



import com.intijir.gildedingot.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.NetherBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;

public class ModOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        if (event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            base.add(ModPlacedFeatures.BASALT_LAPIS_PLACED);
            base.add(ModPlacedFeatures.GILDED_BLACKSTONE_PLACED);
        }

    }

}
