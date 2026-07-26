package net.res.alphadarkworld.server.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.AlphaDarkworld;

import net.res.alphadarkworld.server.registry.ItemRegistry;
import net.res.alphadarkworld.server.registry.BlockRegistry;


public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> DEF_REG  = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlphaDarkworld.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN = DEF_REG.register("main", () -> CreativeModeTab.builder()
            .icon(() -> ItemRegistry.RUBY.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.alpha_darkworld.main"))
            .displayItems((parameters, output) -> {
                output.accept(BlockRegistry.ALPHA_PLANKS.get());
                output.accept(BlockRegistry.LIMESTONE.get());
                output.accept(BlockRegistry.ALPHA_COBBLESTONE.get());
                output.accept(BlockRegistry.ALPHA_MOSSY_COBBLESTONE.get());
                output.accept(BlockRegistry.ALPHA_BRICKS.get());
                output.accept(BlockRegistry.ALPHA_LOG.get());
                output.accept(BlockRegistry.ALPHA_BIRCH_LOG.get());
                output.accept(BlockRegistry.ALPHA_LEAVES.get());
                output.accept(BlockRegistry.ALPHA_BIRCH_LEAVES.get());
                output.accept(BlockRegistry.ULTRAMARINE_WOOL.get());
                output.accept(BlockRegistry.CAPRI_WOOL.get());
                output.accept(BlockRegistry.CHARTREUSE_WOOL.get());
                output.accept(BlockRegistry.ROSE_WOOL.get());
                output.accept(BlockRegistry.SPRING_WOOL.get());
                output.accept(BlockRegistry.VIOLET_WOOL.get());
                output.accept(BlockRegistry.ULTRAMARINE_CARPET.get());
                output.accept(BlockRegistry.CAPRI_CARPET.get());
                output.accept(BlockRegistry.CHARTREUSE_CARPET.get());
                output.accept(BlockRegistry.ROSE_CARPET.get());
                output.accept(BlockRegistry.SPRING_CARPET.get());
                output.accept(BlockRegistry.VIOLET_CARPET.get());
                output.accept(BlockRegistry.ALPHA_SAPLING.get());
                output.accept(BlockRegistry.ALPHA_BIRCH_SAPLING.get());
                output.accept(BlockRegistry.RUBY_ORE.get());
                output.accept(BlockRegistry.MITHRIL_ORE.get());
                output.accept(BlockRegistry.RUBY_BLOCK.get());
                output.accept(BlockRegistry.MITHRIL_BLOCK.get());
                output.accept(BlockRegistry.RAW_MITHRIL_BLOCK.get());
                output.accept(ItemRegistry.DARK_STICK.get());
                output.accept(ItemRegistry.RUBY.get());
                output.accept(ItemRegistry.RAW_MITHRIL.get());
                output.accept(ItemRegistry.MITHRIL_INGOT.get());
                output.accept(ItemRegistry.MITHRIL_AXE.get());
                output.accept(ItemRegistry.MITHRIL_HOE.get());
                output.accept(ItemRegistry.MITHRIL_PICKAXE.get());
                output.accept(ItemRegistry.MITHRIL_SHOVEL.get());
                output.accept(ItemRegistry.MITHRIL_SWORD.get());
                //output.accept(ItemRegistry.MITHRIL_KNIFE.get());
                output.accept(ItemRegistry.MITHRIL_HELMET.get());
                output.accept(ItemRegistry.MITHRIL_CHESTPLATE.get());
                output.accept(ItemRegistry.MITHRIL_LEGGINGS.get());
                output.accept(ItemRegistry.MITHRIL_BOOTS.get());
                output.accept(ItemRegistry.RUBY_AXE.get());
                output.accept(ItemRegistry.RUBY_HOE.get());
                output.accept(ItemRegistry.RUBY_PICKAXE.get());
                output.accept(ItemRegistry.RUBY_SHOVEL.get());
                output.accept(ItemRegistry.RUBY_SWORD.get());
                //output.accept(ItemRegistry.RUBY_KNIFE.get());
                output.accept(ItemRegistry.RUBY_HELMET.get());
                output.accept(ItemRegistry.RUBY_CHESTPLATE.get());
                output.accept(ItemRegistry.RUBY_LEGGINGS.get());
                output.accept(ItemRegistry.RUBY_BOOTS.get());
            })
            .build()
    );
        

}
