package ru.matt;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import ru.matt.config.ModConfig;

public class VisualRatio implements ClientModInitializer {
	public static final ModConfig MOD_CONFIG = AutoConfig.register(ModConfig.class, GsonConfigSerializer::new).get();
	@Override
	public void onInitializeClient() {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
	}
}