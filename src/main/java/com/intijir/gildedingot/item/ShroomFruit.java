package com.intijir.gildedingot.item;

import com.intijir.gildedingot.util.KeyboardHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ShroomFruit extends Item {
    public ShroomFruit() {
        super(new Properties().food(SHROOM_FRUIT));
    }

    public static final FoodProperties SHROOM_FRUIT = (new FoodProperties.Builder().nutrition(3)
            .saturationModifier(1.666f)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1), 1)
            .alwaysEdible()
            .build());

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @NotNull TooltipContext pContext, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pTooltipFlag) {
        if (KeyboardHelper.isHoldingShift()){
            pTooltipComponents.add(1, Component.literal("\u00A76" + "Gives you night vision for 15 seconds or 300 ticks"));
        }
        else{
            pTooltipComponents.add(Component.literal("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
