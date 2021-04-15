package com.adrianwowk.twitchchatmod.client.gui.screen;

import net.minecraft.client.options.Option;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.gui.ConfigOptions.*;

public class ModConfigScreen extends ConfigScreen {

    public ModConfigScreen() {
        super(Text.of("Mod Config"), new Option[]{W_KEY_ON, W_KEY_TICKS, S_KEY_ON, S_KEY_TICKS, A_KEY_ON, A_KEY_TICKS, D_KEY_ON, D_KEY_TICKS, JUMP_KEY_ON, JUMP_KEY_TICKS, PLACE_KEY_ON, PLACE_KEY_TICKS, USE_KEY_ON, USE_KEY_TICKS, ATTACK_KEY_ON, ATTACK_KEY_TICKS, DESTROY_KEY_ON, DESTROY_KEY_TICKS});
    }

}
