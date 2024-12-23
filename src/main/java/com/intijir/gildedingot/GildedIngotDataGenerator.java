package com.intijir.gildedingot;

import com.intijir.gildedingot.datagen.ModWorldGenProvider;
import com.intijir.gildedingot.world.ModConfiguredFeatures;
import com.intijir.gildedingot.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class GildedIngotDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        //pack.addProvider(ModBlockTagProvider::new);
        //pack.addProvider(ModItemTagProvider::new);
        //pack.addProvider(ModLootTableProvider::new);
        //pack.addProvider(ModModelProvider::new);
        //pack.addProvider(ModRecipeProvider::new);
        //pack.addProvider(ModPoiTagProvider::new);
        pack.addProvider(ModWorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
    }
}
