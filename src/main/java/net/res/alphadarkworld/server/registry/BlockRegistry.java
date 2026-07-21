package net.res.alphadarkworld.server.registry;


import net.res.alphadarkworld.AlphaDarkworld;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

import static net.minecraft.world.level.block.AbstractFurnaceBlock.LIT;

public class BlockRegistry {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlphaDarkworld.MOD_ID);

    public static final BlockBehaviour.Properties RUBY_PROPERTIES = BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().sound(SoundType.METAL);

    //Ruby
    public static final RegistryObject<Block> RUBY_ORE 
    = registerBlock("ruby_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

}