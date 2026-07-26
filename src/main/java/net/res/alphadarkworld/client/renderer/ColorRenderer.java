package net.res.alphadarkworld.client.renderer;

import net.res.alphadarkworld.AlphaDarkworld;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.res.alphadarkworld.server.registry.BlockRegistry;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;


@Mod.EventBusSubscriber(modid = AlphaDarkworld.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ColorRenderer {

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event)
    {
        //Leaves
        event.getBlockColors().register((state, world, pos, tintIndex) ->
            world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor(),
            BlockRegistry.ALPHA_LEAVES.get(), BlockRegistry.ALPHA_BIRCH_LEAVES.get());
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.getItemColors().register((stack, tintIndex) -> {
            BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, tintIndex); },
            BlockRegistry.ALPHA_LEAVES.get(), BlockRegistry.ALPHA_BIRCH_LEAVES.get());
    }

}
