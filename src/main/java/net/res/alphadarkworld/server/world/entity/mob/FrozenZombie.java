package net.res.alphadarkworld.server.world.entity.mob;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.res.alphadarkworld.server.registry.SoundRegistry;

public class FrozenZombie extends DarkWorldZombie{
    public FrozenZombie(EntityType<? extends FrozenZombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
    }

    @Override
    public boolean isUnderWaterConverting() {
        return false;
    }
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROZEN_ZOMBIE_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundRegistry.FROZEN_ZOMBIE_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.FROZEN_ZOMBIE_DEATH.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = super.doHurtTarget(pEntity);
        if (flag && this.getMainHandItem().isEmpty() && pEntity instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140 * (int)f), this);
        }

        return flag;
    }
}
