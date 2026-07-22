package net.res.alphadarkworld.server.registry;


import net.res.alphadarkworld.AlphaDarkworld;
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

    public static final BlockBehaviour.Properties MITHRIL_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.METAL);
    public static final BlockBehaviour.Properties RUBY_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().sound(SoundType.METAL);
    public static final BlockBehaviour.Properties RAW_BLOCK_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops();
    public static final BlockBehaviour.Properties CLOTH_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL);

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

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}