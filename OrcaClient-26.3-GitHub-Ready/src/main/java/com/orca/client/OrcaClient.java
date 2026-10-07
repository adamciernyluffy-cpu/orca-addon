package com.orca.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class OrcaClient implements ClientModInitializer {
    public static final KeyMapping OPEN_GUI = new KeyMapping(
            "key.orca.open_gui",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.orca"
    );

    private boolean lastPressed = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            boolean pressed = OPEN_GUI.isDown();
            if (pressed && !lastPressed && client.screen == null) {
                client.setScreen(new OrcaScreen());
            }
            lastPressed = pressed;
        });
    }
}
