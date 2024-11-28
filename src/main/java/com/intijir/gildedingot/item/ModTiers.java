package com.intijir.gildedingot.item;

import com.intijir.gildedingot.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;


public class ModTiers {
    public static final Tier GILDED =
            new SimpleTier(ModTags.Blocks.INCORRECT_FOR_GILDED_TOOL, 460, 20.0F, 1.0F, 10,
                    () -> Ingredient.of(ModItems.GILDED_INGOT));

}

