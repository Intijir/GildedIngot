package com.intijir.gildedingot.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

import javax.annotation.Nullable;

public class GildedPebble extends Item {
    public GildedPebble() {
        super(new Properties());
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType){
        return 4800;
    }
}
