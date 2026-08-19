package net.res.alphadarkworld.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.EntityRegistry;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldCreeper;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;
import net.res.alphadarkworld.server.world.entity.mob.FrozenZombie;

@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlphaEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(EntityRegistry.DARKWORLD_CREEPER.get(), DarkWorldCreeper.createAttributes().build());
        event.put(EntityRegistry.DARKWORLD_ZOMBIE.get(), DarkWorldZombie.createAttributes().build());
        event.put(EntityRegistry.FROZEN_ZOMBIE.get(), FrozenZombie.createAttributes().build());
    }

}
