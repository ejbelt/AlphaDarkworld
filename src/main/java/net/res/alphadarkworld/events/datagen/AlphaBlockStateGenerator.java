package net.res.alphadarkworld.events.datagen;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.BlockRegistry;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;

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
        blockWithItem(BlockRegistry.ALPHA_PLANKS);
        logWithItem(BlockRegistry.ALPHA_LOG);
        logWithItem(BlockRegistry.ALPHA_BIRCH_LOG);
        //saplingModel(BlockRegistry.ALPHA_SAPLING);
        //saplingModel(BlockRegistry.ALPHA_BIRCH_SAPLING);
        carpetBlock("ultramarine_carpet", BlockRegistry.ULTRAMARINE_CARPET, BlockRegistry.ULTRAMARINE_WOOL);
        carpetBlock("capri_carpet", BlockRegistry.CAPRI_CARPET, BlockRegistry.CAPRI_WOOL);
        carpetBlock("chartreuse_carpet", BlockRegistry.CHARTREUSE_CARPET, BlockRegistry.CHARTREUSE_WOOL);
        carpetBlock("rose_carpet", BlockRegistry.ROSE_CARPET, BlockRegistry.ROSE_WOOL);
        carpetBlock("spring_carpet", BlockRegistry.SPRING_CARPET, BlockRegistry.SPRING_WOOL);
        carpetBlock("violet_carpet", BlockRegistry.VIOLET_CARPET, BlockRegistry.VIOLET_WOOL);
        leavesBlock(BlockRegistry.ALPHA_LEAVES);
        leavesBlock(BlockRegistry.ALPHA_BIRCH_LEAVES);
    }

    private void carpetBlock(String name, RegistryObject<Block> blockRegistryObject, RegistryObject<Block> woolParent){
        String path = woolParent.getId().getPath();
        simpleBlockWithItem(blockRegistryObject.get(), models().carpet(name, new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path)));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void logWithItem(RegistryObject<RotatedPillarBlock> blockRegistryObject){
        String path = blockRegistryObject.getId().getPath();
        logBlock(blockRegistryObject.get());
        simpleBlockItem(blockRegistryObject.get(), models().cubeTop(path, new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path), new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_top")));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingModel(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void fourSidedBlock(RegistryObject<Block> blockRegistryObject){

        String path = blockRegistryObject.getId().getPath();
        horizontalBlock(blockRegistryObject.get(), models().orientableWithBottom(path, 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_side"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_front"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_bottom"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_top")));
        simpleBlockItem(blockRegistryObject.get(), models().orientableWithBottom(path, 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_side"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_front"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_bottom"), 
            new ResourceLocation(AlphaDarkworld.MOD_ID, "block/" + path +"_top")));
    }
}
