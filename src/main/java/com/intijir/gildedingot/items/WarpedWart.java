package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.KeyboardHelper;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class WarpedWart extends Item {
    public WarpedWart() {
        super((new Item.Properties())
                .tab(GildedIngot.TAB)
                .food((new Food.Builder())
                        .nutrition(4).saturationMod(1.6F)
                        .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 200, 1), 0.4F)
                        .alwaysEat().build()));
    }

    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76"+"Gives you fire resistance for 10 seconds or 200 ticks with a probability of 40% "));
        } else {
            tooltip.add(new StringTextComponent("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
