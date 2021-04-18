package com.adrianwowk.twitchchatmod.client.input.commands;

import com.adrianwowk.twitchchatmod.client.config.ClientConfig;
import com.adrianwowk.twitchchatmod.client.input.InputCommand;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CONFIG;

public class PlaceCommand extends InputCommand {
    public PlaceCommand() {
        super(1);
        maxRunningTicks = ClientConfig.ConfigGroup.placeTicks.getValue();
        enabled = CONFIG.mainGroup.placeKey.getValue();
    }

    public KeyBinding getKey() {
        return client.options.keyUse;
    }

    @Override
    public void enable() {
        if (client.crosshairTarget == null)
            return;
        if (client.crosshairTarget.getType() != HitResult.Type.BLOCK)
            return;

        ItemStack item = client.player.getMainHandStack();

        if (!(item.getItem() instanceof BlockItem))
            return;

        super.enable();
    }

    @Override
    public void setEnabled(boolean val) {
        CONFIG.mainGroup.placeKey.setValue(val);
        super.setEnabled(val);
    }

    @Override
    public void setMaxRunningTicks(int ticks) {
        CONFIG.mainGroup.placeTicks.setValue(ticks);
        super.setMaxRunningTicks(ticks);
    }
}
