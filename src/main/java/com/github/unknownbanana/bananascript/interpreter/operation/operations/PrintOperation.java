package com.github.unknownbanana.bananascript.interpreter.operation.operations;

import com.github.unknownbanana.bananascript.exception.InvalidParametersException;
import com.github.unknownbanana.bananascript.exception.NumberParseException;
import com.github.unknownbanana.bananascript.exception.VariableNotFoundException;
import com.github.unknownbanana.bananascript.interpreter.operation.Operation;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;

import java.util.Arrays;

public class PrintOperation extends Operation {
    public PrintOperation(VariableStorage variableStorage, int line) {
        super(variableStorage, line);
    }

    @Override
    public void invoke(String[] arguments) throws InvalidParametersException, VariableNotFoundException {
        if (arguments.length != 2) {
            throw new InvalidParametersException("Invalid parameter at " + Arrays.toString(arguments));
        }
        var args = Arrays.copyOfRange(arguments, 1, arguments.length);
        var var = args[0];
        if (!this.getVariableStorage().isValid(var)) {
            throw new VariableNotFoundException("The variable " + var + " is not available! Line: " + getLine());
        }
        System.out.println(this.getVariableStorage().getByName(var).getValue());
    }
}
