package net.res.alphadarkworld.events.datagen;

import java.util.Set;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.server.registry.*;

import java.util.List;
import java.util.Set;

public class BlockLootTableGenerator extends BlockLootSubProvider {

    protected BlockLootTableGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(BlockRegistry.RUBY_BLOCK.get());
        this.dropSelf(BlockRegistry.MITHRIL_BLOCK.get());
        this.dropSelf(BlockRegistry.RAW_MITHRIL_BLOCK.get());
        this.dropSelf(BlockRegistry.ULTRAMARINE_WOOL.get());
        this.dropSelf(BlockRegistry.CAPRI_WOOL.get());
        this.dropSelf(BlockRegistry.CHARTREUSE_WOOL.get());
        this.dropSelf(BlockRegistry.ROSE_WOOL.get());
        this.dropSelf(BlockRegistry.SPRING_WOOL.get());
        this.dropSelf(BlockRegistry.VIOLET_WOOL.get());
        this.dropSelf(BlockRegistry.ULTRAMARINE_CARPET.get());
        this.dropSelf(BlockRegistry.CAPRI_CARPET.get());
        this.dropSelf(BlockRegistry.CHARTREUSE_CARPET.get());
        this.dropSelf(BlockRegistry.ROSE_CARPET.get());
        this.dropSelf(BlockRegistry.SPRING_CARPET.get());
        this.dropSelf(BlockRegistry.VIOLET_CARPET.get());

        this.add(BlockRegistry.RUBY_ORE.get(), 
            block -> createOreDrop(block, ItemRegistry.RUBY.get()));

        this.add(BlockRegistry.MITHRIL_ORE.get(), 
            block -> createOreDrop(block, ItemRegistry.RAW_MITHRIL.get()));
    }

    @Override 
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    
}
