package net.res.alphadarkworld.server.datagen;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.BlockRegistry;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;

public class AlphaBlockStateGenerator extends BlockStateProvider {
    public AlphaBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlphaDarkworld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(BlockRegistry.MITHRIL_ORE);
        blockWithItem(BlockRegistry.RUBY_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
