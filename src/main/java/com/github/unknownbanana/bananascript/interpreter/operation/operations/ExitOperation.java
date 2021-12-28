package com.github.unknownbanana.bananascript.interpreter.operation.operations;

import com.github.unknownbanana.bananascript.interpreter.operation.Operation;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;

public class ExitOperation extends Operation {
    public ExitOperation(VariableStorage variableStorage, int line) {
        super(variableStorage, line);
    }

    @Override
    public void invoke(String[] arguments) {
        System.out.println("Shutdown due to invocation");
        System.exit(0);
    }
}
