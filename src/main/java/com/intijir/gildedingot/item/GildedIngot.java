package com.intijir.gildedingot.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GildedIngot extends Item {
    public boolean isPiglinCurrency(@NotNull ItemStack stack) {
        return true;
    }
    public GildedIngot() {
        super(new Properties());
    }
}
