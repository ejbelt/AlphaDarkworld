package net.res.alphadarkworld.events.datagen;

import net.res.alphadarkworld.server.registry.BlockRegistry;
import net.res.alphadarkworld.server.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.AlphaDarkworld;

import java.util.LinkedHashMap;
public class ItemModelGenerator extends ItemModelProvider{

private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

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

        
        genHandheldItemModel(ItemRegistry.DARK_STICK);

        trimmedArmorItem(ItemRegistry.MITHRIL_HELMET);
        trimmedArmorItem(ItemRegistry.MITHRIL_CHESTPLATE);
        trimmedArmorItem(ItemRegistry.MITHRIL_LEGGINGS);
        trimmedArmorItem(ItemRegistry.MITHRIL_BOOTS);

        trimmedArmorItem(ItemRegistry.RUBY_HELMET);
        trimmedArmorItem(ItemRegistry.RUBY_CHESTPLATE);
        trimmedArmorItem(ItemRegistry.RUBY_LEGGINGS);
        trimmedArmorItem(ItemRegistry.RUBY_BOOTS);
        
        saplingItem(BlockRegistry.ALPHA_SAPLING);
        saplingItem(BlockRegistry.ALPHA_BIRCH_SAPLING);

    }
    
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AlphaDarkworld.MOD_ID,"block/" + item.getId().getPath()));
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

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = AlphaDarkworld.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

}
