package net.res.alphadarkworld.client.renderer;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.client.model.DarkworldCreeperModel;
import net.res.alphadarkworld.world.entity.DarkworldCreeper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DarkworldCreeperRenderer extends MobRenderer<DarkworldCreeper, DarkworldCreeperModel<DarkworldCreeper>> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(AlphaDarkworld.MOD_ID, "textures/entity/darkworld/creeper.png");

    public DarkworldCreeperRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DarkworldCreeperModel<>(ctx.bakeLayer(DarkworldCreeperModel.LAYER_LOCATION)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(DarkworldCreeper entity) {
        return TEXTURE;
    }
}