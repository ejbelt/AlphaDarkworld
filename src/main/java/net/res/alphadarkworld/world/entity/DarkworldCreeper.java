package net.res.alphadarkworld.world.entity;

import net.res.alphadarkworld.server.registry.EntityRegistry;
import net.res.alphadarkworld.server.registry.EntityRegistry;

import net.minecraft.world.entity.monster.Monster;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class DarkworldCreeper extends Creeper {

    public DarkworldCreeper(EntityType<DarkworldCreeper> type, Level level) {
        super(type, level);
    }

    public DarkworldCreeper(Level level, double x, double y, double z) {
        this(EntityRegistry.DARKWORLD_CREEPER.get(), level);
        setPos(x, y, z);
    }

    public DarkworldCreeper(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(), position.getZ());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Creeper.createAttributes();
    }

    public static boolean canSpawn(EntityType<DarkworldCreeper> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Monster.checkAnyLightMonsterSpawnRules(entityType, level, spawnType, position, random);
    }

}