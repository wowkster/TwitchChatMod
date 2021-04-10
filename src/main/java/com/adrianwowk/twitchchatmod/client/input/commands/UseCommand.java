package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class UseCommand extends InputCommand {
    public UseCommand() {
        super(35);
        maxRunningTicks = CONFIG.mainGroup.useTicks.getValue();
        enabled = CONFIG.mainGroup.useKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyUse;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.useKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.useTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
