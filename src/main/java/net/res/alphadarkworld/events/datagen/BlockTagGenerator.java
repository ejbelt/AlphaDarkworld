package net.res.alphadarkworld.events.datagen;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.*;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

public class BlockTagGenerator extends BlockTagsProvider {
    
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AlphaDarkworld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        
        this.tag(BlockTags.WOOL)
            .add(
                BlockRegistry.ULTRAMARINE_WOOL.get(),
                BlockRegistry.CAPRI_WOOL.get(),
                BlockRegistry.CHARTREUSE_WOOL.get(),
                BlockRegistry.ROSE_WOOL.get(),
                BlockRegistry.SPRING_WOOL.get(),
                BlockRegistry.VIOLET_WOOL.get()
            );

        this.tag(BlockTags.WOOL_CARPETS)
            .add(
                BlockRegistry.ULTRAMARINE_CARPET.get(),
                BlockRegistry.CAPRI_CARPET.get(),
                BlockRegistry.CHARTREUSE_CARPET.get(),
                BlockRegistry.ROSE_CARPET.get(),
                BlockRegistry.SPRING_CARPET.get(),
                BlockRegistry.VIOLET_CARPET.get()
            );

        this.tag(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
            .add(
                BlockRegistry.ULTRAMARINE_WOOL.get(),
                BlockRegistry.CAPRI_WOOL.get(),
                BlockRegistry.CHARTREUSE_WOOL.get(),
                BlockRegistry.ROSE_WOOL.get(),
                BlockRegistry.SPRING_WOOL.get(),
                BlockRegistry.VIOLET_WOOL.get()
            );

        this.tag(BlockTags.DAMPENS_VIBRATIONS)
            .add(
                BlockRegistry.ULTRAMARINE_WOOL.get(),
                BlockRegistry.CAPRI_WOOL.get(),
                BlockRegistry.CHARTREUSE_WOOL.get(),
                BlockRegistry.ROSE_WOOL.get(),
                BlockRegistry.SPRING_WOOL.get(),
                BlockRegistry.VIOLET_WOOL.get(),
                BlockRegistry.ULTRAMARINE_CARPET.get(),
                BlockRegistry.CAPRI_CARPET.get(),
                BlockRegistry.CHARTREUSE_CARPET.get(),
                BlockRegistry.ROSE_CARPET.get(),
                BlockRegistry.SPRING_CARPET.get(),
                BlockRegistry.VIOLET_CARPET.get()
            );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(
                BlockRegistry.MITHRIL_ORE.get(),
                BlockRegistry.RUBY_ORE.get(),
                BlockRegistry.MITHRIL_BLOCK.get(),
                BlockRegistry.RUBY_BLOCK.get(),
                BlockRegistry.RAW_MITHRIL_BLOCK.get()
            );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(
                BlockRegistry.MITHRIL_ORE.get(),
                BlockRegistry.RAW_MITHRIL_BLOCK.get(),
                BlockRegistry.MITHRIL_BLOCK.get()
            );
        
        this.tag(TagRegistry.Blocks.NEEDS_MITHRIL_TOOL)
            .add(
                BlockRegistry.RUBY_ORE.get(),
                BlockRegistry.RUBY_BLOCK.get()
            );
    }
}
