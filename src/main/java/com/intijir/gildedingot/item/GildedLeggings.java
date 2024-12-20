package com.intijir.gildedingot.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GildedLeggings extends ArmorItem {
    public GildedLeggings() {
        super(ModArmorMaterials.GILDED, Type.LEGGINGS, new Properties());
    }

    public boolean makesPiglinsNeutral(@NotNull ItemStack stack, @NotNull LivingEntity wearer) { return true; }
}
