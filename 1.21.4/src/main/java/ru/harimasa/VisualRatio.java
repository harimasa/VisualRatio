package ru.harimasa;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.harimasa.config.ConfigScreen;

@Environment(EnvType.CLIENT)
public class VisualRatio implements ClientModInitializer {
	public static final String MOD_ID = "visualratio";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		ConfigScreen.CONFIG.load();
	}
}