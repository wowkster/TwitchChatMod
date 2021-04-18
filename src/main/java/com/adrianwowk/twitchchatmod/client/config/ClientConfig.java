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
        public static final ConfigItem<Boolean> wKey = new ConfigItem<>("wKey", true, "wKey");
        public static final ConfigItem<Boolean> sKey = new ConfigItem<>("sKey", true, "sKey");
        public static final ConfigItem<Boolean> aKey = new ConfigItem<>("aKey", true, "aKey");
        public static final ConfigItem<Boolean> dKey = new ConfigItem<>("dKey", true, "dKey");
        public static final ConfigItem<Boolean> jumpKey = new ConfigItem<>("jumpKey", true, "jumpKey");
        public static final ConfigItem<Boolean> placeKey = new ConfigItem<>("placeKey", true, "placeKey");
        public static final ConfigItem<Boolean> useKey = new ConfigItem<>("useKey", true, "useKey");
        public static final ConfigItem<Boolean> attackKey = new ConfigItem<>("attackKey", true, "attackKey");
        public static final ConfigItem<Boolean> destroyKey = new ConfigItem<>("destroyKey", true, "destroyKey");

        public static final ConfigItem<Integer> wTicks = new ConfigItem<>("wTicks", 12, "wTicks");
        public static final ConfigItem<Integer> sTicks = new ConfigItem<>("sTicks", 12, "sTicks");
        public static final ConfigItem<Integer> aTicks = new ConfigItem<>("aTicks", 12, "aTicks");
        public static final ConfigItem<Integer> dTicks = new ConfigItem<>("dTicks", 12, "dTicks");
        public static final ConfigItem<Integer> jumpTicks = new ConfigItem<>("jumpTicks", 10, "jumpTicks");
        public static final ConfigItem<Integer> placeTicks = new ConfigItem<>("placeTicks", 1, "placeTicks");
        public static final ConfigItem<Integer> useTicks = new ConfigItem<>("useTicks", 35, "useTicks");
        public static final ConfigItem<Integer> attackTicks = new ConfigItem<>("attackTicks", 2, "attackTicks");
        public static final ConfigItem<Integer> destroyTicks = new ConfigItem<>("destroyTicks", 20, "destroyTicks");

        public static final ConfigItem<Boolean> showChat = new ConfigItem<>("showChat", true, "showChat");
        public static final ConfigItem<Double>  chatTextOpacity = new ConfigItem<>("chatTextOpacity", 1.0, "chatTextOpacity");
        public static final ConfigItem<Double>  chatBackgroundOpacity = new ConfigItem<>("chatBackgroundOpacity", 0.5, "wTicks");
        public static final ConfigItem<Double>  chatScale = new ConfigItem<>("chatScale", 1.0, "chatScale");
        public static final ConfigItem<Double>  chatLineSpacing = new ConfigItem<>("chatLineSpacing", 0.0, "chatLineSpacing");
        public static final ConfigItem<Double>  chatWidth = new ConfigItem<>("chatWidth", 0.5, "chatWidth");
        public static final ConfigItem<Double>  chatHeight = new ConfigItem<>("chatHeight", 0.5, "chatHeight");

        public static final ConfigItem<Double>  chatXOffset = new ConfigItem<>("chatXOffset", 0.0, "chatXOffset");
        public static final ConfigItem<Double>  chatYOffset = new ConfigItem<>("chatYOffset", 0.2, "chatYOffset");

        public static final ConfigItem<String>  channelId = new ConfigItem<>("channelId", "wowkster", "channelId");

        public ConfigGroup() {
            super(of(wKey, sKey, aKey, dKey, jumpKey, placeKey, useKey, attackKey, destroyKey,
                    wTicks, sTicks, aTicks, dTicks, jumpTicks, placeTicks, useTicks, attackTicks, destroyTicks,
                    showChat, chatTextOpacity, chatBackgroundOpacity, chatScale, chatLineSpacing, chatWidth, chatHeight,
                    chatXOffset, chatYOffset, channelId), "config");
        }
    }

    public static ClientConfig createInstance(){
        return new ClientConfig(new ConfigGroup());
    }

    @SafeVarargs
    private static <T> ArrayList<T> of(T ... args){
        return new ArrayList<>(Arrays.asList(args));
    }
}
