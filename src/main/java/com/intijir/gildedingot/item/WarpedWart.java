package com.intijir.gildedingot.item;

import com.intijir.gildedingot.util.KeyboardHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class WarpedWart extends Item {
    public WarpedWart() {
        super(new Properties().food(WARPED_WART));
    }

    public static final FoodProperties WARPED_WART = (new FoodProperties.Builder().nutrition(4)
            .saturationModifier(1.666f)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1), 0.4F)
            .alwaysEdible()
            .build());

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @NotNull TooltipContext pContext, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pTooltipFlag) {
        if (KeyboardHelper.isHoldingShift()){
            pTooltipComponents.add(1, Component.literal("§6"+"Gives you fire resistance for 10 seconds or 200 ticks with a probability of 40% "));
        }
        else{
            pTooltipComponents.add(Component.literal("§7" + "Hold " + "§e" + "Shift " + "§7" + "for more information"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
