package com.adrianwowk.twitchchatmod.client.config;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class ChatConfig {
    public boolean showChat;
    public double chatTextOpacity;
    public double chatBackgroundOpacity;
    public double chatScale;
    public double chatLineSpacing;
    public double chatWidth;
    public double chatHeight;
    public double chatXOffset;
    public double chatYOffset;

    public ChatConfig(){
        showChat = CONFIG.mainGroup.showChat.getValue();
        chatTextOpacity = CONFIG.mainGroup.chatTextOpacity.getValue();
        chatBackgroundOpacity = CONFIG.mainGroup.chatBackgroundOpacity.getValue();
        chatScale = CONFIG.mainGroup.chatScale.getValue();
        chatLineSpacing = CONFIG.mainGroup.chatLineSpacing.getValue();
        chatWidth = CONFIG.mainGroup.chatWidth.getValue();
        chatHeight = CONFIG.mainGroup.chatHeight.getValue();
        chatXOffset = CONFIG.mainGroup.chatXOffset.getValue();
        chatYOffset = CONFIG.mainGroup.chatYOffset.getValue();
    }

    public void save(){
        CONFIG.mainGroup.showChat.setValue(showChat);
        CONFIG.mainGroup.chatTextOpacity.setValue(chatTextOpacity);
        CONFIG.mainGroup.chatBackgroundOpacity.setValue(chatBackgroundOpacity);
        CONFIG.mainGroup.chatScale.setValue(chatScale);
        CONFIG.mainGroup.chatLineSpacing.setValue(chatLineSpacing);
        CONFIG.mainGroup.chatWidth.setValue(chatWidth);
        CONFIG.mainGroup.chatHeight.setValue(chatHeight);
        CONFIG.mainGroup.chatXOffset.setValue(chatXOffset);
        CONFIG.mainGroup.chatYOffset.setValue(chatYOffset);

        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Saved Chat Settings"));

        CONFIG.saveConfigToFile();
        CONFIG.readConfigFromFile();
    }
}
