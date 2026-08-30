package net.res.alphadarkworld.server.item;

import destiny.penumbra_phantasm.PenumbraPhantasm;
import destiny.penumbra_phantasm.server.item.DarkWorldFoodItem;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HealMint extends DarkWorldFoodItem {

    private int determinationGain;

    public HealMint(Properties pProperties, int determinationGain, SoundEvent consumeSound) {
        super(pProperties, determinationGain, consumeSound);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> components, TooltipFlag pIsAdvanced) {
        FoodProperties foodProperties = pStack.getFoodProperties(null);

        int nutrition = 0;
        float saturationModifier = 0f;
        if (foodProperties != null) {
            nutrition = foodProperties.getNutrition();
            saturationModifier = foodProperties.getSaturationModifier();
        }

        if (nutrition != 0) {
            components.add(Component.literal("+" + nutrition + " ")
                    .append(Component.translatable("tooltip.penumbra_phantasm.nutrition"))
                    .withStyle(Style.EMPTY.withFont(new ResourceLocation(PenumbraPhantasm.MODID, "8_bit_operator"))));
        }

        if (saturationModifier != 0) {
            double saturationPoints = (nutrition * saturationModifier * 2);

            components.add(Component.literal("+" + String.format("%.1f", saturationPoints) + " ")
                    .append(Component.translatable("tooltip.penumbra_phantasm.saturation"))
                    .withStyle(Style.EMPTY.withFont(new ResourceLocation(PenumbraPhantasm.MODID, "8_bit_operator"))));
        }

        if (determinationGain != 0) {
            components.add(Component.literal("+" + determinationGain + " ")
                    .append(Component.translatable("tooltip.penumbra_phantasm.soul_hearth.soul_type.1"))
                    .withStyle(Style.EMPTY.withFont(new ResourceLocation(PenumbraPhantasm.MODID, "8_bit_operator"))));
        }

        components.add(Component.translatable("tooltip.alpha_darkworld.heal_mint.effect")
                .withStyle(Style.EMPTY.withFont(new ResourceLocation(PenumbraPhantasm.MODID, "8_bit_operator"))));
    }

}
