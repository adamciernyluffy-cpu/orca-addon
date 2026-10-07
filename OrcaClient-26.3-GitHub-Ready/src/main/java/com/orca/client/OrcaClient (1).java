package com.orca.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class OrcaClient implements ClientModInitializer {

    private static final KeyMapping.Category ORCA_CATEGORY =
            KeyMapping.Category.register(
                    Identifier.fromNamespaceAndPath("orca", "main")
            );

    public static final KeyMapping OPEN_GUI =
            KeyMappingHelper.registerKeyMapping(
                    new KeyMapping(
                            "key.orca.open_gui",
                            InputConstants.Type.KEYBOARD,
                            InputConstants.KEY_RSHIFT,
                            ORCA_CATEGORY
                    )
            );

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_GUI.consumeClick()) {
                if (client.screen == null) {
                    client.gui.setScreen(new OrcaScreen());
                }
            }
        });
    }
}
