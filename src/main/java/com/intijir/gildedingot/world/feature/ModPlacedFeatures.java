package com.intijir.gildedingot.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> BASALT_LAPIS_PLACED = PlacementUtils.register("basalt_lapis_placed",
            ModConfiguredFeatures.BASALT_LAPIS, ModOrePlacement.commonOrePlacement(5, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(50), VerticalAnchor.aboveBottom(110))));

    public static final Holder<PlacedFeature> GILDED_BLACKSTONE_PLACED = PlacementUtils.register("gilded_blackstone_placed",
            ModConfiguredFeatures.GILDED_BLACKSTONE, ModOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(80), VerticalAnchor.aboveBottom(110))));



}
