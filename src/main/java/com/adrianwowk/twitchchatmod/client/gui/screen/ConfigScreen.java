package com.adrianwowk.twitchchatmod.client.gui.screen;

import com.adrianwowk.twitchchatmod.client.gui.widgets.ClearButtonListWidget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.options.Option;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CHAT_CONFIG;

public abstract class ConfigScreen extends Screen {
    protected ButtonListWidget list;
    protected Option[] OPTIONS;

    protected ConfigScreen(Text title, Option[] options) {
        super(title);
        OPTIONS = options;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        this.list.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    protected void init() {
        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height - 27 - 60, 200, 20, ScreenTexts.DONE, (button) -> {
            this.client.openScreen(null);
        }));

        list = new ClearButtonListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.list.addAll(OPTIONS);
        this.children.add(this.list);
    }

    @Override
    public void onClose(){
        super.onClose();
    }
}
