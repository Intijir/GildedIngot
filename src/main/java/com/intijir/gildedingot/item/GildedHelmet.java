package com.intijir.gildedingot.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GildedHelmet extends ArmorItem {
    public GildedHelmet() {
        super(ModArmorMaterials.GILDED, Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16)));
    }

    public boolean makesPiglinsNeutral(@NotNull ItemStack stack, @NotNull LivingEntity wearer) { return true; }
}
