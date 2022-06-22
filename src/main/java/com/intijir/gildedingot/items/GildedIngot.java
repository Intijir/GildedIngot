package com.intijir.gildedingot.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GildedIngot extends Item {
    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }
    public GildedIngot() {
        super(new Properties().tab(com.intijir.gildedingot.GildedIngot.TAB));
    }
}
