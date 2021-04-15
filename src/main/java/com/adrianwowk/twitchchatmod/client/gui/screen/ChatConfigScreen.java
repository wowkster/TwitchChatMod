package com.adrianwowk.twitchchatmod.client.gui.screen;

import net.minecraft.client.options.Option;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.gui.ConfigOptions.*;
import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class ChatConfigScreen extends ConfigScreen {

    public ChatConfigScreen() {
        super(Text.of("Twitch Chat Config"), new Option[]{SHOW_CHAT, CHAT_TEXT_OPACITY, CHAT_BACKGROUND_OPACITY, CHAT_SCALE, CHAT_LINE_SPACING, CHAT_WIDTH, CHAT_HEIGHT, CHAT_X_OFFSET, CHAT_Y_OFFSET});
    }

    @Override
    public void onClose() {
//        System.out.println("Closed Chat Config");
//        CHAT_CONFIG.save();
        super.onClose();
    }

    @Override
    public void removed() {
        System.out.println("Removed Chat Config");
        CHAT_CONFIG.save();
        super.removed();
    }}
