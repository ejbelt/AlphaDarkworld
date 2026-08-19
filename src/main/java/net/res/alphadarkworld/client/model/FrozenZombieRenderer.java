package net.res.alphadarkworld.client.model;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.client.AlphaModelLayers;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;
import net.res.alphadarkworld.server.world.entity.mob.FrozenZombie;

public class FrozenZombieRenderer extends AbstractZombieRenderer<FrozenZombie, FrozenZombieModel<FrozenZombie>>{

    public FrozenZombieRenderer(Context pContext) {
        super(pContext, 
            new FrozenZombieModel<>(pContext.bakeLayer(AlphaModelLayers.FROZEN_ZOMBIE_LAYER)), 
            null,
            null );
    }
    
    @Override
    public ResourceLocation getTextureLocation(FrozenZombie pEntity) {
        return new ResourceLocation(AlphaDarkworld.MOD_ID, "textures/entity/darkworld/zombie/frozen.png");
    }

    @Override
    public void render(FrozenZombie pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
