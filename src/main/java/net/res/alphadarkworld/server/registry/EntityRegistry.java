package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.world.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AlphaDarkworld.MOD_ID);

    public static final RegistryObject<EntityType<DarkworldCreeper>> DARKWORLD_CREEPER = ENTITIES.register("darkworld_creeper",
            () -> EntityType.Builder.<DarkworldCreeper>of(DarkworldCreeper::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(AlphaDarkworld.MOD_ID, "darkworld_creeper").toString())
    );
}