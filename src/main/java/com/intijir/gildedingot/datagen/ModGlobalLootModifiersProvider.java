package com.intijir.gildedingot.datagen;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.item.ModItems;
import com.intijir.gildedingot.loot.AddItemModifier;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

// see https://github.com/Luohuayu/CatServer/blob/1c92118fcca69ffac97a48c8e1f6e1bb861b41d1/src/main/java/org/bukkit/loot/LootTables.java#L71 for some loot tables
public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, GildedIngot.MOD_ID);
    }

    @Override
    protected void start() {
        add("gilded_nugget_from_piglin", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/piglin")).build(),
                LootItemRandomChanceCondition.randomChance(1.0f).build()},
                ModItems.GILDED_NUGGET.get(),
                List.of(Holder.direct(SetItemCountFunction.setCount(UniformGenerator.between(0, 3)).build()),
                Holder.direct(ApplyBonusCount.addUniformBonusCount((registries.lookupOrThrow(Registries.ENCHANTMENT)).getOrThrow(Enchantments.LOOTING),1).build())))
                );

        add("gilded_nugget_from_piglin_brute", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/piglin_brute")).build(),
                LootItemRandomChanceCondition.randomChance(1.0f).build()},
                ModItems.GILDED_NUGGET.get(),
                List.of(Holder.direct(SetItemCountFunction.setCount(UniformGenerator.between(0, 5)).build()),
                Holder.direct(ApplyBonusCount.addUniformBonusCount((registries.lookupOrThrow(Registries.ENCHANTMENT)).getOrThrow(Enchantments.LOOTING),3).build())))
        );
        add("gilded_ingot_from_piglin_brute", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/piglin_brute")).build(),
                LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries,0.025F, 0.01F).build(),
                LootItemKilledByPlayerCondition.killedByPlayer().build()},
                ModItems.GILDED_INGOT.get(),
                List.of())
        );
    }
}
