package net.res.alphadarkworld.server.item;

import javax.annotation.Nullable;

import destiny.penumbra_phantasm.server.block.LuminescentWaterFluidBlock;
import destiny.penumbra_phantasm.server.registry.FluidRegistry;
import net.res.alphadarkworld.server.registry.*;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class MithrilBucket extends BucketItem {
    
    private final Fluid content;
    
    public MithrilBucket(Fluid pContent, Properties pProperties) {
        super(pContent, pProperties);
        this.content = pContent;
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
      ItemStack itemstack = pPlayer.getItemInHand(pHand);
      BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
      if (blockhitresult.getType() == HitResult.Type.MISS) {
         return InteractionResultHolder.pass(itemstack);
      } else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
         return InteractionResultHolder.pass(itemstack);
      } else {
         BlockPos blockpos = blockhitresult.getBlockPos();
         Direction direction = blockhitresult.getDirection();
         BlockPos blockpos1 = blockpos.relative(direction);
         if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos1, direction, itemstack)) {
            if (this.content == Fluids.EMPTY) {
               BlockState blockstate1 = pLevel.getBlockState(blockpos);

               boolean canPickUp = canPickUpFluid(blockstate1);

               if (!canPickUp) return InteractionResultHolder.fail(itemstack);

               if (blockstate1.getBlock() instanceof BucketPickup) {
                  BucketPickup bucketpickup = (BucketPickup)blockstate1.getBlock();

                  ItemStack test = bucketpickup.pickupBlock(pLevel, blockpos, blockstate1);
                  ItemStack itemstack1 = determineFluidHack(test);

                  if (!itemstack1.isEmpty()) {
                     pPlayer.awardStat(Stats.ITEM_USED.get(this));
                     bucketpickup.getPickupSound(blockstate1).ifPresent((p_150709_) -> {
                        pPlayer.playSound(p_150709_, 1.0F, 1.0F);
                     });
                     pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, blockpos);
                     ItemStack itemstack2 = BucketItemUtils.createFilledResult(itemstack, pPlayer, itemstack1);
                     if (!pLevel.isClientSide) {
                        CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)pPlayer, itemstack1);
                     }

                     return InteractionResultHolder.sidedSuccess(itemstack2, pLevel.isClientSide());
                  }
               }

               return InteractionResultHolder.fail(itemstack);
            } else {
               BlockState blockstate = pLevel.getBlockState(blockpos);
               BlockPos blockpos2 = canBlockContainFluid(pLevel, blockpos, blockstate) ? blockpos : blockpos1;
               if (this.emptyContents(pPlayer, pLevel, blockpos2, blockhitresult, itemstack)) {
                  this.checkExtraContent(pPlayer, pLevel, itemstack, blockpos2);
                  if (pPlayer instanceof ServerPlayer) {
                     CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)pPlayer, blockpos2, itemstack);
                  }

                  pPlayer.awardStat(Stats.ITEM_USED.get(this));
                  return InteractionResultHolder.sidedSuccess(getEmptySuccessItem(itemstack, pPlayer), pLevel.isClientSide());
               } else {
                  return InteractionResultHolder.fail(itemstack);
               }
            }
         } else {
            return InteractionResultHolder.fail(itemstack);
         }
      }
   }

   public boolean canPickUpFluid(BlockState state) {
    FluidState fluidState = state.getFluidState();

    if (fluidState.is(Fluids.WATER)){
        return true;
    } else if (fluidState.is(Fluids.LAVA)){
        return true;
    } else if (fluidState.is(FluidRegistry.SOURCE_LUMINESCENT_WATER.get())) {
        return true;
    } else if (fluidState.is(FluidRegistry.SOURCE_PURE_DARKNESS.get())) {
        return true;
    }
 
    return false;
   }

   public ItemStack determineFluidHack(ItemStack bucketItem) {
    ItemStack filled_result = new ItemStack(ItemRegistry.MITHRIL_BUCKET.get());

    String hackString = bucketItem.getItem().toString();

    if  (hackString.contains("luminescent_water_bucket")){
        filled_result = new ItemStack(ItemRegistry.LUMINESCENT_WATER_MITRHIL_BUCKET.get());
    } else if  (hackString.contains("lava_bucket")){
        filled_result = new ItemStack(ItemRegistry.MITHRIL_LAVA_BUCKET.get());
    } else if (hackString.contains("water_bucket")) {
        filled_result = new ItemStack(ItemRegistry.MITHRIL_WATER_BUCKET.get());
    } else if  (hackString.contains("pure_darkness_bucket")){
        filled_result = new ItemStack(ItemRegistry.PURE_DARKNESS_MITHRIL_BUCKET.get());
    }

    return filled_result;
   }

   public ItemStack determineFluid(Level pLevel, Player pPlayer, BlockPos blockpos){

        BlockPos clickPos = blockpos;
        BlockState blockState = pLevel.getBlockState(clickPos);
        FluidState fluidState = blockState.getFluidState();

        boolean isWater = fluidState.is(Fluids.WATER);
        boolean isLava = fluidState.is(Fluids.LAVA);
        boolean isLuminescent = fluidState.is(FluidRegistry.SOURCE_LUMINESCENT_WATER.get());
        boolean isDarkness = fluidState.is(FluidRegistry.SOURCE_PURE_DARKNESS.get());

        ItemStack filled_result = new ItemStack(ItemRegistry.MITHRIL_BUCKET.get());

        if (isWater){
            filled_result = new ItemStack(ItemRegistry.MITHRIL_WATER_BUCKET.get());
        } else if (isLava) {
            filled_result = new ItemStack(ItemRegistry.MITHRIL_LAVA_BUCKET.get());
        } else if (isLuminescent) {
            filled_result = new ItemStack(ItemRegistry.LUMINESCENT_WATER_MITRHIL_BUCKET.get());
        } else if (isDarkness) {
            filled_result = new ItemStack(ItemRegistry.PURE_DARKNESS_MITHRIL_BUCKET.get());
        }

        return filled_result;

   }


   @Override
   public boolean emptyContents(@Nullable Player pPlayer, Level pLevel, BlockPos pPos, @Nullable BlockHitResult pResult, @Nullable ItemStack container) {
      if (!(this.content instanceof FlowingFluid)) {
         return false;
      } else {
         BlockState blockstate = pLevel.getBlockState(pPos);
         Block block = blockstate.getBlock();
         boolean flag = blockstate.canBeReplaced(this.content);
         boolean flag1 = blockstate.isAir() || flag || block instanceof LiquidBlockContainer && ((LiquidBlockContainer)block).canPlaceLiquid(pLevel, pPos, blockstate, this.content);
         java.util.Optional<net.minecraftforge.fluids.FluidStack> containedFluidStack = java.util.Optional.ofNullable(container).flatMap(net.minecraftforge.fluids.FluidUtil::getFluidContained);
         if (!flag1) {
            return pResult != null && this.emptyContents(pPlayer, pLevel, pResult.getBlockPos().relative(pResult.getDirection()), (BlockHitResult)null, container);
         } else if (containedFluidStack.isPresent() && this.content.getFluidType().isVaporizedOnPlacement(pLevel, pPos, containedFluidStack.get())) {
            this.content.getFluidType().onVaporize(pPlayer, pLevel, pPos, containedFluidStack.get());
            return true;
         } else if (pLevel.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
            int i = pPos.getX();
            int j = pPos.getY();
            int k = pPos.getZ();
            pLevel.playSound(pPlayer, pPos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (pLevel.random.nextFloat() - pLevel.random.nextFloat()) * 0.8F);

            for(int l = 0; l < 8; ++l) {
               pLevel.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
            }

            return true;
         } else if (block instanceof LiquidBlockContainer && ((LiquidBlockContainer)block).canPlaceLiquid(pLevel,pPos,blockstate,content)) {
            ((LiquidBlockContainer)block).placeLiquid(pLevel, pPos, blockstate, ((FlowingFluid)this.content).getSource(false));
            this.playEmptySound(pPlayer, pLevel, pPos);
            return true;
         } else {
            if (!pLevel.isClientSide && flag && !blockstate.liquid()) {
               pLevel.destroyBlock(pPos, true);
            }

            if (!pLevel.setBlock(pPos, this.content.defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
               return false;
            } else {
               this.playEmptySound(pPlayer, pLevel, pPos);
               return true;
            }
         }
      }
   }

   @Override
   public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundTag nbt) {
      if (this.getClass() == MithrilBucket.class)
         return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
      else
         return super.initCapabilities(stack, nbt);
   }

   public static ItemStack getEmptySuccessItem(ItemStack pBucketStack, Player pPlayer) {
      return !pPlayer.getAbilities().instabuild ? new ItemStack(ItemRegistry.MITHRIL_BUCKET.get()) : pBucketStack;
   }

}
