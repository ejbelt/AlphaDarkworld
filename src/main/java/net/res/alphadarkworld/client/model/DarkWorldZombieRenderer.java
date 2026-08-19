package net.res.alphadarkworld.client.model;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.client.AlphaModelLayers;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldCreeper;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;
import net.minecraft.client.renderer.entity.DrownedRenderer;

public class DarkWorldZombieRenderer extends AbstractZombieRenderer<DarkWorldZombie, DarkWorldZombieModel<DarkWorldZombie>>{

    public DarkWorldZombieRenderer(Context pContext) {
        super(pContext, 
            new DarkWorldZombieModel<>(pContext.bakeLayer(AlphaModelLayers.FROZEN_ZOMBIE_LAYER)), 
            null,
            null );
    }
    
    @Override
    public ResourceLocation getTextureLocation(DarkWorldZombie pEntity) {
        return new ResourceLocation(AlphaDarkworld.MOD_ID, "textures/entity/darkworld/zombie/zombie.png");
    }

    @Override
    public void render(DarkWorldZombie pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
