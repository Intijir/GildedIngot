package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GildedPebble extends Item {

    public GildedPebble() {
        super(new Properties()
        .group(GildedIngot.TAB));

    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 4800;
    }
}
