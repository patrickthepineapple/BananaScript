package com.github.unknownbanana.bananascript.interpreter.variable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class VariableStorage {
    private final List<Variable> variables;

    public VariableStorage() {
        this.variables = new ArrayList<>();
    }

    public void addVariable(Variable variable) {
        this.variables.add(variable);
    }

    public Variable getByName(String name) {
        AtomicReference<Variable> var = new AtomicReference<>();
        this.variables.forEach(variable -> {
            if (variable.getName().equalsIgnoreCase(name)) {
                var.set(variable);
            }
        });
        return var.get();
    }

    public void increaseValue(String name, int value) {
        setValue(name, getByName(name).getValue() + value);
    }

    public void setValue(String name, int value) {
        var var = getByName(name);
        var.setValue(value);
    }

    public void decreaseValue(String name, int value) {
        setValue(name, getByName(name).getValue() - value);
    }

    public boolean isValid(String name) {
        AtomicBoolean contains = new AtomicBoolean(false);
        this.variables.forEach(variable -> {
            if (variable.getName().equalsIgnoreCase(name)) {
                contains.set(true);
            }
        });

        return contains.get();
    }
}
