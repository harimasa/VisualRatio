package ru.matt.util;

public class Setting<T> {
    private final T defaultValue;
    private T value;
    private T min;
    private T max;
    public Setting<?> parent = null;

    public Setting(T defaultValue, T min, T max) {
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
    }
    public T getValue() {
        return this.value;
    }


    public boolean isFloat() {
        return this.value instanceof Float;
    }
}