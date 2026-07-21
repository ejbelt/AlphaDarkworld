package net.res.alphadarkworld.server.registry;

import net.res.alphadarkworld.AlphaDarkworld;
import net.res.alphadarkworld.server.registry.ItemRegistry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArmorMatieralRegistry implements ArmorMaterial {

    //MITHRIL("mithril", 18, new int[]{2, 6, 3, 2}, 28, 
    //    SoundEvents.ARMOR_EQUIP_GOLD, 2f, 2f, () -> Ingredient.of(ItemRegistry.MITHRIL.get()));


    RUBY("ruby", 20, new int[]{3, 8, 6, 3}, 22, 
        SoundEvents.ARMOR_EQUIP_GOLD, 4f, 8f, () -> Ingredient.of(ItemRegistry.RUBY.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    
    //Base durability of each armor from helm to boots.
    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ArmorMatieralRegistry(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
    float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {

        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;

    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return AlphaDarkworld.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
