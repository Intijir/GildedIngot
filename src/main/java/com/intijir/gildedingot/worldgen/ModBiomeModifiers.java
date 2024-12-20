package com.intijir.gildedingot.worldgen;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_NETHER_BASALT_LAPIS_ORE = registerKey("add_nether_basalt_lapis_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_GILDED_BLACKSTONE_ORE = registerKey("add_nether_gilded_blackstone_ore");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_NETHER_BASALT_LAPIS_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BASALT_DELTAS).getDelegate()),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_BASALT_LAPIS_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_GILDED_BLACKSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BASALT_DELTAS).getDelegate()),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_GILDED_BLACKSTONE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(GildedIngot.MOD_ID, name));
    }
}
