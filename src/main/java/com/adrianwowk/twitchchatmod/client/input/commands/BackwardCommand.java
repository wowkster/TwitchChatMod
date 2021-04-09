package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class BackwardCommand extends InputCommand {
    public BackwardCommand() {
        super(12);
        maxRunningTicks = CONFIG.mainGroup.sTicks.getValue();
        enabled = CONFIG.mainGroup.sKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyBack;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.sKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.sTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}