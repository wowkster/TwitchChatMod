package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

public class DestroyCommand extends InputCommand {
    public DestroyCommand() {
        super(20);
    }

    public KeyBinding getKey() {
        return client.options.keyAttack;
    }
}
