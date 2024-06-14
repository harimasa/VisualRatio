package ru.femboypig.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.text.DecimalFormat;

public class VRScreen {
    public static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public static final ConfigClassHandler<VRConfig> CONFIG = ConfigClassHandler.createBuilder(VRConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("visualratio.json"))
                    .build())
            .build();

    @SuppressWarnings("deprecation")
    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Text.translatable("visualratio.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("visualratio.title"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("visualratio.title"))
                                .option(Option.createBuilder(boolean.class)
                                        .name(Text.translatable("visualratio.enable"))
                                        .description(OptionDescription.of(Text.translatable("visualratio.enable")))
                                        .binding(defaults.enable, () -> config.enable, newVal -> config.enable = newVal)
                                        .controller(TickBoxControllerBuilder::create)
                                        .build())
                                .option(Option.createBuilder(float.class)
                                        .name(Text.translatable("visualratio.value"))
                                        .description(OptionDescription.of(Text.translatable("visualratio.value")))
                                        .binding(1.78f, () -> config.value, newVal -> config.value = newVal)
                                        .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                                .valueFormatter(value -> Text.literal(FORMAT.format(value)))
                                                .range(0.5f, 10f)
                                                .step(0.01f))
                                        .build())
                                .build())
                        .build())
                )).generateScreen(parent);
    }
}