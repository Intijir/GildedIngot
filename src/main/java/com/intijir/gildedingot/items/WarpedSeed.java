package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarpedSeed extends BlockItem {
    public WarpedSeed() {
        super(ModBlocks.WARPED_NETHER_WART_CROP.get(),
                new Item.Properties().tab(GildedIngot.TAB));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        BlockPos pos = context.getClickedPos();
        World world = context.getPlayer().getCommandSenderWorld();
        if (world.getBlockState(pos).getBlock().equals(Blocks.SOUL_SOIL)) {
            world.setBlockAndUpdate(pos, ModBlocks.WARPED_SOUL_SOIL.get().defaultBlockState());
        }
        if (world.getBlockState(pos).getBlock().equals(ModBlocks.WARPED_SOUL_SOIL.get())) {
            world.setBlockAndUpdate(pos.above(), ModBlocks.WARPED_NETHER_WART_CROP.get().defaultBlockState());
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.NETHER_WART_PLANTED, SoundCategory.BLOCKS, 1.0F, 3);
            if (context.getPlayer() != null) {
                if (!context.getPlayer().isCreative()) {
                    context.getPlayer().getMainHandItem().shrink(1);
                }
            }
        }
        return ActionResultType.PASS;
    }
}
