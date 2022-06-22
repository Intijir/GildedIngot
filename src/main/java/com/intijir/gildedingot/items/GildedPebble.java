package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;

public class GildedPebble extends Item {
    public GildedPebble() {
        super(new Properties().tab(GildedIngot.TAB));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
        return 4800;
    }
}
