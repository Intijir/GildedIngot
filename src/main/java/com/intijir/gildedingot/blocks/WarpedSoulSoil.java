package com.intijir.gildedingot.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ToolType;

public class WarpedSoulSoil extends Block {
    public static final IntegerProperty MOISTURE;

    public WarpedSoulSoil() {
        super(Properties.of(Material.SAND).strength(0.5F, 0.5F)
                .harvestLevel(1).harvestTool(ToolType.SHOVEL).sound(SoundType.SAND).randomTicks());
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.UP && !stateIn.canSurvive(worldIn, currentPos)) {
            worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
        }
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? Blocks.SOUL_SOIL.defaultBlockState() : super.getStateForPlacement(context);
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.canSurvive(worldIn, pos)) {
            turnToSoulSoil(state, worldIn, pos);
        }
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        int i = (Integer)state.getValue(MOISTURE);
        if (!isNearLava(worldIn, pos) && !worldIn.isRainingAt(pos.above())) {
            if (i > 0) {
                worldIn.setBlock(pos, (BlockState)state.setValue(MOISTURE, i - 1), 2);
            } else if (!this.hasCrops(worldIn, pos)) {
                turnToSoulSoil(state, worldIn, pos);
            }
        } else if (i < 7) {
            worldIn.setBlock(pos, (BlockState)state.setValue(MOISTURE, 7), 2);
        }

    }

    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (!worldIn.isClientSide && ForgeHooks.onFarmlandTrample(worldIn, pos, Blocks.SOUL_SOIL.defaultBlockState(), fallDistance, entityIn)) {
            turnToSoulSoil(worldIn.getBlockState(pos), worldIn, pos);
        }

        super.fallOn(worldIn, pos, entityIn, fallDistance);
    }

    public static void turnToSoulSoil(BlockState state, World worldIn, BlockPos pos) {
        BlockState plant = worldIn.getBlockState(pos.above());
        if (plant == ModBlocks.WARPED_NETHER_WART_CROP.get().defaultBlockState()) {
            BlockState blockstate = pushEntitiesUp(state, Blocks.SOUL_SOIL.defaultBlockState(), worldIn, pos);
            worldIn.setBlockAndUpdate(pos, blockstate);
        }
        worldIn.setBlockAndUpdate(pos, Blocks.SOUL_SOIL.defaultBlockState());
    }

    private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
        BlockState plant = worldIn.getBlockState(pos.above());
        BlockState state = worldIn.getBlockState(pos);
        return plant.getBlock() instanceof WarpedNetherWartCrop && state.is(ModBlocks.WARPED_SOUL_SOIL.get());
    }

    private static boolean isNearLava(IWorldReader worldIn, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (worldIn.getFluidState(blockpos).is(FluidTags.LAVA)) {
                return true;
            }
        }
        return false;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{MOISTURE});
    }

    public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }

    static {
        MOISTURE = BlockStateProperties.MOISTURE;
    }
}
