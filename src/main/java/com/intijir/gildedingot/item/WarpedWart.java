package com.intijir.gildedingot.item;

import com.intijir.gildedingot.util.KeyboardHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WarpedWart extends Item {
    public WarpedWart() {
        super(new FabricItemSettings().food(WARPED_WART));
    }

    public static final FoodComponent WARPED_WART = (new FoodComponent.Builder().hunger(4)
            .saturationModifier(1.666f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 1), 0.4F)
            .alwaysEdible()
            .build());

    @Override
    public void appendTooltip(ItemStack pStack, @Nullable World pWorld, List<Text> tooltip, TooltipContext ctx) {
        if (KeyboardHelper.isHoldingShift()){
            tooltip.add(1, Text.literal("§6"+"Gives you fire resistance for 10 seconds or 200 ticks with a probability of 40% "));
        }
        else {
            tooltip.add(Text.literal("§7" + "Hold " + "§e" + "Shift " + "§7" + "for more information"));
        }
        super.appendTooltip(pStack, pWorld, tooltip, ctx);
    }
}
