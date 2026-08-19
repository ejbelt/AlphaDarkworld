package net.res.alphadarkworld.mixin;

import net.res.alphadarkworld.server.registry.DamageTypeRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import destiny.penumbra_phantasm.server.registry.SoundRegistry;

@Mixin(Player.class)
public abstract class DestinyPlayerMixin {

    @Inject(method = "getHurtSound", at = @At("TAIL"), cancellable = true)
    private void onGetHurtSound(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        if (source.is(DamageTypeRegistry.OTHER_SOUL_DAMAGE)) {
            ((Entity)(Object)this).playSound(SoundRegistry.SOUL_HURT.get(), 1F, 1F);
            cir.cancel();
        }

        if (source.is(DamageTypeRegistry.MOB_SOUL_DAMAGE)) {
            ((Entity)(Object)this).playSound(SoundRegistry.SOUL_HURT.get(), 1F, 1F);
            cir.cancel();
        }
    }

}
