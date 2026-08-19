package net.res.alphadarkworld.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.res.alphadarkworld.AlphaDarkworld;

public class AlphaModelLayers {
    public static final ModelLayerLocation DARKWORLD_CREEPER_LAYER = new ModelLayerLocation(
        new ResourceLocation(
            AlphaDarkworld.MOD_ID, "textures/entity/darkworld/creeper/creeper"), "main");

    public static final ModelLayerLocation DARKWORLD_ZOMBIE_LAYER = new ModelLayerLocation(
        new ResourceLocation(
            AlphaDarkworld.MOD_ID, "textures/entity/darkworld/zombie/zombie"), "main");

    public static final ModelLayerLocation FROZEN_ZOMBIE_LAYER = new ModelLayerLocation(
        new ResourceLocation(
            AlphaDarkworld.MOD_ID, "textures/entity/darkworld/zombie/frozen"), "main");
    
}
