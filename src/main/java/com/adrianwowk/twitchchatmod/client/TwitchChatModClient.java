package com.adrianwowk.twitchchatmod.client;

import com.adrianwowk.twitchchatmod.client.bot.FiizyBot;
import com.adrianwowk.twitchchatmod.client.config.ChatConfig;
import com.adrianwowk.twitchchatmod.client.config.ClientConfig;
import com.adrianwowk.twitchchatmod.client.gui.screen.ChatConfigScreen;
import com.adrianwowk.twitchchatmod.client.gui.screen.ModConfigScreen;
import com.adrianwowk.twitchchatmod.client.gui.hud.TwitchChatHud;
import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import com.cavariux.twitchirc.Chat.Channel;
import com.cavariux.twitchirc.Core.TwitchBot;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
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
    public static Channel channel;
    public static String channelId;
    public static TwitchChatHud HUD;

    public static ClientConfig CONFIG = ClientConfig.createInstance();
    public static ChatConfig CHAT_CONFIG;

    static {
        CONFIG.saveConfigToFile();
        CONFIG.readConfigFromFile();

        CHAT_CONFIG = new ChatConfig();
    }

    public KeyBinding menuKey;
    public KeyBinding chatKey;

    @Override
    public void onInitializeClient() {

        initCommands();

        botExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        channelId = CONFIG.mainGroup.channelId.getValue();
        twitchBot = new FiizyBot();

        initKeyBinds();

        initRenderEvent();
    }

    public void initKeyBinds(){
        menuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tcm.openMenu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.tcm.keys"
        ));

        chatKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.tcm.openChatMenu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_BACKSLASH,
                "category.tcm.keys"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (menuKey.wasPressed()){
                MinecraftClient.getInstance().openScreen(new ModConfigScreen());
            }
            while (chatKey.wasPressed()){
                MinecraftClient.getInstance().openScreen(new ChatConfigScreen());
            }
        });
    }

    public static void connectBot(){
        if (twitchBot.isRunning()){
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
            if (twitchBot.isRunning()) {
                hud.addMessage(
                        Text.of("§7[§2§lTwitch Chat Mod§7]: §aCreated Twitch IRC Connection Successfully to channel §7\"" + channelId + "\"§a.")
                        , 1);
            } else{
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §cError Connecting to Twitch IRC!")
                        , 1);
            }
        } catch (Exception e){
            hud.addMessage(
                    Text.of("§7[§2§lTwitch Chat Mod§7]: §cError Connecting to Twitch IRC!")
                    , 1);
            e.printStackTrace();
        }
    }

    public static void stopBot(){
        ChatHud hud = MinecraftClient.getInstance().inGameHud.getChatHud();
        if (!twitchBot.isRunning()){
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
            hud.clear(true);
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

    private void initRenderEvent() {
        HUD = new TwitchChatHud(MinecraftClient.getInstance());

        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            if (MinecraftClient.getInstance().options.debugEnabled)
                return;

            // Render HUD

            HUD.render(matrixStack, (int) tickDelta);
        });
    }
}
