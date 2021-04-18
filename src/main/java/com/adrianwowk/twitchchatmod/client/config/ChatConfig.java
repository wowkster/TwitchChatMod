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
        showChat = ClientConfig.ConfigGroup.showChat.getValue();
        chatTextOpacity = ClientConfig.ConfigGroup.chatTextOpacity.getValue();
        chatBackgroundOpacity = ClientConfig.ConfigGroup.chatBackgroundOpacity.getValue();
        chatScale = ClientConfig.ConfigGroup.chatScale.getValue();
        chatLineSpacing = ClientConfig.ConfigGroup.chatLineSpacing.getValue();
        chatWidth = ClientConfig.ConfigGroup.chatWidth.getValue();
        chatHeight = ClientConfig.ConfigGroup.chatHeight.getValue();
        chatXOffset = ClientConfig.ConfigGroup.chatXOffset.getValue();
        chatYOffset = ClientConfig.ConfigGroup.chatYOffset.getValue();
    }

    public void save(){
        ClientConfig.ConfigGroup.showChat.setValue(showChat);
        ClientConfig.ConfigGroup.chatTextOpacity.setValue(chatTextOpacity);
        ClientConfig.ConfigGroup.chatBackgroundOpacity.setValue(chatBackgroundOpacity);
        ClientConfig.ConfigGroup.chatScale.setValue(chatScale);
        ClientConfig.ConfigGroup.chatLineSpacing.setValue(chatLineSpacing);
        ClientConfig.ConfigGroup.chatWidth.setValue(chatWidth);
        ClientConfig.ConfigGroup.chatHeight.setValue(chatHeight);
        ClientConfig.ConfigGroup.chatXOffset.setValue(chatXOffset);
        ClientConfig.ConfigGroup.chatYOffset.setValue(chatYOffset);

        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Saved Chat Settings"));

        CONFIG.saveConfigToFile();
        CONFIG.readConfigFromFile();
    }
}
