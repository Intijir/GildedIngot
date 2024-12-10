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

public class ShroomFruit extends Item {
    public ShroomFruit() {
        super(new FabricItemSettings().food(SHROOM_FRUIT));
    }

    public static final FoodComponent SHROOM_FRUIT = (new FoodComponent.Builder().hunger(3)
            .saturationModifier(1.666f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 1), 1)
            .alwaysEdible()
            .build());

    @Override
    public void appendTooltip(ItemStack pStack, @Nullable World pWorld, List<Text> tooltip, TooltipContext ctx) {
        if (KeyboardHelper.isHoldingShift()){
            tooltip.add(1, Text.literal("\u00A76" + "Gives you night vision for 15 seconds or 300 ticks"));
        }
        else {
            tooltip.add(Text.literal("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }
        super.appendTooltip(pStack, pWorld, tooltip, ctx);
    }
}
