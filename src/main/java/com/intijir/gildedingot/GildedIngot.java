package com.intijir.gildedingot;


import com.intijir.gildedingot.util.RegistryHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@Mod("gildedingot")
public class GildedIngot
{

    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "gildedingot";

    public GildedIngot() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        RegistryHandler.init();
    }

    private void setup(final FMLCommonSetupEvent event){
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("GildedIngotMod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.GILDED_INGOT.get());
        }
    };

}
