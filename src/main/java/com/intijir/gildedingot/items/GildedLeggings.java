package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class GildedLeggings extends ArmorItem {
    public GildedLeggings() {
        super(ModArmorMaterials.GILDED, EquipmentSlotType.LEGS, new Properties().tab(GildedIngot.TAB));
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
}
