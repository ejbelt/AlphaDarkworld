package net.res.alphadarkworld.events.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.world.worldgen.AlphaBiomeModifiers;
import net.res.alphadarkworld.server.world.worldgen.AlphaConfiguredFeatures;
import net.res.alphadarkworld.server.world.worldgen.AlphaPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;


public class WorldGenGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, AlphaConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, AlphaPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, AlphaBiomeModifiers::bootstrap);

    public WorldGenGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(AlphaDarkworld.MOD_ID));
    }
}
