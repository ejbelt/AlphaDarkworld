package net.res.alphadarkworld.server.datagen;

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
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(
                BlockRegistry.MITHRIL_ORE.get(),
                BlockRegistry.RUBY_ORE.get()
            );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(
                BlockRegistry.MITHRIL_ORE.get()
            );
        
        this.tag(TagRegistry.Blocks.NEEDS_MITHRIL_TOOL)
            .add(
                BlockRegistry.RUBY_ORE.get()
            );
    }
}
