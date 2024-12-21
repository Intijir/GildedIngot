package com.intijir.gildedingot.item;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeModeTabs {
    public static final ItemGroup GILDED_INGOT_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(GildedIngot.MOD_ID, "gilded_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gilded_ingot"))
                    .icon(() -> new ItemStack(ModItems.GILDED_INGOT)).entries((displayContext, entries) -> {
                        // Items
                        entries.add(ModItems.GILDED_INGOT);
                        entries.add(ModItems.BASALT_HEART);
                        entries.add(ModItems.SOUL_HEART);
                        entries.add(ModItems.WARPED_HEART);
                        entries.add(ModItems.CRIMSON_HEART);
                        entries.add(ModItems.GILDED_NUGGET);
                        entries.add(ModItems.WARPED_WART_SEED);
                        entries.add(ModItems.SHROOM_FRUIT);
                        entries.add(ModItems.WARPED_WART);
                        entries.add(ModItems.GILDED_PEBBLE);

                        entries.add(ModItems.GILDED_SWORD);
                        entries.add(ModItems.GILDED_PICKAXE);
                        entries.add(ModItems.GILDED_AXE);
                        entries.add(ModItems.GILDED_SHOVEL);
                        entries.add(ModItems.GILDED_HOE);
                        entries.add(ModItems.GILDED_HELMET);
                        entries.add(ModItems.GILDED_CHESTPLATE);
                        entries.add(ModItems.GILDED_LEGGINGS);
                        entries.add(ModItems.GILDED_BOOTS);

                        // Blocks
                        entries.add(ModBlocks.GILDED_BLOCK);
                        entries.add(ModBlocks.GILDED_BRICKS);
                        entries.add(ModBlocks.BLUE_NETHER_BRICKS);
                        entries.add(ModBlocks.SMOOTH_BLACKSTONE);
                        entries.add(ModBlocks.GILDED_PILE);
                        entries.add(ModBlocks.BASALT_LAPIS);
                        entries.add(ModBlocks.GILDED_GLASS);
                        entries.add(ModBlocks.GILDED_GLOWSHROOM);
                        entries.add(ModBlocks.GILDED_DOOR);
                        entries.add(ModBlocks.WARPED_SOUL_SOIL);

                    }).build());

    public static void registerItemGroups() {
        GildedIngot.LOGGER.info("Registering Item Groups for " + GildedIngot.MOD_ID);
    }
}
