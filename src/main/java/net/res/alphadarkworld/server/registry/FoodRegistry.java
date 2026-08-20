package net.res.alphadarkworld.server.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodRegistry {
    
    public static final FoodProperties HEAL_MINT = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.HEAL, 1, 2), 1.0F).effect(new MobEffectInstance(MobEffects.HEAL, 1, 2), 1.0F).alwaysEat().build();


}
