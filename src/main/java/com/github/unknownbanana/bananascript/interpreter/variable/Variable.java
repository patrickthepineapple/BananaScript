package com.github.unknownbanana.bananascript.interpreter.variable;

public class Variable {
    private final String name;
    private int value;

    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
