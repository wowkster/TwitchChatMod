package com.adrianwowk.twitchchatmod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.HitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow
    protected int attackCooldown;

    @Shadow @Nullable public HitResult crosshairTarget;

    @Inject(method = "doAttack()V", at = @At("HEAD"), cancellable = true)
    public void inject(CallbackInfo ci){
        System.out.println("Attack cooldown: " + this.attackCooldown);
        System.out.println("Crosshair target: " + this.crosshairTarget);
        System.out.println("Crosshair target type: " + this.crosshairTarget.getType());
    }
}
