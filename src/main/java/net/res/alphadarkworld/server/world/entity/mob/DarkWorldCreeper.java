package net.res.alphadarkworld.server.world.entity.mob;

import java.text.AttributedCharacterIterator.Attribute;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class DarkWorldCreeper extends Creeper {

    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(DarkWorldCreeper.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_IS_POWERED = SynchedEntityData.defineId(DarkWorldCreeper.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED = SynchedEntityData.defineId(DarkWorldCreeper.class, EntityDataSerializers.BOOLEAN);
    private int oldSwell;
    private int swell;
    private int maxSwell = 30;
    private int explosionRadius = 4;
    private int droppedSkulls;

    public DarkWorldCreeper(EntityType<? extends Creeper> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        //TODO Auto-generated constructor stub
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.ARMOR_TOUGHNESS, 0.1)
            .add(Attributes.ARMOR, 2.0)
            .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.CREEPER_HURT;
    }


    protected SoundEvent getDeathSound() {
        return SoundEvents.CREEPER_DEATH;
    }


}
