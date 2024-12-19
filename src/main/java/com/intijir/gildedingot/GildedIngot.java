package com.intijir.gildedingot;

import com.intijir.gildedingot.armor.ModArmor;
import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.events.ModEvents;
import com.intijir.gildedingot.items.ModItems;
import com.intijir.gildedingot.setup.ClientProxy;
import com.intijir.gildedingot.setup.IProxy;
import com.intijir.gildedingot.setup.ServerProxy;
import com.intijir.gildedingot.tools.ModTools;
import com.intijir.gildedingot.util.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("gildedingot")
public class GildedIngot {
    public static final String MOD_ID = "gildedingot";
    public static final String MOD_NAME = "Gilded Ingot";

    public static final ItemGroup TAB = new ItemGroup("GildedIngot") {
        public ItemStack makeIcon() {
            return new ItemStack((IItemProvider)ModItems.GILDED_INGOT.get());
        }
    };
    public static IProxy proxy;
    public static final Logger LOGGER = LogManager.getLogger();

    public GildedIngot() {
        LOGGER.info("Initializing the {} Mod", MOD_NAME);
        proxy = (IProxy)DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        this.registerModAdditions();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(FMLCommonSetupEvent event) {
        proxy.init();
    }

    private void registerModAdditions() {
        Registration.init();
        ModItems.register();
        ModBlocks.register();
        ModTools.register();
        ModArmor.register();
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }
}
