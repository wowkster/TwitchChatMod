package com.adrianwowk.twitchchatmod.client.gui.widgets;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class ClearButtonListWidget extends ButtonListWidget {
    public ClearButtonListWidget(MinecraftClient client, int width, int height, int top, int bottom, int itemHeight) {
        super(client, width, height, top, bottom, itemHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        int i = this.getScrollbarPositionX();
        int j = i + 6;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        int k = this.getRowLeft();
        int l = this.top + 4 - (int)this.getScrollAmount();

        this.renderList(matrices, k, l, mouseX, mouseY, delta);

        int o = this.getMaxScroll();
        if (o > 0) {
            RenderSystem.disableTexture();
            int p = (int)((float)((this.bottom - this.top) * (this.bottom - this.top)) / (float)this.getMaxPosition());
            p = MathHelper.clamp(p, 32, this.bottom - this.top - 8);
            int q = (int)this.getScrollAmount() * (this.bottom - this.top - p) / o + this.top;
            if (q < this.top) {
                q = this.top;
            }

            bufferBuilder.begin(7, VertexFormats.POSITION_COLOR);
            bufferBuilder.vertex((double)i, (double)this.bottom, 0.0D).texture(0.0F, 1.0F).color(0, 0, 0, 255).next();
            bufferBuilder.vertex((double)j, (double)this.bottom, 0.0D).texture(1.0F, 1.0F).color(0, 0, 0, 255).next();
            bufferBuilder.vertex((double)j, (double)this.top, 0.0D).texture(1.0F, 0.0F).color(0, 0, 0, 255).next();
            bufferBuilder.vertex((double)i, (double)this.top, 0.0D).texture(0.0F, 0.0F).color(0, 0, 0, 255).next();
            bufferBuilder.vertex((double)i, (double)(q + p), 0.0D).texture(0.0F, 1.0F).color(128, 128, 128, 255).next();
            bufferBuilder.vertex((double)j, (double)(q + p), 0.0D).texture(1.0F, 1.0F).color(128, 128, 128, 255).next();
            bufferBuilder.vertex((double)j, (double)q, 0.0D).texture(1.0F, 0.0F).color(128, 128, 128, 255).next();
            bufferBuilder.vertex((double)i, (double)q, 0.0D).texture(0.0F, 0.0F).color(128, 128, 128, 255).next();
            bufferBuilder.vertex((double)i, (double)(q + p - 1), 0.0D).texture(0.0F, 1.0F).color(192, 192, 192, 255).next();
            bufferBuilder.vertex((double)(j - 1), (double)(q + p - 1), 0.0D).texture(1.0F, 1.0F).color(192, 192, 192, 255).next();
            bufferBuilder.vertex((double)(j - 1), (double)q, 0.0D).texture(1.0F, 0.0F).color(192, 192, 192, 255).next();
            bufferBuilder.vertex((double)i, (double)q, 0.0D).texture(0.0F, 0.0F).color(192, 192, 192, 255).next();
            tessellator.draw();
        }
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
}
