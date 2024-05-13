package ru.matt.config;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import ru.matt.listener.LCheckBox;

import java.text.DecimalFormat;

public class VisualRatioScreen extends Screen {
    public static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    public final Screen prevision;

    // enabled???
    public CheckboxWidget enabled;

    // Aspect Ratio
    public SliderWidget visualratio;

    public VisualRatioScreen(Screen prevision) {
        super(Text.translatable("visualratio.title"));
        this.prevision = prevision;
    }

    @Override
    public void init() {
        if (enabled != null) removed();
        enabled = addDrawableChild(new LCheckBox(width / 2 - textRenderer.getWidth(Text.translatable("visualratio.enabled")) / 2 - 256,
                20, 24 + textRenderer.getWidth(Text.translatable("visualratio.enabled")), 20,
                Text.translatable("visualratio.enabled"), VisualRatioConfig.enabled, cb -> VisualRatioConfig.enabled = cb.isChecked()));
        visualratio = addDrawableChild(new SliderWidget(width / 2 - 320, 48, 150, 20,
                ScreenTexts.composeGenericOptionText(Text.translatable("visualratio.ratio"),
                        Text.translatable(FORMAT.format(VisualRatioConfig.visualratioLog))), VisualRatioConfig.visualratio) {

            @Override
            public void updateMessage() {
                setMessage(ScreenTexts.composeGenericOptionText(Text.translatable("visualratio.ratio"),
                        Text.literal(FORMAT.format(1f + value * (10f - 1f)))));
            }

            @Override
            public void applyValue() {
                VisualRatioConfig.visualratio = (float) value;
                VisualRatioConfig.calculateRatio();
            }
        });
    }

    @Override
    public void removed() {
        VisualRatioConfig.save();
    }
}