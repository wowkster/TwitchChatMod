package com.adrianwowk.twitchchatmod.client.bot;

import com.cavariux.twitchirc.Chat.Channel;
import com.cavariux.twitchirc.Chat.User;
import com.cavariux.twitchirc.Core.TwitchBot;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.input.Commands.*;
import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public class FiizyBot extends TwitchBot {

    public static final String joinMessage = "Hi, I'm FiizyBot! FiizyBot is a Twitch bot which can control the in game movements of a Minecraft player using certain chat commands. To see all the commands, type \"?fiizy\"";
    public static final String leaveMessage = "Bye! FiizyBot is disconnecting from this Twitch chat channel.";
    public static final String commandsMessage = "FiizyBot has a lot of commands which can control player movement. They include: " +
            "\"w\" (Move forward)" +
            ", \"s\" (Move backward)" +
            ", \"a\" (Strafe left)" +
            ", \"d\" (Strafe right)" +
            ", \"j\" (Jump)" +
            ", \"u\" (Use/Eat)" +
            ", \"p\" (Place Block)" +
            ", \"t\" (Attack Entity)" +
            ", \"b\" (Break Block)";

    public FiizyBot ()
    {
        this.setUsername("FiizyBot");
        this.setOauth_Key(/* (Out of view)                                                                                                                                                                                                                             */"oauth:1jmuznghstpyafhb7xzuvuk05znfo7");
        this.setClientID(/* (Out of view)                                                                                                                                                                                                                               */"92r98crn65yztid3onz1qtb5s27crf");
    }

    @Override
    public void onMessage(User user, Channel channel, String message)
    {
        HUD.addMessage(Text.of("§7[§5Chat§7]: §" + (user.isMod(channel) ? "a" : "8") + "(" + user + ") §f" + message));
        if (message.equalsIgnoreCase("j"))
            JUMP.enable();
        else if (message.equalsIgnoreCase("w"))
            FORWARD.enable();
        else if (message.equalsIgnoreCase("s"))
            BACKWARD.enable();
        else if (message.equalsIgnoreCase("a"))
            LEFT.enable();
        else if (message.equalsIgnoreCase("d"))
            RIGHT.enable();
        else if (message.equalsIgnoreCase("u"))
            USE.enable();
        else if (message.equalsIgnoreCase("p"))
            PLACE.enable();
        else if (message.equalsIgnoreCase("t"))
            ATTACK.enable();
        else if (message.equalsIgnoreCase("b"))
            DESTROY.enable();
        else if (message.equalsIgnoreCase("c"))
            shouldClick = true;
        else if (message.equalsIgnoreCase("?fiizy"))
            sendMessage(commandsMessage, channel);
    }
}
