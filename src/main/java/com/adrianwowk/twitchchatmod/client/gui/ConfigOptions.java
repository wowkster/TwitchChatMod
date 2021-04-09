package com.adrianwowk.twitchchatmod.client.gui;

import net.minecraft.client.options.BooleanOption;
import net.minecraft.client.options.DoubleOption;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.input.Commands.*;

public class ConfigOptions {

    public static final BooleanOption W_KEY_ON = new BooleanOption("options.wKey",
            (gameOptions) -> FORWARD.isEnabled(), (gameOptions, wKey) -> FORWARD.setEnabled(wKey));

    public static final BooleanOption S_KEY_ON = new BooleanOption("options.sKey",
            (gameOptions) -> BACKWARD.isEnabled(), (gameOptions, wKey) -> BACKWARD.setEnabled(wKey));

    public static final BooleanOption A_KEY_ON = new BooleanOption("options.aKey",
            (gameOptions) -> LEFT.isEnabled(), (gameOptions, wKey) -> LEFT.setEnabled(wKey));

    public static final BooleanOption D_KEY_ON = new BooleanOption("options.dKey",
            (gameOptions) -> RIGHT.isEnabled(), (gameOptions, wKey) -> RIGHT.setEnabled(wKey));

    public static final BooleanOption JUMP_KEY_ON = new BooleanOption("options.jumpKey",
            (gameOptions) -> JUMP.isEnabled(), (gameOptions, wKey) -> JUMP.setEnabled(wKey));

    public static final DoubleOption W_KEY_TICKS = new DoubleOption("options.wKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) FORWARD.getMaxRunningTicks(), (gameOptions, ticks) -> FORWARD.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("" + value.get(gameOptions)));

    public static final DoubleOption S_KEY_TICKS = new DoubleOption("options.sKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) BACKWARD.getMaxRunningTicks(), (gameOptions, ticks) -> BACKWARD.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("" + value.get(gameOptions)));

    public static final DoubleOption A_KEY_TICKS = new DoubleOption("options.aKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) LEFT.getMaxRunningTicks(), (gameOptions, ticks) -> LEFT.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("" + value.get(gameOptions)));

    public static final DoubleOption D_KEY_TICKS = new DoubleOption("options.dKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) RIGHT.getMaxRunningTicks(), (gameOptions, ticks) -> RIGHT.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("" + value.get(gameOptions)));

    public static final DoubleOption JUMP_KEY_TICKS = new DoubleOption("options.jumpKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) JUMP.getMaxRunningTicks(), (gameOptions, ticks) -> JUMP.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("" + value.get(gameOptions)));


}
