package com.github.unknownbanana.bananascript.interpreter.operation.operations;

import com.github.unknownbanana.bananascript.exception.InvalidParametersException;
import com.github.unknownbanana.bananascript.exception.NumberParseException;
import com.github.unknownbanana.bananascript.exception.VariableNotFoundException;
import com.github.unknownbanana.bananascript.interpreter.operation.Operation;
import com.github.unknownbanana.bananascript.interpreter.variable.Variable;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;
import com.github.unknownbanana.bananascript.number.NumberConverter;

import java.util.Arrays;

public class InitOperation extends Operation {

    public InitOperation(VariableStorage variableStorage, int line) {
        super(variableStorage, line);
    }

    @Override
    public void invoke(String[] arguments) throws InvalidParametersException, VariableNotFoundException, NumberParseException {
        if (arguments.length != 3) {
            throw new InvalidParametersException("Invalid parameter at " + Arrays.toString(arguments));
        }
        var args = Arrays.copyOfRange(arguments, 1, arguments.length);
        var var = args[0];
        if (this.getVariableStorage().isValid(var)) {
            throw new VariableNotFoundException("The variable " + var + " is already assigned! Line: " + getLine());
        }
        var param = args[1];
        if (!NumberConverter.isNumeric(param)) {
            throw new NumberParseException("The variable operation " + param + " is not a number! Line: " + getLine());
        }
        this.getVariableStorage().addVariable(new Variable(var, NumberConverter.toInt(param)));
    }
}
