package net.res.alphadarkworld.events;

import destiny.penumbra_phantasm.server.capability.SoulCapability;
import destiny.penumbra_phantasm.server.registry.CapabilityRegistry;
import destiny.penumbra_phantasm.server.util.DarkWorldUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.compatability.PenumbraAdditionsCompat;
import net.res.alphadarkworld.server.util.AlphaWorldUtil;

@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    
    @SubscribeEvent
    public static void darknessDeterminationTick(PlayerTickEvent event){
        Level cur_Level = event.player.level();
        ResourceKey<Level> dimension = cur_Level.dimension();
        SoulCapability soulCap = event.player.getCapability(CapabilityRegistry.SOUL).orElse(null);

        if (AlphaWorldUtil.isInSlip(dimension)) {
            if (!event.player.isCreative() && !event.player.isSpectator()) {
                if (SoulCapability.hasOwnSoulHearth(event.player)) {
                    if ((cur_Level.getGameTime() % 50) == 0){
                        soulCap.determination = Mth.clamp(soulCap.determination - 1, 0, 100);
                    }
                }
            }
        }

    }

    /* 
    //There has to be a better way. No true compatability until we find a better way.
    @SubscribeEvent
    public static void onCraftedEvent(ItemCraftedEvent event) {

        if (PenumbraAdditionsCompat.isInstalledServer) {
            if (DarkWorldUtil.isDarkWorld(event.getEntity().level())) {
            }
        }

    }
        */

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        System.out.println("alpha_darkworld: " + event.getRegistryKey().toString() + ", " + event.getResult());
    }

}
