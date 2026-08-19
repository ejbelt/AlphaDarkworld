package net.res.alphadarkworld.server.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import net.res.alphadarkworld.AlphaDarkworld;

public class DamageTypeRegistry {
    public static final ResourceKey<DamageType> MOB_SOUL_DAMAGE =  ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(AlphaDarkworld.MOD_ID, "mob_soul_damage"));
    public static final ResourceKey<DamageType> OTHER_SOUL_DAMAGE =  ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(AlphaDarkworld.MOD_ID, "other_soul_damage"));

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
    }
}
