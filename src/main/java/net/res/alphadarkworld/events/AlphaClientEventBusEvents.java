package net.res.alphadarkworld.events;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.client.AlphaModelLayers;
import net.res.alphadarkworld.client.model.DarkWorldCreeperModel;
import net.res.alphadarkworld.client.model.DarkWorldZombieModel;
import net.res.alphadarkworld.client.model.FrozenZombieModel;

@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlphaClientEventBusEvents {
    
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(AlphaModelLayers.DARKWORLD_CREEPER_LAYER, DarkWorldCreeperModel::createBodyLayer);
        event.registerLayerDefinition(AlphaModelLayers.DARKWORLD_ZOMBIE_LAYER, DarkWorldZombieModel::createBodyLayer);
        event.registerLayerDefinition(AlphaModelLayers.FROZEN_ZOMBIE_LAYER, FrozenZombieModel::createBodyLayer);
    }

}