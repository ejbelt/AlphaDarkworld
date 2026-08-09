package net.res.alphadarkworld.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.res.alphadarkworld.server.registry.BlockRegistry;

public class AlphaDirt extends Block {

    public AlphaDirt(Properties p_153129_) {
        super(p_153129_);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos()) ? Block.pushEntitiesUp(this.defaultBlockState(), BlockRegistry.ALPHA_DIRT.get().defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos()) : super.getStateForPlacement(p_153131_);
    }
    
    public void tick(BlockState p_221070_, ServerLevel p_221071_, BlockPos p_221072_, RandomSource p_221073_) {
        AlphaFarmland.turnToAlphaDirt((Entity)null, p_221070_, p_221071_, p_221072_);
    }

    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate){

        Block block = state.getBlock();

        if (toolAction == ToolActions.HOE_TILL) {
            if (block == BlockRegistry.ALPHA_DIRT.get()) {
                return BlockRegistry.ALPHA_FARMLAND.get().defaultBlockState();
            }
        }
        
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    public boolean canSustainPlant(BlockGetter level, BlockPos pos, Direction facing, IPlantable plantable){
    
        if (plantable.getPlantType(level, pos) == PlantType.PLAINS){
            return true;
        }

        return false;
    }

}
