package com.adrianwowk.twitchchatmod.client;

import com.adrianwowk.twitchchatmod.client.bot.FiizyBot;
import com.adrianwowk.twitchchatmod.client.config.ClientConfig;
import com.adrianwowk.twitchchatmod.client.gui.ConfigScreen;
import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import com.cavariux.twitchirc.Chat.Channel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static com.adrianwowk.twitchchatmod.client.input.Commands.*;

@Environment(EnvType.CLIENT)
public class TwitchChatModClient implements ClientModInitializer {

    InputCommand[] commands;

    public static ThreadPoolExecutor botExecutor;
    public static FiizyBot twitchBot;
    public static Thread botThread;
    public static boolean connected = false;
    public static Channel channel;
    public static String channelId = "wowkster";

    public static ClientConfig CONFIG = ClientConfig.createInstance();

    static {
        CONFIG.saveConfigToFile();
        CONFIG.readConfigFromFile();
    }

    public KeyBinding menuKey;

    @Override
    public void onInitializeClient() {

        initCommands();

        botExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        twitchBot = new FiizyBot();

        initKeyBinds();
    }

    public void initKeyBinds(){
        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tcm.openMenu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.tcm.keys"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKey.wasPressed()){
                MinecraftClient.getInstance().openScreen(new ConfigScreen());
            }
        });
    }

    public static void connectBot(){
        if (connected){
            stopBot();
        }

        ChatHud hud = MinecraftClient.getInstance().inGameHud.getChatHud();
        hud.addMessage(
                Text.of("§7[§2§lTwitch Chat Mod§7]: §eOpening Twitch IRC Connection...")
                , 1);
        try {
            botThread = new Thread(() -> {
                twitchBot.connect();
                channel = twitchBot.joinChannel(channelId);
                twitchBot.sendMessage("Hi, Im connected!", channel);
                twitchBot.start();
            });
            botExecutor.execute(botThread);
            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §aCreated Twitch IRC Connection Successfully.")
                    , 1);
        } catch (Exception e){
            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §cError Connecting to Twitch IRC!")
                    , 1);
            e.printStackTrace();
        }
        connected = true;
    }

    public static void stopBot(){
        ChatHud hud = MinecraftClient.getInstance().inGameHud.getChatHud();
        if (!connected){
            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §cTwitch IRC Connection was not found.")
                    , 1);
            return;
        }

        hud.addMessage(
                Text.of("§7[§2§lTwitch Chat Mod§7]: §eClosing Twitch IRC Connection...")
                , 1);
        try {
            twitchBot.partChannel(channelId);
            twitchBot.stop();

            botExecutor.remove(botThread );
            botExecutor.purge();

            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §aClosed Twitch IRC Connection Successfully.")
                    , 1);
            connected = false;
        } catch (Exception e){
            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §cError closing connection!")
                    , 0);
            e.printStackTrace();
        }
    }

    public static void printStatus(){
        ChatHud hud = MinecraftClient.getInstance().inGameHud.getChatHud();
        hud.addMessage(
                Text.of("§7[§2§lTwitch Chat Mod§7]: §eStatus §7- " + (twitchBot.isRunning() ? "§aConnected" : "§cOffline"))
                , 1);
    }

    private void initCommands(){
        commands = new InputCommand[] {FORWARD, BACKWARD, LEFT, RIGHT, JUMP, USE, PLACE, ATTACK, DESTROY};

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (InputCommand cmd : commands){
                if (cmd.isRunning()) {
                    if (cmd.runningTicks < cmd.getMaxRunningTicks())
                        cmd.run();
                    else
                        cmd.disable();
                }
            }

        });
    }
}
