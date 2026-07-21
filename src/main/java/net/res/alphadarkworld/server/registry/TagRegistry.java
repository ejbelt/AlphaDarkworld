package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;

import net.res.alphadarkworld.server.registry.*;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagRegistry {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MITHRIL_TOOL = tag("needs_mithril_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(AlphaDarkworld.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(AlphaDarkworld.MOD_ID, name));
        }
    }
}
