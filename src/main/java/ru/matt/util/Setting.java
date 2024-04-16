package ru.matt.util;

public class Setting<T> {
    private final String name;
    private final T defaultValue;
    private T value;
    private T min;
    private T max;
    public Setting<?> parent = null;

    public Setting(String name, T defaultValue, T min, T max) {
        this.name = name;
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