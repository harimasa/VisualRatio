package ru.matt;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.config.VisualRatioConfig;
import ru.matt.config.VisualRatioScreen;

public class VisualRatio implements ClientModInitializer {
	public static KeyBinding openconfig;
	public static final Logger LOGGER = LoggerFactory.getLogger("VisualRatio");

	@Override
	public void onInitializeClient() {
		VisualRatioConfig.load();
		openconfig = KeyBindingHelper.registerKeyBinding(new KeyBinding("visualratio.key", GLFW.GLFW_KEY_UNKNOWN, "VisualRatio"));
		ClientTickEvents.END_CLIENT_TICK.register(mc -> {
			if (openconfig.wasPressed()) {
				mc.setScreen(new VisualRatioScreen(null));
			}
		});
	}
}