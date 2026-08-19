package net.res.alphadarkworld.server.world.entity.mob;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class FrozenZombie extends DarkWorldZombie{
    public FrozenZombie(EntityType<? extends FrozenZombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
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
