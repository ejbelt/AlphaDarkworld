package net.res.alphadarkworld.events.datagen;

import java.util.Set;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.res.alphadarkworld.server.registry.*;

import java.util.List;
import java.util.Set;

public class BlockLootTableGenerator extends BlockLootSubProvider {

    protected static final LootItemCondition.Builder HAS_ALPHA_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_NO_ALPHA_SILK_TOUCH = HAS_ALPHA_SILK_TOUCH.invert();
    protected static final LootItemCondition.Builder HAS_ALPHA_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_ALPHA_SILK_TOUCH = HAS_ALPHA_SHEARS.or(HAS_ALPHA_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_ALPHA_SILK_TOUCH = HAS_SHEARS_OR_ALPHA_SILK_TOUCH.invert();

    protected BlockLootTableGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(BlockRegistry.RUBY_BLOCK.get());
        this.dropSelf(BlockRegistry.MITHRIL_BLOCK.get());
        this.dropSelf(BlockRegistry.RAW_MITHRIL_BLOCK.get());
        this.dropSelf(BlockRegistry.ULTRAMARINE_WOOL.get());
        this.dropSelf(BlockRegistry.CAPRI_WOOL.get());
        this.dropSelf(BlockRegistry.CHARTREUSE_WOOL.get());
        this.dropSelf(BlockRegistry.ROSE_WOOL.get());
        this.dropSelf(BlockRegistry.SPRING_WOOL.get());
        this.dropSelf(BlockRegistry.VIOLET_WOOL.get());
        this.dropSelf(BlockRegistry.ULTRAMARINE_CARPET.get());
        this.dropSelf(BlockRegistry.CAPRI_CARPET.get());
        this.dropSelf(BlockRegistry.CHARTREUSE_CARPET.get());
        this.dropSelf(BlockRegistry.ROSE_CARPET.get());
        this.dropSelf(BlockRegistry.SPRING_CARPET.get());
        this.dropSelf(BlockRegistry.VIOLET_CARPET.get());
        this.dropSelf(BlockRegistry.ALPHA_PLANKS.get());
        this.dropSelf(BlockRegistry.ALPHA_LOG.get());
        this.dropSelf(BlockRegistry.ALPHA_BIRCH_LOG.get());
        this.dropSelf(BlockRegistry.ALPHA_SAPLING.get());
        this.dropSelf(BlockRegistry.ALPHA_BIRCH_SAPLING.get());

        this.add(BlockRegistry.ALPHA_LEAVES.get(), block ->
            createDarkWorldOakLeavesDrops(block, BlockRegistry.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockRegistry.ALPHA_BIRCH_LEAVES.get(), block ->
            createDarkWorldLeavesDrop(block, BlockRegistry.ALPHA_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(BlockRegistry.RUBY_ORE.get(), 
            block -> createOreDrop(block, ItemRegistry.RUBY.get()));

        this.add(BlockRegistry.MITHRIL_ORE.get(), 
            block -> createOreDrop(block, ItemRegistry.RAW_MITHRIL.get()));
    }

    protected LootTable.Builder createDarkWorldOakLeavesDrops(Block pOakLeavesBlock, Block pSaplingBlock, float... pChances) {
        return this.createDarkWorldLeavesDrop(pOakLeavesBlock, pSaplingBlock, pChances)
            .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
            .when(HAS_NO_SHEARS_OR_ALPHA_SILK_TOUCH)
            .add(this.applyExplosionCondition(pOakLeavesBlock, LootItem.lootTableItem(Items.APPLE))
            .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    protected LootTable.Builder createDarkWorldLeavesDrop(Block pLeavesBlock, Block pSaplingBlock, float... pChances) {
        return createSilkTouchOrShearsDispatchTable(pLeavesBlock, 
            this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pSaplingBlock))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pChances)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)));
    }

    @Override 
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    
}
