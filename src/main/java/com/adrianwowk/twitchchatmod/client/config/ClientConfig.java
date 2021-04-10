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

        }
    }

    public static ClientConfig createInstance(){
        final ConfigItem<Boolean> wKey = new ConfigItem<>("wKey", true, "wKey");
        final ConfigItem<Boolean> sKey = new ConfigItem<>("sKey", true, "sKey");
        final ConfigItem<Boolean> aKey = new ConfigItem<>("aKey", true, "aKey");
        final ConfigItem<Boolean> dKey = new ConfigItem<>("dKey", true, "dKey");
        final ConfigItem<Boolean> jumpKey = new ConfigItem<>("jumpKey", true, "jumpKey");
        final ConfigItem<Boolean> placeKey = new ConfigItem<>("placeKey", true, "placeKey");
        final ConfigItem<Boolean> useKey = new ConfigItem<>("useKey", true, "useKey");
        final ConfigItem<Boolean> attackKey = new ConfigItem<>("attackKey", true, "attackKey");
        final ConfigItem<Boolean> destroyKey = new ConfigItem<>("destroyKey", true, "destroyKey");

        final ConfigItem<Integer> wTicks = new ConfigItem<>("wTicks", 12, "wTicks");
        final ConfigItem<Integer> sTicks = new ConfigItem<>("sTicks", 12, "sTicks");
        final ConfigItem<Integer> aTicks = new ConfigItem<>("aTicks", 12, "aTicks");
        final ConfigItem<Integer> dTicks = new ConfigItem<>("dTicks", 12, "dTicks");
        final ConfigItem<Integer> jumpTicks = new ConfigItem<>("jumpTicks", 10, "jumpTicks");
        final ConfigItem<Integer> placeTicks = new ConfigItem<>("placeTicks", 1, "placeTicks");
        final ConfigItem<Integer> useTicks = new ConfigItem<>("useTicks", 35, "useTicks");
        final ConfigItem<Integer> attackTicks = new ConfigItem<>("attackTicks", 2, "attackTicks");
        final ConfigItem<Integer> destroyTicks = new ConfigItem<>("destroyTicks", 20, "destroyTicks");

        return new ClientConfig(new ConfigGroup(wKey, sKey, aKey, dKey, jumpKey, placeKey, useKey, attackKey, destroyKey,
                wTicks, sTicks, aTicks, dTicks, jumpTicks, placeTicks, useTicks, attackTicks, destroyTicks));
    }

    @SafeVarargs
    private static <T> ArrayList<T> of(T ... args){
        return new ArrayList<>(Arrays.asList(args));
    }
}
