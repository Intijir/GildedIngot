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

public class ShroomFruit extends Item {
    public ShroomFruit() {
        super((new Item.Properties())
                .tab(GildedIngot.TAB)
                .food((new Food.Builder())
                .nutrition(3)
                .saturationMod(1.666F)
                .effect(new EffectInstance(Effects.NIGHT_VISION, 300, 1), 1.0F)
                .alwaysEat().build()));
    }

    public void appendHoverText(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("\u00A76"+"Gives you night vision for 15 seconds or 300 ticks"));
        } else {
            tooltip.add(new StringTextComponent("\u00A77" + "Hold " + "\u00A7e" + "Shift " + "\u00A77" + "for more information"));
        }

        super.appendHoverText(stack, world, tooltip, flag);
    }
}
