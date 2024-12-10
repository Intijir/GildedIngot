package com.intijir.gildedingot.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GildedIngot extends Item {
    public boolean isPiglinCurrency(ItemStack stack) {
        return true;
    }
    public GildedIngot() {
        super(new FabricItemSettings());
    }
}
