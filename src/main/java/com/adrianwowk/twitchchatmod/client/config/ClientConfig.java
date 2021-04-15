package com.adrianwowk.twitchchatmod.client.config;
import com.oroarmor.config.Config;
import com.oroarmor.config.ConfigItem;
import com.oroarmor.config.ConfigItemGroup;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ClientConfig extends Config {

    public final ConfigGroup mainGroup;

    public ClientConfig(ConfigGroup mainGroup) {
        super(of(mainGroup), new File(FabricLoader.getInstance().getConfigDir().toFile(), "tcm.json"), "tcm");
        this.mainGroup = mainGroup;
    }

    public static class ConfigGroup extends ConfigItemGroup {
        public final ConfigItem<Boolean> wKey;
        public final ConfigItem<Boolean> sKey;
        public final ConfigItem<Boolean> aKey;
        public final ConfigItem<Boolean> dKey;
        public final ConfigItem<Boolean> jumpKey;
        public final ConfigItem<Boolean> placeKey;
        public final ConfigItem<Boolean> useKey;
        public final ConfigItem<Boolean> attackKey;
        public final ConfigItem<Boolean> destroyKey;

        public final ConfigItem<Integer> wTicks;
        public final ConfigItem<Integer> sTicks;
        public final ConfigItem<Integer> aTicks;
        public final ConfigItem<Integer> dTicks;
        public final ConfigItem<Integer> jumpTicks;
        public final ConfigItem<Integer> placeTicks;
        public final ConfigItem<Integer> useTicks;
        public final ConfigItem<Integer> attackTicks;
        public final ConfigItem<Integer> destroyTicks;

        public final ConfigItem<Boolean> showChat;
        public final ConfigItem<Double> chatTextOpacity;
        public final ConfigItem<Double> chatBackgroundOpacity;
        public final ConfigItem<Double> chatScale;
        public final ConfigItem<Double> chatLineSpacing;
        public final ConfigItem<Double> chatWidth;
        public final ConfigItem<Double> chatHeight;

        public final ConfigItem<Double> chatXOffset;
        public final ConfigItem<Double> chatYOffset;

        public final ConfigItem<String> channelId;

        public ConfigGroup(ConfigItem ... args) {
            super(of(args), "config");

            this.wKey = args[0];
            this.sKey = args[1];
            this.aKey = args[2];
            this.dKey = args[3];
            this.jumpKey = args[4];
            this.placeKey = args[5];
            this.useKey = args[6];
            this.attackKey = args[7];
            this.destroyKey = args[8];

            this.wTicks = args[9];
            this.sTicks = args[10];
            this.aTicks = args[11];
            this.dTicks = args[12];
            this.jumpTicks = args[13];
            this.placeTicks = args[14];
            this.useTicks = args[15];
            this.attackTicks = args[16];
            this.destroyTicks = args[17];

            this.showChat = args[18]; // done -
            this.chatTextOpacity = args[19]; // done -
            this.chatBackgroundOpacity = args[20]; // done -
            this.chatScale = args[21]; // done -
            this.chatLineSpacing = args[22]; // done -
            this.chatWidth = args[23]; // done -
            this.chatHeight = args[24]; // done -

            this.chatXOffset = args[25]; // done
            this.chatYOffset = args[26];  // done

            this.channelId = args[27];

        }
    }

    public static ClientConfig createInstance(){
        ConfigItem<Boolean> wKey = new ConfigItem<>("wKey", true, "wKey");
        ConfigItem<Boolean> sKey = new ConfigItem<>("sKey", true, "sKey");
        ConfigItem<Boolean> aKey = new ConfigItem<>("aKey", true, "aKey");
        ConfigItem<Boolean> dKey = new ConfigItem<>("dKey", true, "dKey");
        ConfigItem<Boolean> jumpKey = new ConfigItem<>("jumpKey", true, "jumpKey");
        ConfigItem<Boolean> placeKey = new ConfigItem<>("placeKey", true, "placeKey");
        ConfigItem<Boolean> useKey = new ConfigItem<>("useKey", true, "useKey");
        ConfigItem<Boolean> attackKey = new ConfigItem<>("attackKey", true, "attackKey");
        ConfigItem<Boolean> destroyKey = new ConfigItem<>("destroyKey", true, "destroyKey");

        ConfigItem<Integer> wTicks = new ConfigItem<>("wTicks", 12, "wTicks");
        ConfigItem<Integer> sTicks = new ConfigItem<>("sTicks", 12, "sTicks");
        ConfigItem<Integer> aTicks = new ConfigItem<>("aTicks", 12, "aTicks");
        ConfigItem<Integer> dTicks = new ConfigItem<>("dTicks", 12, "dTicks");
        ConfigItem<Integer> jumpTicks = new ConfigItem<>("jumpTicks", 10, "jumpTicks");
        ConfigItem<Integer> placeTicks = new ConfigItem<>("placeTicks", 1, "placeTicks");
        ConfigItem<Integer> useTicks = new ConfigItem<>("useTicks", 35, "useTicks");
        ConfigItem<Integer> attackTicks = new ConfigItem<>("attackTicks", 2, "attackTicks");
        ConfigItem<Integer> destroyTicks = new ConfigItem<>("destroyTicks", 20, "destroyTicks");

        ConfigItem<Boolean> showChat = new ConfigItem<>("showChat", true, "showChat");
        ConfigItem<Double> chatTextOpacity = new ConfigItem<>("chatTextOpacity", 1.0, "chatTextOpacity");
        ConfigItem<Double> chatBackgroundOpacity = new ConfigItem<>("chatBackgroundOpacity", 0.5, "wTicks");
        ConfigItem<Double> chatScale = new ConfigItem<>("chatScale", 1.0, "chatScale");
        ConfigItem<Double> chatLineSpacing = new ConfigItem<>("chatLineSpacing", 0.0, "chatLineSpacing");
        ConfigItem<Double> chatWidth = new ConfigItem<>("chatWidth", 0.5, "chatWidth");
        ConfigItem<Double> chatHeight = new ConfigItem<>("chatHeight", 0.5, "chatHeight");

        ConfigItem<Double> chatXOffset = new ConfigItem<>("chatXOffset", 0.0, "chatXOffset");
        ConfigItem<Double> chatYOffset = new ConfigItem<>("chatYOffset", 0.2, "chatYOffset");

        ConfigItem<String> channelId = new ConfigItem<>("channelId", "wowkster", "channelId");


        return new ClientConfig(new ConfigGroup(wKey, sKey, aKey, dKey, jumpKey, placeKey, useKey, attackKey, destroyKey,
                wTicks, sTicks, aTicks, dTicks, jumpTicks, placeTicks, useTicks, attackTicks, destroyTicks,
                showChat, chatTextOpacity, chatBackgroundOpacity, chatScale, chatLineSpacing, chatWidth, chatHeight,
                chatXOffset, chatYOffset, channelId));
    }

    @SafeVarargs
    private static <T> ArrayList<T> of(T ... args){
        return new ArrayList<>(Arrays.asList(args));
    }
}
