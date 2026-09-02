package net.res.alphadarkworld.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;
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

    @SubscribeEvent
    public static void testForRecipes(FMLCommonSetupEvent event) {
        System.out.println("data.alpha_darkworld: " + event.getResult().toString() + " " + event.description());
    }


    @SubscribeEvent
    public static void testForDatapack(RegisterEvent event) {
        System.out.println("alpha_darkworld: " + event.getRegistryKey().toString() + ", " + event.getForgeRegistry());
    }

}
