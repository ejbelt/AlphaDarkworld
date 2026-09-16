package net.res.alphadarkworld.server.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

public class FoodRegistry {
    
    public static final FoodProperties HEAL_MINT = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HEAL, 1, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties HEAL_MINT_BASKET = (new FoodProperties.Builder()).nutrition(10).saturationMod(2.4F).effect(new MobEffectInstance(MobEffects.HEAL, 2, 1), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 5000, 1), 1.0F).alwaysEat().build();
    public static final FoodProperties VENISON = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_VENISON = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().build();
    public static final FoodProperties DENSE_MOSS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().build();
}
