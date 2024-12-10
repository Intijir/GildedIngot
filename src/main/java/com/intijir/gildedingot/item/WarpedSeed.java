package com.intijir.gildedingot.item;

import com.intijir.gildedingot.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarpedSeed extends BlockItem {
    public WarpedSeed() {
        super(ModBlocks.WARPED_NETHER_WART_CROP,
                new FabricItemSettings());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        if (world.getBlockState(pos).getBlock().equals(Blocks.SOUL_SOIL)) {
            world.setBlockState(pos, ModBlocks.WARPED_SOUL_SOIL.getDefaultState());
        }
        if (world.getBlockState(pos).getBlock().equals(ModBlocks.WARPED_SOUL_SOIL)) {
            world.setBlockState(pos.up(), ModBlocks.WARPED_NETHER_WART_CROP.getDefaultState());
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_NETHER_WART_PLANT, SoundCategory.BLOCKS, 1.0F, 3);
            if (context.getPlayer() != null) {
                if (!context.getPlayer().isCreative()) {
                    context.getPlayer().getMainHandStack().decrement(1);
                }
            }
        }
        return ActionResult.PASS;
    }

}
