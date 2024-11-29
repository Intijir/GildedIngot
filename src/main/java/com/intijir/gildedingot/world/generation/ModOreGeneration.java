package com.intijir.gildedingot.world.generation;

import com.intijir.gildedingot.world.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        if (event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            base.add(ModPlacedFeatures.BASALT_LAPIS_PLACED);
            base.add(ModPlacedFeatures.GILDED_BLACKSTONE_PLACED);
        }

    }

}
