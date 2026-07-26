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

       /*this.tag(BlockTags.LEAVES)
        .add(
            BlockRegistry.ALPHA_LEAVES.get(),
            BlockRegistry.ALPHA_BIRCH_LEAVES.get()
        );*/
        
        this.tag(TagRegistry.Blocks.NEEDS_MITHRIL_TOOL)
            .add(
                BlockRegistry.RUBY_ORE.get(),
                BlockRegistry.RUBY_BLOCK.get()
            );
    }
}
