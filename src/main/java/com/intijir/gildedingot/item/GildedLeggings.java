package com.intijir.gildedingot.item;

import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class GildedLeggings extends ArmorItem {
    public GildedLeggings() {
        super(ModArmorMaterials.GILDED, Type.LEGGINGS, new Properties());
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
}
