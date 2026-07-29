package net.res.alphadarkworld.server.world.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.res.alphadarkworld.AlphaDarkworld;

public class AlphaFeatures {

    public static ResourceKey<Feature<?>> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, new ResourceLocation(AlphaDarkworld.MOD_ID, name));
    }

    /*private static <C extends FeatureConfiguration, F extends Feature<C>> F register(BootstapContext<Feature<?>> context, ResourceKey<Feature<?>> key, F feature){
        context.register(key, new Feature<>(feature));
    }*/

}
