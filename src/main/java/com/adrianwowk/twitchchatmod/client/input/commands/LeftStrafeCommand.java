package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;
public class LeftStrafeCommand extends InputCommand {
    public LeftStrafeCommand() {
        super(12);
        maxRunningTicks = CONFIG.mainGroup.aTicks.getValue();
        enabled = CONFIG.mainGroup.aKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyLeft;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.aKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.aTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
