package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

public class UseCommand extends InputCommand {
    public UseCommand() {
        super(35);
    }

    public KeyBinding getKey() {
        return client.options.keyUse;
    }
}
