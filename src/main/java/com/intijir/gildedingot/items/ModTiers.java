package com.intijir.gildedingot.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier GILDED =
            new ForgeTier(3, 460, 20.0F, 1.0F, 10, BlockTags.NEEDS_DIAMOND_TOOL,
                    () -> Ingredient.of(ModItems.GILDED_INGOT.get()));

}
