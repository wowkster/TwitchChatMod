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
        public final ConfigItem<Integer> wTicks;
        public final ConfigItem<Integer> sTicks;
        public final ConfigItem<Integer> aTicks;
        public final ConfigItem<Integer> dTicks;
        public final ConfigItem<Integer> jumpTicks;

        public ConfigGroup(ConfigItem ... args) {
            super(of(args), "config");

            this.wKey = args[0];
            this.sKey = args[1];
            this.aKey = args[2];
            this.dKey = args[3];
            this.jumpKey= args[4];
            this.wTicks = args[5];
            this.sTicks = args[6];
            this.aTicks = args[7];
            this.dTicks = args[8];
            this.jumpTicks = args[9];

        }
    }

    public static ClientConfig createInstance(){
        final ConfigItem<Boolean> wKey = new ConfigItem<>("wKey", true, "wKey");
        final ConfigItem<Boolean> sKey = new ConfigItem<>("sKey", true, "sKey");
        final ConfigItem<Boolean> aKey = new ConfigItem<>("aKey", true, "aKey");
        final ConfigItem<Boolean> dKey = new ConfigItem<>("dKey", true, "dKey");
        final ConfigItem<Boolean> jumpKey = new ConfigItem<>("jumpKey", true, "jumpKey");
        final ConfigItem<Integer> wTicks = new ConfigItem<>("wTicks", 12, "wTicks");
        final ConfigItem<Integer> sTicks = new ConfigItem<>("sTicks", 12, "sTicks");
        final ConfigItem<Integer> aTicks = new ConfigItem<>("aTicks", 12, "aTicks");
        final ConfigItem<Integer> dTicks = new ConfigItem<>("dTicks", 12, "dTicks");
        final ConfigItem<Integer> jumpTicks = new ConfigItem<>("jumpTicks", 10, "jumpTicks");
        return new ClientConfig(new ConfigGroup(wKey, sKey, aKey, dKey, jumpKey, wTicks, sTicks, aTicks, dTicks, jumpTicks));
    }

    @SafeVarargs
    private static <T> ArrayList<T> of(T ... args){
        return new ArrayList<>(Arrays.asList(args));
    }
}
