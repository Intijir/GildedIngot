package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.KeyboardHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
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

public class WarpedWart extends Item {
    public WarpedWart() {
        super(new Properties().tab(GildedIngot.TAB).food(WARPED_WART));
    }

    public static final FoodProperties WARPED_WART = (new FoodProperties.Builder().nutrition(4)
            .saturationMod(1.666f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1), 0.4F)
            .alwaysEat()
            .build());

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (KeyboardHelper.isHoldingShift()){
            pTooltipComponents.add(1, new TextComponent("\u00A76"+"Gives you fire resistance for 10 seconds or 200 ticks with a probability of 40% "));
        }
        else{
            pTooltipComponents.add(new TextComponent("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
