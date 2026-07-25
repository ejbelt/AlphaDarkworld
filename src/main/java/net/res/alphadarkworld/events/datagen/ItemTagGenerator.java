package net.res.alphadarkworld.events.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.ItemRegistry;

public class ItemTagGenerator extends ItemTagsProvider{

    public ItemTagGenerator(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AlphaDarkworld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
            .add(
                ItemRegistry.MITHRIL_HELMET.get(),
                ItemRegistry.MITHRIL_CHESTPLATE.get(),
                ItemRegistry.MITHRIL_LEGGINGS.get(),
                ItemRegistry.MITHRIL_BOOTS.get(),
                ItemRegistry.RUBY_HELMET.get(),
                ItemRegistry.RUBY_BOOTS.get(),
                ItemRegistry.RUBY_CHESTPLATE.get(),
                ItemRegistry.RUBY_LEGGINGS.get()
            );
    }
    
}
