package com.adrianwowk.twitchchatmod.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

@Mixin(ClientPlayerEntity.class)
public class ChatHudMixin {
    @Inject(method = "sendChatMessage(Ljava/lang/String;)V", at = @At("HEAD"), cancellable = true)
    public void chatInject(String message, CallbackInfo ci){
        ChatHud hud = MinecraftClient.getInstance().inGameHud.getChatHud();
        if (message.equalsIgnoreCase(".help")){
            hud.addMessage(
                    Text.of("§8===========================\n" +
                            "        §2§lTwitch Chat Mod\n" +
                            "§8===========================\n" +
                            "  §fCommands:\n" +
                            "    §8- §b.start §7(Connects to Twitch Chat)\n" +
                            "    §8- §b.stop §7(Closes Twitch Connection)\n" +
                            "    §8- §b.status §7(Shows Connection Status)\n" +
                            "    §8- §b.send <message> §7(Sends a chat message)\n" +
                            "    §8- §b.setchannel <message> §7(Changes the channel the bot connects to)")
            , 1);
            ci.cancel();
        } else if (message.equalsIgnoreCase(".start")){
            connectBot();
            ci.cancel();
        } else if (message.equalsIgnoreCase(".stop")){
            stopBot();
            ci.cancel();
        } else if (message.equalsIgnoreCase(".status")){
            printStatus();
            ci.cancel();
        } else if (message.startsWith(".send")){
            if (message.length() < 6){
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §aPlease enter a message"));
                ci.cancel();
                return;
            }
            String msg = message.substring(5);
            msg = msg.trim();
            if (msg.length() < 1){
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §ePlease enter a message"));
                ci.cancel();
                return;
            }
            try {
                if (connected) {
                    twitchBot.sendMessage(msg, channel);
                    hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §aSuccessfully sent message §8- §7\"" + msg + "\""), 1);
                } else {
                    hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §cNot connected to an IRC channel. Please use §b.start§c first."));
                }
            } catch (Exception e){
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §cAn Error occurred while trying to send that message"));
                e.printStackTrace();
            }
            ci.cancel();
        } else if (message.startsWith(".setchannel")){
            ci.cancel();
            String[] args = message.split(" ");
            if (args.length == 1){
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §cPlease enter a channel name"));
                return;
            } else if (args.length > 2) {
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §cToo many arguments were passed"));
                return;
            }

            String channelName = args[1];

            if (connected) {
                stopBot();
                channelId = channelName;
                connectBot();
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §aChannel was set to §7\"" + channelName + "\"§a and connection was restarted."));
            } else {
                channelId = channelName;
                hud.addMessage(Text.of("§7[§2§lTwitch Chat Mod§7]: §aChannel was set to §7\"" + channelName + "\"."));
            }

        }
    }
}
