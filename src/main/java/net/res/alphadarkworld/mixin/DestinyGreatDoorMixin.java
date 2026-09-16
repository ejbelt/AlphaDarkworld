package net.res.alphadarkworld.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import destiny.penumbra_phantasm.server.fountain.GreatDoor;

@Pseudo 
@Mixin(GreatDoor.class)
public abstract class DestinyGreatDoorMixin {

    @Shadow 
    private boolean isDestinationDarkWorld;

    @Inject(method = "tickVolumeTeleportation", at = @At("HEAD"), cancellable = true, remap = false)
    private void tryInsertAlphaGreatDoor(ServerLevel greatDoorLevel, ServerLevel destination){
        System.out.println("Testing");
    }
}
