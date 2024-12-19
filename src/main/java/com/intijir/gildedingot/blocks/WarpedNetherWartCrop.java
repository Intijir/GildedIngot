package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.items.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WarpedNetherWartCrop extends BeetrootBlock {
    private static final VoxelShape[] SHAPES =
            new VoxelShape[] {
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)2.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)4.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)6.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)10.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)12.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)14.0F, (double)16.0F),
                    Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F)
    };

    public WarpedNetherWartCrop(AbstractBlock.Properties builder) {
        super(builder.randomTicks());
    }

    protected IItemProvider getBaseSeedId() {
        return (IItemProvider)ModItems.WARPED_WART_SEED.get();
    }

    public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        return SHAPES[(Integer)state.getValue(this.getAgeProperty())];
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState pState, ServerWorld pLevel, BlockPos pPos, Random pRandom) {
            super.randomTick(pState, pLevel, pPos, pRandom);
    }

    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is((Block)ModBlocks.WARPED_SOUL_SOIL.get());
    }
}

