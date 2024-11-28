package com.intijir.gildedingot.datagen;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, GildedIngot.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.SWORDS)
                .add(ModItems.GILDED_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.GILDED_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.GILDED_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.GILDED_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.GILDED_HOE.get());

        /*
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BISMUTH_HELMET.get())
                .add(ModItems.BISMUTH_CHESTPLATE.get())
                .add(ModItems.BISMUTH_LEGGINGS.get())
                .add(ModItems.BISMUTH_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.BISMUTH.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KAUPEN_SMITHING_TEMPLATE.get());

         */
    }
}