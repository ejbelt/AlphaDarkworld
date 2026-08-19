package net.res.alphadarkworld.server.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class HealMint {
    public static final FoodProperties HEAL_MINT = (new FoodProperties.Builder()).nutrition(0).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.HEAL, 1, 4), 1.0F).alwaysEat().build();
}
