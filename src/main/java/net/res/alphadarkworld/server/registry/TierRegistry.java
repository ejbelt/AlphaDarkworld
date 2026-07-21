package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;

import net.res.alphadarkworld.server.registry.*;

import net.minecraft.tags.BlockTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class TierRegistry {

    public static final Tier MITHRIL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 650, 6.2f, 2f, 18,
                    BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemRegistry.RUBY.get())),
            new ResourceLocation(AlphaDarkworld.MOD_ID, "mithril"), List.of(Tiers.IRON), List.of());

    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1450, 9.8f, 4f, 20,
                    TagRegistry.Blocks.NEEDS_MITHRIL_TOOL, () -> Ingredient.of(ItemRegistry.RUBY.get())),
            new ResourceLocation(AlphaDarkworld.MOD_ID, "ruby"), List.of(Tiers.DIAMOND), List.of());
}
