package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.util.hit.HitResult;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class DestroyCommand extends InputCommand {
    public DestroyCommand() {
        super(20);
        maxRunningTicks = CONFIG.mainGroup.destroyTicks.getValue();
        enabled = CONFIG.mainGroup.destroyKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyAttack;
    }

    @Override
    public void enable() {
        if (client.crosshairTarget != null && client.crosshairTarget.getType() == HitResult.Type.BLOCK) {
            super.enable();
        }
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.destroyKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.destroyTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
