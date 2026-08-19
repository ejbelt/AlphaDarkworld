package net.res.alphadarkworld.client.model;

import net.minecraft.client.model.DrownedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.monster.Zombie;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;

public class DarkWorldZombieModel<T extends DarkWorldZombie> extends ZombieModel<T> {

    public DarkWorldZombieModel(ModelPart pRoot) {
        super(pRoot);
    }

    public static LayerDefinition createBodyLayer() {
        CubeDeformation pCubeDeformation = new CubeDeformation(0.5f);
        MeshDefinition meshdefinition = HumanoidModel.createMesh(pCubeDeformation, 0.0F);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
    
}
