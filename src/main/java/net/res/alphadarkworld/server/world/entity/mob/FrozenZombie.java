package net.res.alphadarkworld.server.world.entity.mob;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.res.alphadarkworld.server.registry.ItemRegistry;
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

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        if (pRandom.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = pRandom.nextInt(3);
            if (i == 0) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.MITHRIL_SWORD.get()));
            } else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemRegistry.MITHRIL_AXE.get()));
            }
        }

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
