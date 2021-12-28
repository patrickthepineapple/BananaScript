package com.github.unknownbanana.bananascript.interpreter.operation.operations;

import com.github.unknownbanana.bananascript.exception.InvalidParametersException;
import com.github.unknownbanana.bananascript.exception.NumberParseException;
import com.github.unknownbanana.bananascript.exception.VariableNotFoundException;
import com.github.unknownbanana.bananascript.interpreter.operation.Operation;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;
import com.github.unknownbanana.bananascript.number.NumberConverter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class AddOperation extends Operation {

    public AddOperation(VariableStorage variableStorage, int line) {
        super(variableStorage, line);
    }

    @Override
    public void invoke(String @NotNull [] arguments) throws InvalidParametersException, VariableNotFoundException, NumberParseException {
        if (arguments.length != 3) {
            throw new InvalidParametersException("Invalid parameter at " + Arrays.toString(arguments));
        }
        var args = Arrays.copyOfRange(arguments, 1, arguments.length);
        var var = args[0];
        if (!this.getVariableStorage().isValid(var)) {
            throw new VariableNotFoundException("The variable " + var + " is not available! Line: " + getLine());
        }
        var param = args[1];
        if (!NumberConverter.isNumeric(param)) {
            throw new NumberParseException("The variable operation " + param + " is not a number! Line: " + getLine());
        }
        this.getVariableStorage().increaseValue(var, NumberConverter.toInt(param));
    }
}
