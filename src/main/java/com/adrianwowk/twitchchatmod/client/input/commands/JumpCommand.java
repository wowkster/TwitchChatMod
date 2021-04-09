package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class JumpCommand extends InputCommand {
    public JumpCommand() {
        super(10);
        maxRunningTicks = CONFIG.mainGroup.jumpTicks.getValue();
        enabled = CONFIG.mainGroup.jumpKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyJump;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.jumpKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.jumpTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
