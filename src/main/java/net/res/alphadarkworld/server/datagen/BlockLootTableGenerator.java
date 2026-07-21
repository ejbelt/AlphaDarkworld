package net.res.alphadarkworld.server.datagen;

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
