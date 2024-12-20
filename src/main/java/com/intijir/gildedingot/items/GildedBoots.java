package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.armor.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class GildedBoots extends ArmorItem {
    public GildedBoots() {
        super(ModArmorMaterials.GILDED, EquipmentSlot.FEET, new Properties().tab(GildedIngot.TAB));
    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) { return true; }
}
