package com.intijir.gildedingot.mixin;

import com.intijir.gildedingot.item.ModArmorMaterials;
import com.intijir.gildedingot.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
    @Inject(method = "acceptsForBarter", at = @At("HEAD"), cancellable = true)
    private static void acceptsForBarter(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.isOf(ModItems.GILDED_INGOT)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
    private static void wearsGoldArmor(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        Iterable<ItemStack> iterable2 = entity.getArmorItems();
        for (ItemStack itemStack : iterable2) {
            Item item = itemStack.getItem();
            if (!(item instanceof ArmorItem) || ((ArmorItem)item).getMaterial() != ModArmorMaterials.GILDED) continue;
            cir.setReturnValue(true);
        }
    }
}
