package ru.harimasa;

import net.fabricmc.api.ClientModInitializer;
import ru.harimasa.visualratio.config.ConfigScreen;

public class VisualRatio implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ConfigScreen.CONFIG.load();
	}
}