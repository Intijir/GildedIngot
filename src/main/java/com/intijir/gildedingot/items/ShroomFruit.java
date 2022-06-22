package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.KeyboardHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ShroomFruit extends Item {
    public ShroomFruit() {
        super(new Properties().tab(GildedIngot.TAB).food(SHROOM_FRUIT));
    }

    public static final FoodProperties SHROOM_FRUIT = (new FoodProperties.Builder().nutrition(3)
            .saturationMod(1.666f)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1), 1)
            .alwaysEat()
            .build());

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (KeyboardHelper.isHoldingShift()){
            pTooltipComponents.add(1, new TextComponent("\u00A76"+"Gives you night vision for 15 seconds or 300 ticks"));
        }
        else{
            pTooltipComponents.add(new TextComponent("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
