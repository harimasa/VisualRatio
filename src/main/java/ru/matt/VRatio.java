package ru.matt;

import ru.matt.util.Setting;

public class VRatio {
    public VRatio() {
        super();
    }
    public static Setting<Float> ratio = new Setting<>("Ratio", 1.47f, 0.1f, 5f);
}