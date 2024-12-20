package com.intijir.gildedingot.items;

import com.intijir.gildedingot.GildedIngot;
import com.intijir.gildedingot.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

public class WarpedSeed extends BlockItem {
    public WarpedSeed() {
        super(ModBlocks.WARPED_NETHER_WART_CROP.get(),
                new Item.Properties().tab(GildedIngot.TAB));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        if (context.getPlayer() != null) {
            Level world = context.getPlayer().getCommandSenderWorld();
            if (world.getBlockState(pos).getBlock().equals(Blocks.SOUL_SOIL)) {
                world.setBlockAndUpdate(pos, ModBlocks.WARPED_SOUL_SOIL.get().defaultBlockState());
            }
            if (world.getBlockState(pos).getBlock().equals(ModBlocks.WARPED_SOUL_SOIL.get())) {
                world.setBlockAndUpdate(pos.above(), ModBlocks.WARPED_NETHER_WART_CROP.get().defaultBlockState());
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.NETHER_WART_PLANTED, SoundSource.BLOCKS, 1.0F, 3);
                if (context.getPlayer() != null) {
                    if (!context.getPlayer().isCreative()) {
                        context.getPlayer().getMainHandItem().shrink(1);
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
}
