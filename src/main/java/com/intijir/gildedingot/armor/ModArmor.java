package com.intijir.gildedingot.armor;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModArmor {
    public static final RegistryObject<ArmorItem> GILDED_HELMET;
    public static final RegistryObject<ArmorItem> GILDED_CHESTPLATE;
    public static final RegistryObject<ArmorItem> GILDED_LEGGINGS;
    public static final RegistryObject<ArmorItem> GILDED_BOOTS;

    public ModArmor() {
    }

    public static void register() {
    }

    static {
        GILDED_HELMET = Registration.ITEMS.register("gilded_helmet", () -> new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlotType.HEAD, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_CHESTPLATE = Registration.ITEMS.register("gilded_chestplate", () -> new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlotType.CHEST, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_LEGGINGS = Registration.ITEMS.register("gilded_leggings", () -> new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlotType.LEGS, (new Item.Properties()).tab(GildedIngot.TAB)));
        GILDED_BOOTS = Registration.ITEMS.register("gilded_boots", () -> new ArmorItem(ModArmorMaterials.GILDED, EquipmentSlotType.FEET, (new Item.Properties()).tab(GildedIngot.TAB)));
    }
}
