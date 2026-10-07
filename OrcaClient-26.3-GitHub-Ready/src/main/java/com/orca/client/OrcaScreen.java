package com.orca.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class OrcaScreen extends Screen {
    public OrcaScreen() {
        super(Component.literal("Orca Client"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics);

        int w = this.width;
        int h = this.height;

        int left = w / 2 - 300;
        int top = h / 2 - 180;
        int right = w / 2 + 300;
        int bottom = h / 2 + 180;

        graphics.fill(left, top, right, bottom, 0xE6121B2B);
        graphics.fill(left + 12, top + 12, right - 12, top + 64, 0xE61B3040);

        graphics.drawString(this.font, "ORCA CLIENT", left + 28, top + 28, 0xFFFFFFFF);
        graphics.drawString(this.font, "Build. Customize. Play.", left + 28, top + 46, 0xFF8FD9FF);

        graphics.drawString(this.font, "Home", left + 28, top + 92, 0xFFFFFFFF);
        graphics.drawString(this.font, "PvP", left + 28, top + 116, 0xFF9BB6C7);
        graphics.drawString(this.font, "Movement", left + 28, top + 140, 0xFF9BB6C7);
        graphics.drawString(this.font, "Render", left + 28, top + 164, 0xFF9BB6C7);
        graphics.drawString(this.font, "Settings", left + 28, top + 188, 0xFF9BB6C7);

        graphics.drawString(this.font, "Orca AI", left + 190, top + 92, 0xFF8FD9FF);
        graphics.drawString(this.font, "Tell Orca what you want to build...", left + 190, top + 118, 0xFFDDEAF2);

        super.render(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
