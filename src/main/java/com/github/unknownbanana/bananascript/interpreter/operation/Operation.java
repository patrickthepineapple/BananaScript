package com.github.unknownbanana.bananascript.interpreter.operation;

import com.github.unknownbanana.bananascript.exception.InvalidParametersException;
import com.github.unknownbanana.bananascript.exception.NumberParseException;
import com.github.unknownbanana.bananascript.exception.VariableNotFoundException;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;


public abstract class Operation {
    private final VariableStorage variableStorage;
    private final int line;

    public Operation(VariableStorage variableStorage, int line) {
        this.variableStorage = variableStorage;
        this.line = line;
    }

    public abstract void invoke(String[] arguments) throws InvalidParametersException, VariableNotFoundException, NumberParseException;

    public VariableStorage getVariableStorage() {
        return variableStorage;
    }

    public int getLine() {
        return this.line;
    }
}
