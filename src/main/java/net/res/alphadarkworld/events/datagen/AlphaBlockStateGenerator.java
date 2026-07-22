package net.res.alphadarkworld.events.datagen;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.BlockRegistry;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class AlphaBlockStateGenerator extends BlockStateProvider {
    public AlphaBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlphaDarkworld.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(BlockRegistry.MITHRIL_ORE);
        blockWithItem(BlockRegistry.RUBY_ORE);
        blockWithItem(BlockRegistry.RUBY_BLOCK);
        blockWithItem(BlockRegistry.MITHRIL_BLOCK);
        blockWithItem(BlockRegistry.RAW_MITHRIL_BLOCK);
        blockWithItem(BlockRegistry.ULTRAMARINE_WOOL);
        blockWithItem(BlockRegistry.CAPRI_WOOL);
        blockWithItem(BlockRegistry.CHARTREUSE_WOOL);
        blockWithItem(BlockRegistry.ROSE_WOOL);
        blockWithItem(BlockRegistry.SPRING_WOOL);
        blockWithItem(BlockRegistry.VIOLET_WOOL);
        carpetBlock("ultramarine_carpet", BlockRegistry.ULTRAMARINE_CARPET, BlockRegistry.ULTRAMARINE_WOOL);
        carpetBlock("capri_carpet", BlockRegistry.CAPRI_CARPET, BlockRegistry.CAPRI_WOOL);
        carpetBlock("chartreuse_carpet", BlockRegistry.CHARTREUSE_CARPET, BlockRegistry.CHARTREUSE_WOOL);
        carpetBlock("rose_carpet", BlockRegistry.ROSE_CARPET, BlockRegistry.ROSE_WOOL);
        carpetBlock("spring_carpet", BlockRegistry.SPRING_CARPET, BlockRegistry.SPRING_WOOL);
        carpetBlock("violet_carpet", BlockRegistry.VIOLET_CARPET, BlockRegistry.VIOLET_WOOL);
    }

    private void carpetBlock(String name, RegistryObject<Block> blockRegistryObject, RegistryObject<Block> woolParent){
        String path = woolParent.getId().getPath();
        simpleBlock(blockRegistryObject.get(), models().carpet(name, new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path)));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
