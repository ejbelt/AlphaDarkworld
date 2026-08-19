package net.res.alphadarkworld.events;

import destiny.penumbra_phantasm.server.block.LuminescentWaterFluidBlock;
import destiny.penumbra_phantasm.server.item.ScarletBucketItem;
import destiny.penumbra_phantasm.server.registry.FluidRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.LavaFluid;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.item.MithrilBucket;
import net.res.alphadarkworld.server.registry.ItemRegistry;

@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    
    @SubscribeEvent
    public static void onFillBucket(FillBucketEvent event) {
        ItemStack emptyBucket = event.getEmptyBucket();

        if (!(emptyBucket.getItem() instanceof BucketItem bucketItem) || bucketItem.getFluid() != Fluids.EMPTY) {
            return;
        }

        Level level = event.getLevel();
        Vec3 location = event.getTarget().getLocation();
        BlockPos clickPos = BlockPos.containing(location.x, location.y, location.z);
        BlockState blockState = level.getBlockState(clickPos);
        FluidState fluidState = blockState.getFluidState();

        boolean isMithrilBucket = emptyBucket.getItem() instanceof MithrilBucket;

        boolean isWater = fluidState.is(Fluids.WATER);
        boolean isLava = fluidState.is(Fluids.LAVA);
        boolean isLuminescent = fluidState.is(FluidRegistry.SOURCE_PURE_DARKNESS.get());
        boolean isDarkness = fluidState.is(FluidRegistry.SOURCE_PURE_DARKNESS.get());

        if (isMithrilBucket){
            if (isWater){
                event.setFilledBucket(new ItemStack(ItemRegistry.MITHRIL_WATER_BUCKET.get()));
            } else if (isLava) {
                event.setFilledBucket(new ItemStack(ItemRegistry.MITHRIL_LAVA_BUCKET.get()));
            } else if (isLuminescent) {
                event.setFilledBucket(new ItemStack(ItemRegistry.LUMINESCENT_WATER_MITRHIL_BUCKET.get()));
            } else if (isDarkness) {
                event.setFilledBucket(new ItemStack(ItemRegistry.PURE_DARKNESS_MITHRIL_BUCKET.get()));
            }
        }

    }
    
}
