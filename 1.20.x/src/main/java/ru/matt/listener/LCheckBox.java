package ru.matt.listener;

import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;

import java.util.function.Consumer;

public class LCheckBox extends CheckboxWidget {
    public final Consumer<LCheckBox> listener;
    public LCheckBox(int x, int y, int width, int height, Text message, boolean checked, Consumer<LCheckBox> listener) {
        super(x, y, width, height, message, checked);
        this.listener = listener;
    }

    public LCheckBox(int x, int y, int width, int height, Text message, boolean checked, boolean showMessage, Consumer<LCheckBox> listener) {
        super(x, y, width, height, message, checked, showMessage);
        this.listener = listener;
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);
        listener.accept(this);
    }
}