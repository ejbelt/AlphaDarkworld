package net.res.alphadarkworld.server.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
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
                output.accept(BlockRegistry.RUBY_ORE.get());
                output.accept(ItemRegistry.RUBY.get());
                output.accept(ItemRegistry.RUBY_AXE.get());
                output.accept(ItemRegistry.RUBY_HOE.get());
                output.accept(ItemRegistry.RUBY_PICKAXE.get());
                output.accept(ItemRegistry.RUBY_SHOVEL.get());
                output.accept(ItemRegistry.RUBY_SWORD.get());
            })
            .build()
    );
        

}
