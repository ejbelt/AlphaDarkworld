package net.res.alphadarkworld.server.block;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.res.alphadarkworld.server.registry.DamageTypeRegistry;

public class LoveFlower extends FlowerBlock {

    public LoveFlower(Supplier<MobEffect> effectSupplier, int pEffectDuration, Properties pProperties) {
        super(effectSupplier, pEffectDuration, pProperties);
    }

    public LoveFlower(MobEffect effectSupplier, int pEffectDuration, Properties pProperties) {
        super(effectSupplier, pEffectDuration, pProperties);
    }
 
    
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.hurt(DamageTypeRegistry.getSimpleDamageSource(pLevel, DamageTypeRegistry.OTHER_SOUL_DAMAGE), 1.0F);
    }

}
