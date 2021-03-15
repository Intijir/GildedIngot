package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class WarpedWart extends Item {
    public WarpedWart() {
        super(new Properties()
        .group(GildedIngot.TAB)
                .food(new Food.Builder()
                .hunger(4)
                        .saturation(1.6f)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE,200, 1), 0.4f)
                        .setAlwaysEdible()
                                .build()
                )


        );
    }
}
