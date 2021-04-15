package com.adrianwowk.twitchchatmod.client.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.util.math.MathHelper;

import static com.adrianwowk.twitchchatmod.client.TwitchChatModClient.CHAT_CONFIG;

public class TwitchChatHud extends ChatHud {

    public TwitchChatHud(MinecraftClient client) {
        super(client);
    }

    @Override
    public int getWidth() {
        return getWidth(CHAT_CONFIG.chatWidth);
    }

    @Override
    public int getHeight() {
        return getHeight(CHAT_CONFIG.chatHeight / (CHAT_CONFIG.chatLineSpacing + 1.0D));
    }

    @Override
    public double getChatScale() {
        return CHAT_CONFIG.chatScale;
    }

    @Override
    public void render(MatrixStack matrices, int tickDelta) {
        if (CHAT_CONFIG.showChat) {
            this.processMessageQueue();
            int i = this.getVisibleLineCount();
            int j = this.visibleMessages.size();
            if (j > 0) {
                boolean bl = this.isChatFocused();

                double d = this.getChatScale();
                int k = MathHelper.ceil((double) this.getWidth() / d);
                RenderSystem.pushMatrix();
                RenderSystem.translatef(2.0F, 8.0F, 0.0F);
                RenderSystem.translatef((float)getXOffset(CHAT_CONFIG.chatXOffset),(float) getYOffset(CHAT_CONFIG.chatYOffset),0);
                RenderSystem.scaled(d, d, 1.0D);
                double e = CHAT_CONFIG.chatTextOpacity * 0.8999999761581421D + 0.10000000149011612D;
                double f = CHAT_CONFIG.chatBackgroundOpacity;
                double g = 9.0D * (CHAT_CONFIG.chatLineSpacing + 1.0D);
                double h = -8.0D * (CHAT_CONFIG.chatLineSpacing + 1.0D) + 4.0D * CHAT_CONFIG.chatLineSpacing;
                int l = 0;

                int m;
                int x;
                int aa;
                int ab;
                for (m = 0; m + this.scrolledLines < this.visibleMessages.size() && m < i; ++m) {
                    ChatHudLine<OrderedText> chatHudLine = this.visibleMessages.get(m + this.scrolledLines);
                    if (chatHudLine != null) {
                        x = tickDelta - chatHudLine.getCreationTick();
                        if (x < 200 || bl) {
                            double o = bl ? 1.0D : getMessageOpacityMultiplier(x);
                            aa = (int) (255.0D * o * e);
                            ab = (int) (255.0D * o * f);
                            ++l;
                            if (aa > 3) {
                                double s = (double) (-m) * g;
                                matrices.push();
                                matrices.translate(0.0D, 0.0D, 50.0D);
                                fill(matrices, -2, (int) (s - g), k + 4, (int) s, ab << 24);
                                RenderSystem.enableBlend();
                                matrices.translate(0.0D, 0.0D, 50.0D);
                                this.client.textRenderer.drawWithShadow(matrices, chatHudLine.getText(), 0.0F, (float) ((int) (s + h)), 16777215 + (aa << 24));
                                RenderSystem.disableAlphaTest();
                                RenderSystem.disableBlend();
                                matrices.pop();
                            }
                        }
                    }
                }

                if (bl) {
                    int v = 9;
                    RenderSystem.translatef(-3.0F, 0.0F, 0.0F);
                    int w = j * v + j;
                    x = l * v + l;
                    int y = this.scrolledLines * x / j;
                    int z = x * x / w;
                    if (w != x) {
                        aa = y > 0 ? 170 : 96;
                        ab = this.hasUnreadNewMessages ? 13382451 : 3355562;
                        fill(matrices, 0, -y, 2, -y - z, ab + (aa << 24));
                        fill(matrices, 2, -y, 1, -y - z, 13421772 + (aa << 24));
                    }
                }

                RenderSystem.popMatrix();
            }
        }
    }

    public static double getXOffset(double xOff){
        return xOff * MinecraftClient.getInstance().getWindow().getScaledWidth();
    }

    public static double getYOffset(double yOff){
        return yOff * MinecraftClient.getInstance().getWindow().getScaledHeight();
    }
}
