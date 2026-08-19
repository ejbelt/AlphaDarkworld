package net.res.alphadarkworld.client.model;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.client.AlphaModelLayers;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldCreeper;

public class DarkWorldCreeperRenderer extends MobRenderer<DarkWorldCreeper, DarkWorldCreeperModel<DarkWorldCreeper>>{

    public DarkWorldCreeperRenderer(Context pContext) {
        super(pContext, new DarkWorldCreeperModel<>(pContext.bakeLayer(AlphaModelLayers.DARKWORLD_CREEPER_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(DarkWorldCreeper pEntity) {
        return new ResourceLocation(AlphaDarkworld.MOD_ID, "textures/entity/darkworld/creeper/creeper.png");
    }

    protected void scale(DarkWorldCreeper pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float f = pLivingEntity.getSwelling(pPartialTickTime);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        pPoseStack.scale(f2, f3, f2);
    }

    protected float getWhiteOverlayProgress(DarkWorldCreeper pLivingEntity, float pPartialTicks) {
        float f = pLivingEntity.getSwelling(pPartialTicks);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
    }
    
    @Override
    public void render(DarkWorldCreeper pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
