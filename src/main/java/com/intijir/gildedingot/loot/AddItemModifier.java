package com.intijir.gildedingot.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<MapCodec<AddItemModifier>> CODEC_SUPPLIER =
            Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(instance -> AddItemModifier.codecStart(instance)
            .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(addItemModifierInstance -> addItemModifierInstance.item))
            .and(LootItemFunctions.CODEC.listOf().optionalFieldOf("functions", List.of()).forGetter(addItemModifierInstance -> addItemModifierInstance.functions))
            .apply(instance, AddItemModifier::new))
   );

    private final Item item;
    private final List<Holder<LootItemFunction>> functions;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item, List<Holder<LootItemFunction>> functions) {
        super(conditionsIn);
        this.item = item;
        this.functions = functions;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ItemStack itemToAdd = new ItemStack(item);

        if (!functions.isEmpty()) {
            for (Holder<LootItemFunction> functionHolder : functions) {
                LootItemFunction function = functionHolder.value();
                itemToAdd = function.apply(itemToAdd, context);
            }
        }

        generatedLoot.add(itemToAdd);
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC_SUPPLIER.get();
    }
}