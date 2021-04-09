package com.adrianwowk.twitchchatmod.client.input;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.*;

public abstract class InputCommand {
    protected boolean running;
    protected boolean enabled;
    public int runningTicks;
    protected int maxRunningTicks;
    protected MinecraftClient client;

    protected InputCommand(int maxRunningTicks) {
        this.running = false;
        this.runningTicks = 0;
        this.maxRunningTicks = maxRunningTicks;
        this.client = MinecraftClient.getInstance();
    }

    public void run(){
        runningTicks++;
        if (!getKey().isPressed()) {
            getKey().setPressed(true);
        }
    }
    abstract public KeyBinding getKey();

    public int getMaxRunningTicks(){
        return maxRunningTicks;
    }

    public void disable(){
        if (!enabled)
            return;

        getKey().setPressed(false);
        running = false;
        runningTicks = 0;
    }

    public void enable(){
        if (!enabled)
            return;

        if (!running){
            this.running = true;
        }
        runningTicks = 0;
    }

    public boolean isEnabled(){
        return this.enabled;
    }

    public void setEnabled(boolean val){
        this.enabled = val;
        CONFIG.saveConfigToFile();
    }

    public void setMaxRunningTicks(int ticks){
        this.maxRunningTicks = ticks;
        CONFIG.saveConfigToFile();
    }

    public boolean isRunning(){
        return running;
    }
}
