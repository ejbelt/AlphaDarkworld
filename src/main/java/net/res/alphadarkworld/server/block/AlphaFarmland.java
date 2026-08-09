package net.res.alphadarkworld.server.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.res.alphadarkworld.server.registry.BlockRegistry;

public class AlphaFarmland extends FarmBlock {

    public AlphaFarmland(Properties pProperties) {
        super(pProperties);
    }

    
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            turnToAlphaDirt((Entity)null, pState, pLevel, pPos);
        }

    }

    public boolean canSustainPlant(BlockGetter level, BlockPos pos, Direction facing, IPlantable plantable){
        
        if (plantable.getPlantType(level, pos) == PlantType.CROP){
            return true;
        }

        return false;
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return !this.defaultBlockState().canSurvive(pContext.getLevel(), pContext.getClickedPos()) ? BlockRegistry.ALPHA_DIRT.get().defaultBlockState() : super.getStateForPlacement(pContext);
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pState.getValue(MOISTURE);
        if (!isNearWater(pLevel, pPos) && !pLevel.isRainingAt(pPos.above())) {
            if (i > 0) {
                pLevel.setBlock(pPos, pState.setValue(MOISTURE, Integer.valueOf(i - 1)), 2);
            } else if (!shouldMaintainFarmland(pLevel, pPos)) {
                turnToAlphaDirt((Entity)null, pState, pLevel, pPos);
            }
        } else if (i < 7) {
            pLevel.setBlock(pPos, pState.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }

    }

    private static boolean isNearWater(LevelReader pLevel, BlockPos pPos) {
        BlockState state = pLevel.getBlockState(pPos);
        for(BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-4, 0, -4), pPos.offset(4, 1, 4))) {
            if (state.canBeHydrated(pLevel, pPos, pLevel.getFluidState(blockpos), blockpos)) {
                return true;
            }
        }
        return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(pLevel, pPos);
    }

    public void fallOn(Level pLevel, BlockState pState, BlockPos pPos, Entity pEntity, float pFallDistance) {
        if (!pLevel.isClientSide && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(pLevel, pPos, BlockRegistry.ALPHA_DIRT.get().defaultBlockState(), pFallDistance, pEntity)) { // Forge: Move logic to Entity#canTrample
            turnToAlphaDirt(pEntity, pState, pLevel, pPos);
        }
    }

    private static boolean shouldMaintainFarmland(BlockGetter pLevel, BlockPos pPos) {
        BlockState plant = pLevel.getBlockState(pPos.above());
        BlockState state = pLevel.getBlockState(pPos);
        return plant.getBlock() instanceof net.minecraftforge.common.IPlantable && state.canSustainPlant(pLevel, pPos, Direction.UP, (net.minecraftforge.common.IPlantable)plant.getBlock());
    }
    
    public static void turnToAlphaDirt(@Nullable Entity pEntity, BlockState pState, Level pLevel, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(pState, BlockRegistry.ALPHA_DIRT.get().defaultBlockState(), pLevel, pPos);
        pLevel.setBlockAndUpdate(pPos, blockstate);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
        
    }
    
    public boolean isFertile(BlockState state, BlockGetter level, BlockPos pos){
        if (state.is(BlockRegistry.ALPHA_FARMLAND.get()))
            return state.getValue(AlphaFarmland.MOISTURE) > 0;

        return false;
    }

}
