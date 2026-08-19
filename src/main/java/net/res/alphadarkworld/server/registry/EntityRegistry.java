package net.res.alphadarkworld.server.registry;

import java.rmi.registry.Registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldCreeper;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;
import net.res.alphadarkworld.server.world.entity.mob.FrozenZombie;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AlphaDarkworld.MOD_ID);

    public static final RegistryObject<EntityType<DarkWorldCreeper>> DARKWORLD_CREEPER = 
        ENTITY_TYPES.register("darkworld_creeper", () -> EntityType.Builder.of(DarkWorldCreeper::new, MobCategory.MONSTER)
            .build("darkworld_creeper"));

    public static final RegistryObject<EntityType<DarkWorldZombie>> DARKWORLD_ZOMBIE = 
        ENTITY_TYPES.register("darkworld_zombie", () -> EntityType.Builder.of(DarkWorldZombie::new, MobCategory.MONSTER)
            .build("darkworld_zombie"));

    public static final RegistryObject<EntityType<FrozenZombie>> FROZEN_ZOMBIE = 
        ENTITY_TYPES.register("frozen_zombie", () -> EntityType.Builder.of(FrozenZombie::new, MobCategory.MONSTER)
            .build("frozen_zombie"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
