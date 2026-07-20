package net.res.alphadarkworld.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.world.entity.DarkworldCreeper;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DarkworldCreeperModel<T extends DarkworldCreeper> extends CreeperModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(AlphaDarkworld.MOD_ID, "darkworld_creeper"), "main");

    public DarkworldCreeperModel(ModelPart root) {
        super(root);
    }

}