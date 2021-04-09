package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

public class PlaceCommand extends InputCommand {
    public PlaceCommand() {
        super(1);
    }

    @Override
    public KeyBinding getKey() {
        return client.options.keyUse;
    }
}
