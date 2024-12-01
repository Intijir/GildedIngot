package com.intijir.gildedingot.tools;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;

public class ModTools {
    public static final RegistryObject<SwordItem> GILDED_SWORD;
    public static final RegistryObject<PickaxeItem> GILDED_PICKAXE;
    public static final RegistryObject<AxeItem> GILDED_AXE;
    public static final RegistryObject<ShovelItem> GILDED_SHOVEL;
    public static final RegistryObject<HoeItem> GILDED_HOE;

    public ModTools() {
    }

    public static void register() {
    }

    static {
        GILDED_SWORD = Registration.ITEMS.register("gilded_sword", () -> new SwordItem(ModItemTier.GILDED, 4, -2.4F, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_PICKAXE = Registration.ITEMS.register("gilded_pickaxe", () -> new PickaxeItem(ModItemTier.GILDED, 1, -2.8F, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_AXE = Registration.ITEMS.register("gilded_axe", () -> new AxeItem(ModItemTier.GILDED, 6.0F, -3.1F, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_SHOVEL = Registration.ITEMS.register("gilded_shovel", () -> new ShovelItem(ModItemTier.GILDED, 2.0F, -3.0F, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_HOE = Registration.ITEMS.register("gilded_hoe", () -> new HoeItem(ModItemTier.GILDED, 0, -1.0F, (new Item.Properties()).tab(GildedIngot.TAB)));
    }
}
