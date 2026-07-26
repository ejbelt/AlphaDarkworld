package net.res.alphadarkworld.server.world.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.BlockRegistry;

public class AlphaConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALPHA_OAK_TREE_KEY = registerKey("alpha_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_ALPHA_OAK_TREE_KEY = registerKey("giant_alpha_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALPHA_BIRCH_TREE_KEY = registerKey("alpha_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_ALPHA_BIRCH_TREE_KEY = registerKey("giant_alpha_birch");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        /*register(context, ALPHA_OAK_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.ALPHA_LOG.get()),
                new StraightTrunkPlacer(4, 2, 0),
                
                BlockStateProvider.simple(BlockRegistry.ALPHA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).build());        

            
        register(context, GIANT_ALPHA_OAK_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.ALPHA_LOG.get()),
                new FancyTrunkPlacer(4, 11, 0),
                
                BlockStateProvider.simple(BlockRegistry.ALPHA_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),

                new TwoLayersFeatureSize(1, 0, 1)).build());      

        register(context, ALPHA_BIRCH_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.ALPHA_BIRCH_LOG.get()),
                new StraightTrunkPlacer(5, 2, 0),
                
                BlockStateProvider.simple(BlockRegistry.ALPHA_BIRCH_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),

                new TwoLayersFeatureSize(1, 0, 1)).build());   

        
        register(context, GIANT_ALPHA_BIRCH_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockRegistry.ALPHA_BIRCH_LOG.get()),
                new FancyTrunkPlacer(5, 12, 0),
                
                BlockStateProvider.simple(BlockRegistry.ALPHA_BIRCH_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),

                new TwoLayersFeatureSize(1, 0, 1)).build());   */

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AlphaDarkworld.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
