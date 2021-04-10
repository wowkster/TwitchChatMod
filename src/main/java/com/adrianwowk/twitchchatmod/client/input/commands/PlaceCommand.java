package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class PlaceCommand extends InputCommand {
    public PlaceCommand() {
        super(1);
        maxRunningTicks = CONFIG.mainGroup.placeTicks.getValue();
        enabled = CONFIG.mainGroup.placeKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyUse;
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.placeKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.placeTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
