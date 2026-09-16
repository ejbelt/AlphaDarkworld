package net.res.alphadarkworld;

import com.mojang.logging.LogUtils;

import net.res.alphadarkworld.client.model.DarkWorldCreeperRenderer;
import net.res.alphadarkworld.client.model.DarkWorldZombieRenderer;
import net.res.alphadarkworld.client.model.FrozenZombieRenderer;
import net.res.alphadarkworld.server.compatability.PenumbraAdditionsCompat;
import net.res.alphadarkworld.server.registry.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlphaDarkworld.MOD_ID)
public class AlphaDarkworld
{
    public static final String MOD_ID = "alpha_darkworld";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AlphaDarkworld()
    {
        LOGGER.debug("Starting process for alpha_darkworld");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        modEventBus.addListener(this::commonSetup);

        PenumbraAdditionsCompat.isInstalledServer = ModList.get().isLoaded("penumbra_additions");

        MinecraftForge.EVENT_BUS.register(this);
        
        SoundRegistry.SOUNDS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        EntityRegistry.ENTITY_TYPES.register(modEventBus);
        AlphaFeatureRegistry.FEATURES.register(modEventBus);
        LOGGER.debug("Registry: " + AlphaFeatureRegistry.FEATURES.getRegistryName());
        LOGGER.debug("Alpha Darkworld Feature Count: " + String.valueOf(AlphaFeatureRegistry.FEATURES.getEntries().size()));


        LOGGER.debug("At current point of error.");
        CreativeTabRegistry.DEF_REG.register(modEventBus);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(EntityRegistry.DARKWORLD_CREEPER.get(), DarkWorldCreeperRenderer::new);
            EntityRenderers.register(EntityRegistry.DARKWORLD_ZOMBIE.get(), DarkWorldZombieRenderer::new);
            EntityRenderers.register(EntityRegistry.FROZEN_ZOMBIE.get(), FrozenZombieRenderer::new);
        }
    }
}