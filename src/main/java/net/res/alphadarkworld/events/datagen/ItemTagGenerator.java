package net.res.alphadarkworld.events.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.res.alphadarkworld.AlphaDarkworld;

public class ItemTagGenerator extends ItemTagsProvider{

    public ItemTagGenerator(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AlphaDarkworld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        
    }
    
}
