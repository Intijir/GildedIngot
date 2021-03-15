package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ShroomFruit extends Item {
    public ShroomFruit() {
        super(new Properties()
        .group(GildedIngot.TAB)
                .food(new Food.Builder()
                .hunger(3)
                        .saturation(1.666f)
                        .effect(new EffectInstance(Effects.NIGHT_VISION,300, 1), 1.0f)
                        .setAlwaysEdible()
                                .build()
                )


        );
    }
}
