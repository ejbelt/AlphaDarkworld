package net.res.alphadarkworld.events;

import destiny.penumbra_phantasm.server.capability.SoulCapability;
import destiny.penumbra_phantasm.server.registry.CapabilityRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.res.alphadarkworld.AlphaDarkworld;

@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    
    @SubscribeEvent
    public static void darknessDeterminationTick(PlayerTickEvent event){
        Level cur_Level = event.player.level();
        ResourceKey<Level> dimension = cur_Level.dimension();
        SoulCapability soulCap = event.player.getCapability(CapabilityRegistry.SOUL).orElse(null);

        if (dimension.location().getPath().contains("alpha_darkness")) {
            if (!event.player.isCreative() && !event.player.isSpectator()) {
                if (SoulCapability.hasOwnSoulHearth(event.player)) {
                    if ((cur_Level.getGameTime() % 50) == 0){
                        soulCap.determination = Mth.clamp(soulCap.determination - 1, 0, 100);
                    }
                }
            }
        }

    }

}
