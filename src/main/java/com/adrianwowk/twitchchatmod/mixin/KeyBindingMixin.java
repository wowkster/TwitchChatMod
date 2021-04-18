package com.adrianwowk.twitchchatmod.mixin;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;
import static com.adrianwowk.twitchchatmod.client.input.Commands.*;

@Mixin(KeyBinding.class)
public class KeyBindingMixin {
    @Inject(method = "setKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;Z)V", at = @At("HEAD"), cancellable = true)
    private static void inject(InputUtil.Key key, boolean pressed, CallbackInfo ci){
        if (allowManualInput)
            return;

        KeyBinding keyBinding = KeyBinding.keyToBindings.get(key);

        if (keyBinding == null)
            return;

        MinecraftClient client = MinecraftClient.getInstance();
        HitResult crosshair = client.crosshairTarget;
        if (keyBinding.equals(client.options.keyAttack) && twitchBot.isRunning()) {

            if (ATTACK.isEnabled() && crosshair.getType() == HitResult.Type.ENTITY){
                ci.cancel();
                return;
            }
            if (DESTROY.isEnabled())
                ci.cancel();

            return;
        }

        if (keyBinding.equals(client.options.keyUse) && twitchBot.isRunning()){

            ItemStack item = client.player.getMainHandStack();
            UseAction action = item.getItem().getUseAction(item);

            if (USE.isEnabled() && (action == UseAction.DRINK || action == UseAction.EAT))
                ci.cancel();

            else if (PLACE.isEnabled() && (item.getItem() instanceof BlockItem))
                ci.cancel();
            return;

        }

        if (twitchBot.isRunning())
            for (InputCommand cmd : CMDS)
                if (cmd.getKey().equals(keyBinding) && cmd.isEnabled())
                    ci.cancel();
    }

    @Inject(method = "onKeyPressed(Lnet/minecraft/client/util/InputUtil$Key;)V", at = @At("HEAD"), cancellable = true)
    private static void onPress(InputUtil.Key key, CallbackInfo ci){
        if (allowManualInput)
            return;

        KeyBinding keyBinding = KeyBinding.keyToBindings.get(key);

        if (keyBinding == null)
            return;

        MinecraftClient client = MinecraftClient.getInstance();
        HitResult crosshair = MinecraftClient.getInstance().crosshairTarget;
        assert MinecraftClient.getInstance().crosshairTarget != null;

        if (keyBinding.equals(client.options.keyAttack) && twitchBot.isRunning()) {

            if (ATTACK.isEnabled() && crosshair.getType() == HitResult.Type.ENTITY){
                ci.cancel();
                return;
            }
            if (DESTROY.isEnabled() && client.player.isCreative() )
                ci.cancel();

            return;
        }

        if (keyBinding.equals(client.options.keyUse) && twitchBot.isRunning()){

            ItemStack item = client.player.getMainHandStack();
            UseAction action = item.getItem().getUseAction(item);

            if (USE.isEnabled() && (action == UseAction.DRINK || action == UseAction.EAT))
                ci.cancel();

            else if (PLACE.isEnabled() && (item.getItem() instanceof BlockItem))
                ci.cancel();
            return;

        }
    }

}
