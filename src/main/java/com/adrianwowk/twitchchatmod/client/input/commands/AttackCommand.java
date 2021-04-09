package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;

public class AttackCommand extends InputCommand {
    public AttackCommand() {
        super(2);
    }

    public KeyBinding getKey() {
        return client.options.keyAttack;
    }
}
