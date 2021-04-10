package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class AttackCommand extends InputCommand {
    public AttackCommand() {
        super(2);
        maxRunningTicks = CONFIG.mainGroup.attackTicks.getValue();
        enabled = CONFIG.mainGroup.attackKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyAttack;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.attackKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.attackTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
