package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class ForwardCommand extends InputCommand {
    public ForwardCommand() {
        super(12);
        maxRunningTicks = CONFIG.mainGroup.wTicks.getValue();
        enabled = CONFIG.mainGroup.wKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyForward;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.wKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.wTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
