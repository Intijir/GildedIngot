package com.intijir.gildedingot.events;

import com.intijir.gildedingot.blocks.ModBlocks;
import com.intijir.gildedingot.items.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    @SubscribeEvent
    public void disablePlantingFarmLand(PlayerInteractEvent.RightClickBlock event){
        if (event.getPlayer().getMainHandItem().getItem() == ModItems.WARPED_WART_SEED.get()){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.FARMLAND) ||
                    event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.SOUL_SOIL)){
                event.setCanceled(false);
            }
        }
    }

    @SubscribeEvent
    public void onHoeEventSoulSoil(PlayerInteractEvent.RightClickBlock event){
        if (event.getPlayer().getMainHandItem().getItem() == ModItems.WARPED_WART_SEED.get()){
            if (event.getWorld().getBlockState(event.getPos()).getBlock().equals(Blocks.SOUL_SOIL)){
                event.getWorld().setBlockAndUpdate(event.getPos(), ModBlocks.WARPED_SOUL_SOIL.get().defaultBlockState());
                event.getPlayer().getMainHandItem().shrink(1);
            }
        }
    }
}