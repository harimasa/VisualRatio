package ru.matt.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import ru.matt.VisualRatio;

import java.lang.reflect.Modifier;
import java.nio.file.Files;

public class VisualRatioConfig {
    public static final transient Gson GSON = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

    // Enabled?
    public static boolean enabled = true;

    // Default value
    public static float visualratio = 0.78f;

    // Logarithm
    public static transient float visualratioLog;

    public static void calculateRatio() {
        visualratioLog = 1f + visualratio * (10f - 1f);
    }

    // Load Config
    public static void load() {
        try {
            var path = FabricLoader.getInstance().getConfigDir().resolve("visualratio.json");
            if (Files.exists(path)) {
                GSON.fromJson(Files.readString(path), VisualRatioConfig.class);
            }
        } catch (Throwable t) {
            VisualRatio.LOGGER.warn("Failed to Load Config", t);
        }
        calculateRatio();
    }

    // Save Config
    public static void save() {
        try {
            var p = FabricLoader.getInstance().getConfigDir().resolve("visualratio.json");
            Files.createDirectories(p.getParent());
            Files.writeString(p, GSON.toJson(new VisualRatioConfig()));
        } catch (Throwable t) {
            VisualRatio.LOGGER.warn("Unable to save VAR config", t);
        }
    }
}