package com.intijir.gildedingot.item;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GildedIngot.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GILDEDINGOT_TAB = CREATIVE_MODE_TABS.register("gildedingot_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GILDED_INGOT.get()))
                    .title(Component.translatable("creativetab.gildedingot_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        // Items
                        pOutput.accept(ModItems.GILDED_INGOT.get());
                        pOutput.accept(ModItems.BASALT_HEART.get());
                        pOutput.accept(ModItems.SOUL_HEART.get());
                        pOutput.accept(ModItems.WARPED_HEART.get());
                        pOutput.accept(ModItems.CRIMSON_HEART.get());
                        pOutput.accept(ModItems.GILDED_NUGGET.get());
                        pOutput.accept(ModItems.WARPED_WART_SEED.get());
                        pOutput.accept(ModItems.SHROOM_FRUIT.get());
                        pOutput.accept(ModItems.WARPED_WART.get());
                        pOutput.accept(ModItems.GILDED_PEBBLE.get());
                        pOutput.accept(ModItems.GILDED_SWORD.get());
                        pOutput.accept(ModItems.GILDED_PICKAXE.get());
                        pOutput.accept(ModItems.GILDED_AXE.get());
                        pOutput.accept(ModItems.GILDED_SHOVEL.get());
                        pOutput.accept(ModItems.GILDED_HOE.get());
                        pOutput.accept(ModItems.GILDED_HELMET.get());
                        pOutput.accept(ModItems.GILDED_CHESTPLATE.get());
                        pOutput.accept(ModItems.GILDED_LEGGINGS.get());
                        pOutput.accept(ModItems.GILDED_BOOTS.get());

                        // Blocks
                        pOutput.accept(ModBlocks.GILDED_BLOCK.get());
                        pOutput.accept(ModBlocks.GILDED_BRICKS.get());
                        pOutput.accept(ModBlocks.BLUE_NETHER_BRICKS.get());
                        pOutput.accept(ModBlocks.SMOOTH_BLACKSTONE.get());
                        pOutput.accept(ModBlocks.GILDED_PILE.get());
                        pOutput.accept(ModBlocks.BASALT_LAPIS.get());
                        pOutput.accept(ModBlocks.GILDED_GLASS.get());
                        pOutput.accept(ModBlocks.GILDED_GLOWSHROOM.get());
                        pOutput.accept(ModBlocks.GILDED_DOOR.get());
                        pOutput.accept(ModBlocks.WARPED_SOUL_SOIL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
