package com.intijir.gildedingot.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GildedIngot extends Item {
    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }

    public GildedIngot() {
        super((new Item.Properties()).tab(com.intijir.gildedingot.GildedIngot.TAB));
    }
}
