package com.intijir.gildedingot.util;

import com.intijir.gildedingot.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;

public class ModLootTableModifiers {
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            RegistryWrapper.Impl<Enchantment> impl = registries.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
            if (EntityType.PIGLIN.getLootTableId() == id && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.GILDED_NUGGET))
                        .apply(List.of(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 3f)).build(),
                        ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.LOOTING),1).build()));
                tableBuilder.pool(poolBuilder);
            }
            if (EntityType.PIGLIN_BRUTE.getLootTableId() == id && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.GILDED_NUGGET))
                        .apply(List.of(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 5f)).build(),
                                ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.LOOTING),3).build()));
                tableBuilder.pool(poolBuilder);
            }
            if (EntityType.PIGLIN_BRUTE.getLootTableId() == id && source.isBuiltin()) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 0.025f, 0.01f))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .with(ItemEntry.builder(ModItems.GILDED_INGOT));
                tableBuilder.pool(poolBuilder);
            }
        });
    }
}



