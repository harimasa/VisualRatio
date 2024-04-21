package ru.matt;

import ru.matt.command.CVR;
import ru.matt.util.Setting;

public class VRatio {
    public VRatio() {
        super();
    }
    public static Setting<Float> ratio = new Setting<>(1.78f, 0.1f, 5f);
}