package ru.matt.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import ru.matt.VisualRatio;

@Config(name = "visualratio")
public class ModConfig implements ConfigData {

    @ConfigEntry.Category("Main")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 10)
    public float Visualratioinf = 1.78F;

    public static float Visualratioinf() {
        return VisualRatio.MOD_CONFIG.Visualratioinf;
    }
}