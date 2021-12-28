package com.github.unknownbanana.bananascript.interpreter;

import com.github.unknownbanana.bananascript.exception.InvalidKeywordException;
import com.github.unknownbanana.bananascript.exception.InvalidParametersException;
import com.github.unknownbanana.bananascript.exception.NumberParseException;
import com.github.unknownbanana.bananascript.exception.VariableNotFoundException;
import com.github.unknownbanana.bananascript.interpreter.operation.Operation;
import com.github.unknownbanana.bananascript.interpreter.operation.Operations;
import com.github.unknownbanana.bananascript.interpreter.operation.operations.AddOperation;
import com.github.unknownbanana.bananascript.interpreter.operation.operations.ExitOperation;
import com.github.unknownbanana.bananascript.interpreter.operation.operations.InitOperation;
import com.github.unknownbanana.bananascript.interpreter.operation.operations.PrintOperation;
import com.github.unknownbanana.bananascript.interpreter.variable.VariableStorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Interpreter {
    private final String[] KEYWORDS = {"exit", "print", "add", "init"};

    private final VariableStorage variableStorage;
    private final File inputFile;

    public Interpreter(File inputFile) {
        this.variableStorage = new VariableStorage();
        this.inputFile = inputFile;
    }

    public void interpretFile() throws IOException, InvalidKeywordException, VariableNotFoundException, InvalidParametersException, NumberParseException {
        var lines = Files.lines(Path.of(inputFile.getAbsolutePath())).toList();
        var count = 0;

        for (var line : lines) {
            count += 1;
            var splits = line.split(" ");
            var keyword = splits[0];
            if (!isValidKeyword(keyword)) {
                throw new InvalidKeywordException("The keyword \"" + keyword + "\" is invalid! Line: " + count);
            }

            if (keyword.equalsIgnoreCase(Operations.EXIT.name())) {
                new ExitOperation(this.variableStorage, count).invoke(splits);
            } else if (keyword.equalsIgnoreCase(Operations.ADD.name())) {
                new AddOperation(this.variableStorage, count).invoke(splits);
            } else if (keyword.equalsIgnoreCase(Operations.PRINT.name())) {
                new PrintOperation(this.variableStorage, count).invoke(splits);
            } else if (keyword.equalsIgnoreCase(Operations.INIT.name())) {
                new InitOperation(this.variableStorage, count).invoke(splits);
            }
        }
    }



    private boolean isValidKeyword(String suspect) {
        for (String keyword : this.KEYWORDS) {
            if (keyword.equalsIgnoreCase(suspect)) {
                return true;
            }
        }
        return false;
    }

}
