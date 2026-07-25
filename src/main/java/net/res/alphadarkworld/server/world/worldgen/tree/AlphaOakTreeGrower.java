package net.res.alphadarkworld.server.world.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.res.alphadarkworld.server.world.worldgen.AlphaConfiguredFeatures;

import java.lang.Math;

public class AlphaOakTreeGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        if (Math.abs(pRandom.nextInt()) >= 900000000) {
            return AlphaConfiguredFeatures.GIANT_ALPHA_OAK_TREE_KEY;
        }
        return AlphaConfiguredFeatures.ALPHA_OAK_TREE_KEY;
    }
    
}

