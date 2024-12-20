package com.intijir.gildedingot.item;

import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class GildedBoots extends ArmorItem {
    public GildedBoots() {
        super(ModArmorMaterials.GILDED, Type.BOOTS, new Properties());
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
}
