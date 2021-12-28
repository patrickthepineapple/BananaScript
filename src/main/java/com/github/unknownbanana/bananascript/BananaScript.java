package com.github.unknownbanana.bananascript;

import com.github.unknownbanana.bananascript.exception.*;
import com.github.unknownbanana.bananascript.interpreter.Interpreter;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class BananaScript {

    public static void main(String @NotNull [] args) throws BananaScriptNotFoundException, InvalidScriptExtensionException, InvalidKeywordException, VariableNotFoundException, NumberParseException, InvalidParametersException, IOException {
        if (args.length == 1) {
            var path = args[0];
            var file = new File(path);
            if (!file.exists()) {
                throw new BananaScriptNotFoundException("The script \"" + path + "\" is not available");
            }
            if (!path.toLowerCase(Locale.ROOT).endsWith(".bscript")) {
                throw new InvalidScriptExtensionException("The provided script \"" + path + "\" is of invalid type. Only the \"bscript\" extension is allowed!");
            }
            var interpreter = new Interpreter(file);
            interpreter.interpretFile();
        }
    }

}
