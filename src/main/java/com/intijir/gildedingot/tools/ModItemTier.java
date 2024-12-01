package com.intijir.gildedingot.tools;

import java.util.function.Supplier;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

public enum ModItemTier implements IItemTier {
    GILDED(3, 320, 20.0F, 1.0F, () -> Ingredient.of(new IItemProvider[]{(IItemProvider)ModTools.GILDED_SWORD.get()}), 10);

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, Supplier<Ingredient> repairMaterial, int enchantability) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairMaterial.get();
    }
}
