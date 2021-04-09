package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class RightStrafeCommand extends InputCommand  {
    public RightStrafeCommand() {
        super(12);
        maxRunningTicks = CONFIG.mainGroup.dTicks.getValue();
        enabled = CONFIG.mainGroup.dKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyRight;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.dKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.dTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
