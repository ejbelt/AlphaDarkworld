package net.res.alphadarkworld.server.registry;


import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.world.worldgen.tree.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.util.valueproviders.UniformInt;

import java.util.function.Supplier;

public class BlockRegistry {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlphaDarkworld.MOD_ID);

    public static final BlockBehaviour.Properties MITHRIL_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.METAL);
    public static final BlockBehaviour.Properties RUBY_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().sound(SoundType.METAL);
    public static final BlockBehaviour.Properties RAW_BLOCK_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops();
    public static final BlockBehaviour.Properties CLOTH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL);
    public static final BlockBehaviour.Properties CARPET_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET);

    public static final BlockBehaviour.Properties WOOD_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
    public static final BlockBehaviour.Properties LOG_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_WOOD);
    public static final BlockBehaviour.Properties LEAF_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES);

    //Ruby
    public static final RegistryObject<Block> RUBY_ORE 
    = registerBlock("ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(0, 1)));

    public static final RegistryObject<Block> RUBY_BLOCK 
    = registerBlock("ruby_block", () -> new Block(RUBY_PROPERTIES));

    //Mithril
    public static final RegistryObject<Block> MITHRIL_ORE
    = registerBlock("mithril_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MITHRIL_BLOCK 
    = registerBlock("mithril_block", () -> new Block(MITHRIL_PROPERTIES));

    public static final RegistryObject<Block> RAW_MITHRIL_BLOCK 
    = registerBlock("raw_mithril_block", () -> new Block(MITHRIL_PROPERTIES));

    ///Wool Time
    /// 
    
    public static final RegistryObject<Block> ULTRAMARINE_WOOL 
    = registerBlock("ultramarine_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CAPRI_WOOL 
    = registerBlock("capri_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CHARTREUSE_WOOL 
    = registerBlock("chartreuse_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> ROSE_WOOL 
    = registerBlock("rose_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> SPRING_WOOL 
    = registerBlock("spring_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> VIOLET_WOOL 
    = registerBlock("violet_wool", () -> new Block(CLOTH_PROPERTIES.mapColor(MapColor.COLOR_PURPLE)));

    
    //Carpets.
    public static final RegistryObject<Block> ULTRAMARINE_CARPET 
    = registerBlock("ultramarine_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> CAPRI_CARPET 
    = registerBlock("capri_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> CHARTREUSE_CARPET 
    = registerBlock("chartreuse_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> ROSE_CARPET 
    = registerBlock("rose_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> SPRING_CARPET 
    = registerBlock("spring_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> VIOLET_CARPET 
    = registerBlock("violet_carpet", () -> new CarpetBlock(CARPET_PROPERTIES.mapColor(MapColor.COLOR_PURPLE)));

    //Woodstuff.
    public static final RegistryObject<Block> ALPHA_PLANKS
    = registerBlock("alpha_planks", () -> new Block(WOOD_PROPERTIES));

    public static final RegistryObject<RotatedPillarBlock> ALPHA_LOG
    = registerBlock("alpha_log", () -> new RotatedPillarBlock(LOG_PROPERTIES));
    public static final RegistryObject<RotatedPillarBlock> ALPHA_BIRCH_LOG
    = registerBlock("alpha_birch_log", () -> new RotatedPillarBlock(LOG_PROPERTIES));

    ///
    /// NEVERMIND YOU DON'T GET TO DECAY
    /// WHY? BECAUSE MINECRAFT AND FORGE HATES ME THAT'S WHY!!!!
    /// I try to make these into LeavesBlocks
    /// The result is leaves UNRELATED to these leaves will immediatley start decaying.
    /// SO FUCK YOU.
    public static final RegistryObject<Block> ALPHA_LEAVES
    = registerBlock("alpha_leaves", () -> new Block(LEAF_PROPERTIES));
    public static final RegistryObject<Block> ALPHA_BIRCH_LEAVES
    = registerBlock("alpha_birch_leaves", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));

    
    /*public static final RegistryObject<Block> ALPHA_SAPLING
    = registerBlock("alpha_sapling", () -> new SaplingBlock(new AlphaOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> ALPHA_BIRCH_SAPLING
    = registerBlock("alpha_birch_sapling", () -> new SaplingBlock(new AlphaBirchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));*/

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}