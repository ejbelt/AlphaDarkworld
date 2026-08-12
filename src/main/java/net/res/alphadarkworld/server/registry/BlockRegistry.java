package net.res.alphadarkworld.server.registry;


import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.block.*;
import net.res.alphadarkworld.server.world.worldgen.tree.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;

import java.util.function.Supplier;

public class BlockRegistry {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlphaDarkworld.MOD_ID);

    public static final BlockBehaviour.Properties MITHRIL_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundTypeRegistry.ALPHA_DENSE_STONE);
    public static final BlockBehaviour.Properties RUBY_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().sound(SoundTypeRegistry.ALPHA_DENSE_STONE);
    public static final BlockBehaviour.Properties RAW_BLOCK_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().sound(SoundTypeRegistry.ALPHA_STONE);
    public static final BlockBehaviour.Properties CLOTH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL);
    public static final BlockBehaviour.Properties CARPET_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET);

    public static final BlockBehaviour.Properties WOOD_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundTypeRegistry.ALPHA_WOOD);
    public static final BlockBehaviour.Properties LOG_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundTypeRegistry.ALPHA_WOOD);
    public static final BlockBehaviour.Properties LEAF_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundTypeRegistry.ALPHA_GRASS);


    //Nature
    public static final RegistryObject<Block> ALPHA_GRASS_BLOCK
    = registerBlock("alpha_grass", () -> new AlphaGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).sound(SoundTypeRegistry.ALPHA_GRASS)));
    public static final RegistryObject<Block> ALPHA_DIRT
    = registerBlock("alpha_dirt", () -> new AlphaDirt(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundTypeRegistry.ALPHA_DIRT)));
    public static final RegistryObject<Block> LIMESTONE
    = registerBlock("darkner_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<Block> BRIMSTONE
    = registerBlock("brimstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<Block> RUBY_ORE 
    = registerBlock("ruby_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundTypeRegistry.ALPHA_STONE), UniformInt.of(0, 1)));
    public static final RegistryObject<Block> MITHRIL_ORE
    = registerBlock("mithril_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops().sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<Block> SULFUR_ORE
    = registerBlock("darkner_coal_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).requiresCorrectToolForDrops().sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<Block> ALPHA_SAND
    = registerBlock("alpha_sand", () -> new SandBlock(14406560, BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundTypeRegistry.ALPHA_SAND)));
    public static final RegistryObject<Block> ALPHA_GRAVEL 
    = registerBlock("alpha_gravel", () -> new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).sound(SoundTypeRegistry.ALPHA_DIRT)));
    public static final RegistryObject<Block> ALPHA_MOSS
    = registerBlock("alpha_moss", () -> new MossBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).sound(SoundTypeRegistry.ALPHA_GRASS)));
    public static final RegistryObject<Block> ALPHA_MOSS_CARPET
    = registerBlock("alpha_moss_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_CARPET).sound(SoundTypeRegistry.ALPHA_GRASS)));

    /*
    
    Building Blocks
    
    */
    
    //Alpha Cobble
    public static final RegistryObject<Block> ALPHA_COBBLESTONE
    = registerBlock("alpha_cobblestone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<SlabBlock> ALPHA_COBBLESTONE_SLAB
    = registerBlock("alpha_cobblestone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<StairBlock> ALPHA_COBBLESTONE_STAIRS
    = registerBlock("alpha_cobblestone_stairs", () -> new StairBlock(ALPHA_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<WallBlock> ALPHA_COBBLESTONE_WALL
    = registerBlock("alpha_cobblestone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL).sound(SoundTypeRegistry.ALPHA_STONE)));

    //Alpha Mossy Cobble
    public static final RegistryObject<Block> ALPHA_MOSSY_COBBLESTONE
    = registerBlock("alpha_mossy_cobblestone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MOSSY_COBBLESTONE).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<SlabBlock> ALPHA_MOSSY_COBBLESTONE_SLAB
    = registerBlock("alpha_mossy_cobblestone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<StairBlock> ALPHA_MOSSY_COBBLESTONE_STAIRS
    = registerBlock("alpha_mossy_cobblestone_stairs", () -> new StairBlock(ALPHA_MOSSY_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<WallBlock> ALPHA_MOSSY_COBBLESTONE_WALL
    = registerBlock("alpha_mossy_cobblestone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL).sound(SoundTypeRegistry.ALPHA_STONE)));
    
    //Alpha Bricks
    public static final RegistryObject<Block> ALPHA_BRICKS
    = registerBlock("alpha_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<SlabBlock> ALPHA_BRICK_SLAB
    = registerBlock("alpha_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<StairBlock> ALPHA_BRICK_STAIRS
    = registerBlock("alpha_brick_stairs", () -> new StairBlock(ALPHA_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<WallBlock> ALPHA_BRICK_WALL
    = registerBlock("alpha_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL).sound(SoundTypeRegistry.ALPHA_STONE)));

    //Ruby
    public static final RegistryObject<Block> RUBY_BLOCK 
    = registerBlock("ruby_block", () -> new Block(RUBY_PROPERTIES));

    //Mithril
    public static final RegistryObject<Block> MITHRIL_BLOCK 
    = registerBlock("mithril_block", () -> new Block(MITHRIL_PROPERTIES));
    public static final RegistryObject<Block> RAW_MITHRIL_BLOCK 
    = registerBlock("raw_mithril_block", () -> new Block(MITHRIL_PROPERTIES));
    public static final RegistryObject<Block> MITHRIL_GLASS
    = registerBlock("mithril_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundTypeRegistry.ALPHA_GLASS)));
    //public static final RegistryObject<Block> MITHRIL_GLASS_PANE
    //= registerBlock("mithril_glass_pane", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    
    //Wood
    public static final RegistryObject<Block> ALPHA_PLANKS
    = registerBlock("alpha_planks", () -> new Block(WOOD_PROPERTIES));
    public static final RegistryObject<SlabBlock> ALPHA_WOODEN_SLAB
    = registerBlock("alpha_wooden_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB).sound(SoundTypeRegistry.ALPHA_STONE)));
    public static final RegistryObject<StairBlock> ALPHA_WOODEN_STAIRS
    = registerBlock("alpha_wooden_stairs", () -> new StairBlock(ALPHA_MOSSY_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundTypeRegistry.ALPHA_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> ALPHA_LOG
    = registerBlock("alpha_log", () -> new RotatedPillarBlock(LOG_PROPERTIES));
    public static final RegistryObject<RotatedPillarBlock> ALPHA_BIRCH_LOG
    = registerBlock("alpha_birch_log", () -> new RotatedPillarBlock(LOG_PROPERTIES));
    public static final RegistryObject<DoorBlock> ALPHA_DOOR
    = registerBlock("alpha_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundTypeRegistry.ALPHA_WOOD), BlockSetRegistry.ALPHA_WOOD_BLOCKSET));

    //Wool
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

    //Misc.
    
    public static final RegistryObject<Block> ALPHA_GLASS
    = registerBlock("alpha_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundTypeRegistry.ALPHA_GLASS)));


    ///
    /// NEVERMIND YOU DON'T GET TO DECAY
    /// WHY? BECAUSE MINECRAFT AND FORGE HATES ME THAT'S WHY!!!!
    /// I try to make these into LeavesBlocks
    /// The result is leaves UNRELATED to these leaves will immediatley start decaying.
    /// SO FUCK YOU.
    /// Anyways, leaves....
    /// 
    /// ...nevermind this rant. I fixed it.
    
    
    
    public static final RegistryObject<Block> ALPHA_LEAVES
    = registerBlock("alpha_leaves", () -> new LeavesBlock(LEAF_PROPERTIES));
    public static final RegistryObject<Block> ALPHA_BIRCH_LEAVES
    = registerBlock("alpha_birch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_LEAVES)));
    public static final RegistryObject<Block> ALPHA_SAPLING
    = registerBlock("alpha_sapling", () -> new SaplingBlock(new AlphaOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ALPHA_BIRCH_SAPLING
    = registerBlock("alpha_birch_sapling", () -> new SaplingBlock(new AlphaBirchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CYAN_FLOWER
    = registerBlock("cyan_flower", () -> new FlowerBlock(MobEffects.LEVITATION, 30, BlockBehaviour.Properties.copy(Blocks.DANDELION).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> PAEONIA
    = registerBlock("paeonia", () -> new FlowerBlock(MobEffects.DAMAGE_BOOST, 32, BlockBehaviour.Properties.copy(Blocks.DANDELION).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> ALPHA_ROSE
    = registerBlock("love_flower", () -> new LoveFlower(MobEffects.LUCK, 40, BlockBehaviour.Properties.copy(Blocks.DANDELION).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ALPHA_FLOWER
    = registerBlock("alpha_flower", () -> new FlowerBlock(MobEffects.SATURATION, 8, BlockBehaviour.Properties.copy(Blocks.DANDELION)));

    public static final RegistryObject<Block> ALPHA_FARMLAND 
    = registerBlock("alpha_farmland", () -> new AlphaFarmland(BlockBehaviour.Properties.copy(Blocks.FARMLAND).sound(SoundTypeRegistry.ALPHA_DIRT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}