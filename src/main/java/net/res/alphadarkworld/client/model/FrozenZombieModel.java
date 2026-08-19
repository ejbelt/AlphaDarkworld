package net.res.alphadarkworld.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.res.alphadarkworld.server.world.entity.mob.DarkWorldZombie;

public class FrozenZombieModel <T extends DarkWorldZombie> extends ZombieModel<T> {

    public FrozenZombieModel(ModelPart pRoot) {
        super(pRoot);
    }

    public static LayerDefinition createBodyLayer() {
        CubeDeformation pCubeDeformation = new CubeDeformation(0.5f);
        MeshDefinition meshdefinition = HumanoidModel.createMesh(pCubeDeformation, 0.0F);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
