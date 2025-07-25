package com.intijir.gildedingot.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GildedChestplate extends ArmorItem {
    public GildedChestplate() {
        super(ModArmorMaterials.GILDED, Type.CHESTPLATE, new Item.Properties().durability(Type.CHESTPLATE.getDurability(16)));
    }

    public boolean makesPiglinsNeutral(@NotNull ItemStack stack, @NotNull LivingEntity wearer) { return true; }
}
