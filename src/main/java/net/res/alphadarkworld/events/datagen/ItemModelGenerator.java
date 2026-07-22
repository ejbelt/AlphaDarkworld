package net.res.alphadarkworld.events.datagen;

import net.res.alphadarkworld.server.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.AlphaDarkworld;

public class ItemModelGenerator extends ItemModelProvider{

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AlphaDarkworld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        genSimpleItemModel(ItemRegistry.RUBY);
        genSimpleItemModel(ItemRegistry.MITHRIL_INGOT);
        genSimpleItemModel(ItemRegistry.RAW_MITHRIL);

        genHandheldItemModel(ItemRegistry.MITHRIL_AXE);
        genHandheldItemModel(ItemRegistry.MITHRIL_HOE);
        genHandheldItemModel(ItemRegistry.MITHRIL_PICKAXE);
        genHandheldItemModel(ItemRegistry.MITHRIL_SHOVEL);
        genHandheldItemModel(ItemRegistry.MITHRIL_SWORD);
        genHandheldItemModel(ItemRegistry.RUBY_AXE);
        genHandheldItemModel(ItemRegistry.RUBY_HOE);
        genHandheldItemModel(ItemRegistry.RUBY_PICKAXE);
        genHandheldItemModel(ItemRegistry.RUBY_SHOVEL);
        genHandheldItemModel(ItemRegistry.RUBY_SWORD);
    }
    
    private ItemModelBuilder genHandheldItemModel(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/handheld")).texture("layer0",
            new ResourceLocation(AlphaDarkworld.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder genSimpleItemModel(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(AlphaDarkworld.MOD_ID, "item/" + item.getId().getPath()));
    }

}
