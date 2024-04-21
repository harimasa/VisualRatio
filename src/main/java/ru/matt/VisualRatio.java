package ru.matt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.matt.command.CVR;

public class VisualRatio implements ModInitializer {
	public static VRatio vRatio = new VRatio();
	public static final Logger LOGGER = LoggerFactory.getLogger("visualratio");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated, player) -> {
			CVR.register(dispatcher);
		});
	}
}