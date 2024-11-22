package com.intijir.gildedingot.event;

import com.intijir.gildedingot.block.ModBlocks;
import com.intijir.gildedingot.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public void disablePlantingFarmLand(PlayerInteractEvent.RightClickBlock event){
        if (event.getEntity().getMainHandItem().getItem().equals(ModItems.WARPED_WART_SEED.get())) {
            if (event.getEntity().getServer().getLevel(null).getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) ||
                    event.getEntity().getServer().getLevel(null).getBlockState(event.getPos()).getBlock().equals(Blocks.SOUL_SOIL)) {
                event.setCanceled(false);
            }
        }
    }

    @SubscribeEvent
    public void onHoeEventSoulSoil(PlayerInteractEvent.RightClickBlock event) {
        if (event.getEntity().getMainHandItem().getItem() == ModItems.WARPED_WART_SEED.get()) {
            if (event.getEntity().getServer().getLevel(null).getBlockState(event.getPos()).getBlock().equals(Blocks.SOUL_SOIL)) {
                event.getEntity().getServer().getLevel(null).setBlockAndUpdate(event.getPos(), ModBlocks.WARPED_SOUL_SOIL.get().defaultBlockState());
                event.getEntity().getMainHandItem().shrink(1);
            }
        }
    }
}