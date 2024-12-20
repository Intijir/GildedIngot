package com.intijir.gildedingot.blocks;

import com.intijir.gildedingot.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class WarpedNetherWartCrop extends BeetrootBlock {
    public WarpedNetherWartCrop() {
        super(Properties.copy(Blocks.NETHER_WART).randomTicks());
    }

    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.WARPED_WART_SEED.get();
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, blockPos, blockState, randomSource.nextInt(10) == 0)) {
            blockState = blockState.setValue(AGE, i + 1);
            serverLevel.setBlock(blockPos, blockState, 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, blockPos, blockState);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
    }

    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return SHAPE_BY_AGE[pState.getValue(this.getAgeProperty())];
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(ModBlocks.WARPED_SOUL_SOIL.get());
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, boolean pIsClient) {
        return false;
    }
}
