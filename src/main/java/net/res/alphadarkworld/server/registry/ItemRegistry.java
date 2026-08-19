package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.item.MithrilBucket;
import net.res.alphadarkworld.server.registry.TierRegistry;
import net.minecraft.core.Direction;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import destiny.penumbra_phantasm.server.registry.FluidRegistry;
import destiny.penumbra_phantasm.server.item.KnifeItem;
import destiny.penumbra_phantasm.server.item.ScarletBucketItem;

public class ItemRegistry {

        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AlphaDarkworld.MOD_ID);

        public static Item.Properties basicItem() {
                return new Item.Properties().stacksTo(1);
        }


        public static final RegistryObject<Item> DARK_STICK = ITEMS.register("dark_stick",
                () -> new Item(new Item.Properties()));

        //Mithril
        public static final RegistryObject<Item> RAW_MITHRIL = ITEMS.register("raw_mithril",
                () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
                () -> new Item(new Item.Properties()));


        public static final RegistryObject<Item> MITHRIL_SWORD = ITEMS.register("mithril_sword",
                () -> new SwordItem(TierRegistry.MITHRIL, 3, -2, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_AXE = ITEMS.register("mithril_axe",
                () -> new AxeItem(TierRegistry.MITHRIL, 5, -3f, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_PICKAXE = ITEMS.register("mithril_pickaxe",
                () -> new PickaxeItem(TierRegistry.MITHRIL, 2, -2.5f, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_SHOVEL = ITEMS.register("mithril_shovel",
                () -> new ShovelItem(TierRegistry.MITHRIL, 1, -2f, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_HOE = ITEMS.register("mithril_hoe",
                () -> new HoeItem(TierRegistry.MITHRIL, 0, 0f, new Item.Properties()));

        public static final RegistryObject<Item> MITHRIL_HELMET = ITEMS.register("mithril_helmet",
                () -> new ArmorItem(ArmorMatieralRegistry.MITHRIL, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_CHESTPLATE = ITEMS.register("mithril_chestplate",
                () -> new ArmorItem(ArmorMatieralRegistry.MITHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_LEGGINGS = ITEMS.register("mithril_leggings",
                () -> new ArmorItem(ArmorMatieralRegistry.MITHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> MITHRIL_BOOTS = ITEMS.register("mithril_boots",
                () -> new ArmorItem(ArmorMatieralRegistry.MITHRIL, ArmorItem.Type.BOOTS, new Item.Properties()));


        public static final RegistryObject<Item> MITHRIL_BUCKET = ITEMS.register("mithril_bucket",
                () -> new MithrilBucket(Fluids.EMPTY, new Item.Properties().stacksTo(16)) );
        public static final RegistryObject<Item> LUMINESCENT_WATER_MITRHIL_BUCKET = ITEMS.register("mithril_luminescent_bucket",
                () -> new MithrilBucket(FluidRegistry.SOURCE_LUMINESCENT_WATER.get(), new Item.Properties().stacksTo(1).craftRemainder(ItemRegistry.MITHRIL_BUCKET.get())));
        public static final RegistryObject<Item> PURE_DARKNESS_MITHRIL_BUCKET = ITEMS.register("mithril_darkness_bucket",
                () -> new MithrilBucket(FluidRegistry.SOURCE_PURE_DARKNESS.get(), new Item.Properties().stacksTo(1).craftRemainder(ItemRegistry.MITHRIL_BUCKET.get())));
        public static final RegistryObject<Item> MITHRIL_WATER_BUCKET = ITEMS.register("mithril_bucket_water",
                () -> new MithrilBucket(Fluids.WATER, new Item.Properties().stacksTo(1).craftRemainder(ItemRegistry.MITHRIL_BUCKET.get())));
        public static final RegistryObject<Item> MITHRIL_LAVA_BUCKET = ITEMS.register("mithril_bucket_lava",
                () -> new MithrilBucket(Fluids.LAVA, new Item.Properties().stacksTo(1).craftRemainder(ItemRegistry.MITHRIL_BUCKET.get())));

        //Ruby
        public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
                () -> new Item(new Item.Properties()));


        public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
                () -> new SwordItem(TierRegistry.RUBY, 4, -2, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
                () -> new AxeItem(TierRegistry.RUBY, 7, -2.5f, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
                () -> new PickaxeItem(TierRegistry.RUBY, 2, -2, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
                () -> new ShovelItem(TierRegistry.RUBY, 1, -1.5f, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
                () -> new HoeItem(TierRegistry.RUBY, 0, 0.5f, new Item.Properties()));

        public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
                () -> new ArmorItem(ArmorMatieralRegistry.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
                () -> new ArmorItem(ArmorMatieralRegistry.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
                () -> new ArmorItem(ArmorMatieralRegistry.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
                () -> new ArmorItem(ArmorMatieralRegistry.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));


        //Knives

        public static final RegistryObject<Item> MITHRIL_KNIFE = ITEMS.register("mithril_knife",
                () -> new KnifeItem(TierRegistry.MITHRIL, 3, 3f, false, new Item.Properties()));
        public static final RegistryObject<Item> RUBY_KNIFE = ITEMS.register("ruby_knife",
                () -> new KnifeItem(TierRegistry.RUBY, 4, 4f, false, new Item.Properties()));


        //Misc
        public static final RegistryObject<RecordItem> DROOPY_DISC_ITEM = ITEMS.register("disc_droopy",
                () -> new RecordItem(12, SoundRegistry.DROOPY_DISC, (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 2336));
}