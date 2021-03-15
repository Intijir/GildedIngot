package com.intijir.gildedingot.util;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.armor.ModArmorMaterial;
import com.intijir.gildedingot.blocks.*;
import com.intijir.gildedingot.items.GildedPebble;
import com.intijir.gildedingot.items.ItemBase;
import com.intijir.gildedingot.items.ShroomFruit;
import com.intijir.gildedingot.items.WarpedWart;
import com.intijir.gildedingot.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.SnowBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GildedIngot.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GildedIngot.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items

    public static final RegistryObject<Item> GILDED_INGOT = ITEMS.register("gilded_ingot", ItemBase::new);

    public static final RegistryObject<WarpedWart> WARPED_WART = ITEMS.register("warped_wart", WarpedWart::new);

    public static final RegistryObject<GildedPebble> GILDED_PEBBLE = ITEMS.register("gilded_pebble", GildedPebble::new);

    public static final RegistryObject<Item> GILDED_NUGGET = ITEMS.register("gilded_nugget", ItemBase::new);

    public static final RegistryObject<Item> SHROOM_FRUIT = ITEMS.register("shroom_fruit", ShroomFruit::new);

    //Blocks

    public static final RegistryObject<Block> GILDED_BLOCK = BLOCKS.register("gilded_block", GildedBlock::new);

    public static final RegistryObject<Block> GILDED_BRICK_BLOCK = BLOCKS.register("gilded_bricks", GildedBricks::new);

    public static final RegistryObject<Block> SMOOTH_BLACKSTONE_BLOCK = BLOCKS.register("smooth_blackstone", SmoothBlackstoneBlock::new);

    public static final RegistryObject<Block> BLUE_NETHER_BRICKS_BLOCK = BLOCKS.register("blue_nether_bricks", BlueNetherBricks::new);

    public static final RegistryObject<SnowBlock> GILDED_PILE = BLOCKS.register("gilded_pile", GildedPile::new);

    //Block Item

    public static final RegistryObject<Item> GILDED_BLOCK_ITEM = ITEMS.register("gilded_block", () -> new BlockItemBase(GILDED_BLOCK.get()));

    public static final RegistryObject<Item> GILDED_BRICKS_ITEM = ITEMS.register("gilded_bricks", () -> new BlockItemBase(GILDED_BRICK_BLOCK.get()));

    public static final RegistryObject<Item> SMOOTH_BLACKSTONE_BLOCK_ITEM = ITEMS.register("smooth_blackstone", () -> new BlockItemBase(SMOOTH_BLACKSTONE_BLOCK.get()));

    public static final RegistryObject<Item> BLUE_NETHER_BRICKS = ITEMS.register("blue_nether_bricks", () -> new BlockItemBase(BLUE_NETHER_BRICKS_BLOCK.get()));

    public static final RegistryObject<Item> GILDED_PILE_ITEM = ITEMS.register("gilded_pile", ()-> new BlockItemBase(GILDED_PILE.get()));

    //Tools
    public static final RegistryObject<SwordItem> GILDED_SWORD = ITEMS.register("gilded_sword", ()->
            new SwordItem(ModItemTier.GILDED, 4, -2.4f, new Item.Properties().group(GildedIngot.TAB)));
    public static final RegistryObject<PickaxeItem> GILDED_PICKAXE = ITEMS.register("gilded_pickaxe", ()->
            new PickaxeItem(ModItemTier.GILDED, 1, -2.8f, new Item.Properties().group(GildedIngot.TAB)));
    public static final RegistryObject<AxeItem> GILDED_AXE = ITEMS.register("gilded_axe", ()->
            new AxeItem(ModItemTier.GILDED, 6, -3.1f, new Item.Properties().group(GildedIngot.TAB)));
    public static final RegistryObject<ShovelItem> GILDED_SHOVEL = ITEMS.register("gilded_shovel", ()->
            new ShovelItem(ModItemTier.GILDED, 2, -3.0f, new Item.Properties().group(GildedIngot.TAB)));
    public static final RegistryObject<HoeItem> GILDED_HOE = ITEMS.register("gilded_hoe", ()->
            new HoeItem(ModItemTier.GILDED, 0, -1.0f, new Item.Properties().group(GildedIngot.TAB)));
    //Armor

    public static final RegistryObject<ArmorItem> GILDED_HELMET = ITEMS.register("gilded_helmet", ()-> new ArmorItem(ModArmorMaterial.GILDED, EquipmentSlotType.HEAD, new Item.Properties().group(GildedIngot.TAB)));

    public static final RegistryObject<ArmorItem> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate", ()-> new ArmorItem(ModArmorMaterial.GILDED, EquipmentSlotType.CHEST, new Item.Properties().group(GildedIngot.TAB)));

    public static final RegistryObject<ArmorItem> GILDED_LEGGINGS = ITEMS.register("gilded_leggings", ()-> new ArmorItem(ModArmorMaterial.GILDED, EquipmentSlotType.LEGS, new Item.Properties().group(GildedIngot.TAB)));

    public static final RegistryObject<ArmorItem> GILDED_BOOTS = ITEMS.register("gilded_boots", ()-> new ArmorItem(ModArmorMaterial.GILDED, EquipmentSlotType.FEET, new Item.Properties().group(GildedIngot.TAB)));


}
