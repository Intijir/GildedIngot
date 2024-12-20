package com.intijir.gildedingot.item;

import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class GildedChestplate extends ArmorItem {
    public GildedChestplate() {
        super(ModArmorMaterials.GILDED, Type.CHESTPLATE, new Properties());
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
}
