package ru.femboypig;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.femboypig.config.VRScreen;

public class VisualRatio implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("visualratio");

	@Override
	public void onInitialize() {
		VRScreen.CONFIG.load();
	}
}