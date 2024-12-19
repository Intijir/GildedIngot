package com.intijir.gildedingot.armor;

import com.intijir.gildedingot.items.GildedBoots;
import com.intijir.gildedingot.items.GildedChestplate;
import com.intijir.gildedingot.items.GildedHelmet;
import com.intijir.gildedingot.items.GildedLeggings;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.item.ArmorItem;
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
        GILDED_HELMET = Registration.ITEMS.register("gilded_helmet", GildedHelmet::new);
        GILDED_CHESTPLATE = Registration.ITEMS.register("gilded_chestplate", GildedChestplate::new);
        GILDED_LEGGINGS = Registration.ITEMS.register("gilded_leggings", GildedLeggings::new);
        GILDED_BOOTS = Registration.ITEMS.register("gilded_boots", GildedBoots::new);
    }
}
