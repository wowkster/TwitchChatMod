package com.adrianwowk.twitchchatmod.client.gui;

import net.minecraft.client.options.BooleanOption;
import net.minecraft.client.options.DoubleOption;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.injection.At;

import static com.adrianwowk.twitchchatmod.client.input.Commands.*;

public class ConfigOptions {

    public static final BooleanOption W_KEY_ON = new BooleanOption("options.wKey",
            (gameOptions) -> FORWARD.isEnabled(), (gameOptions, key) -> FORWARD.setEnabled(key));

    public static final BooleanOption S_KEY_ON = new BooleanOption("options.sKey",
            (gameOptions) -> BACKWARD.isEnabled(), (gameOptions, key) -> BACKWARD.setEnabled(key));

    public static final BooleanOption A_KEY_ON = new BooleanOption("options.aKey",
            (gameOptions) -> LEFT.isEnabled(), (gameOptions, key) -> LEFT.setEnabled(key));

    public static final BooleanOption D_KEY_ON = new BooleanOption("options.dKey",
            (gameOptions) -> RIGHT.isEnabled(), (gameOptions, key) -> RIGHT.setEnabled(key));

    public static final BooleanOption JUMP_KEY_ON = new BooleanOption("options.jumpKey",
            (gameOptions) -> JUMP.isEnabled(), (gameOptions, key) -> JUMP.setEnabled(key));

    public static final BooleanOption PLACE_KEY_ON = new BooleanOption("options.placeKey",
            (gameOptions) -> PLACE.isEnabled(), (gameOptions, key) -> PLACE.setEnabled(key));

    public static final BooleanOption USE_KEY_ON = new BooleanOption("options.useKey",
            (gameOptions) -> USE.isEnabled(), (gameOptions, key) -> USE.setEnabled(key));

    public static final BooleanOption ATTACK_KEY_ON = new BooleanOption("options.attackKey",
            (gameOptions) -> ATTACK.isEnabled(), (gameOptions, key) -> ATTACK.setEnabled(key));

    public static final BooleanOption DESTROY_KEY_ON = new BooleanOption("options.destroyKey",
            (gameOptions) -> DESTROY.isEnabled(), (gameOptions, key) -> DESTROY.setEnabled(key));

    
    public static final DoubleOption W_KEY_TICKS = new DoubleOption("options.wKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) FORWARD.getMaxRunningTicks(), (gameOptions, ticks) -> FORWARD.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption S_KEY_TICKS = new DoubleOption("options.sKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) BACKWARD.getMaxRunningTicks(), (gameOptions, ticks) -> BACKWARD.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption A_KEY_TICKS = new DoubleOption("options.aKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) LEFT.getMaxRunningTicks(), (gameOptions, ticks) -> LEFT.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption D_KEY_TICKS = new DoubleOption("options.dKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) RIGHT.getMaxRunningTicks(), (gameOptions, ticks) -> RIGHT.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption JUMP_KEY_TICKS = new DoubleOption("options.jumpKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) JUMP.getMaxRunningTicks(), (gameOptions, ticks) -> JUMP.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption PLACE_KEY_TICKS = new DoubleOption("options.placeKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) PLACE.getMaxRunningTicks(), (gameOptions, ticks) -> PLACE.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption USE_KEY_TICKS = new DoubleOption("options.useKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) USE.getMaxRunningTicks(), (gameOptions, ticks) -> USE.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption ATTACK_KEY_TICKS = new DoubleOption("options.attackKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) ATTACK.getMaxRunningTicks(), (gameOptions, ticks) -> ATTACK.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));

    public static final DoubleOption DESTROY_KEY_TICKS = new DoubleOption("options.destroyKeyTicks", 1, 100, 1.0f,
            (gameOptions) -> (double) DESTROY.getMaxRunningTicks(), (gameOptions, ticks) -> DESTROY.setMaxRunningTicks(ticks.intValue()), (gameOptions, value) -> Text.of("Ticks: " + value.get(gameOptions)));


}
