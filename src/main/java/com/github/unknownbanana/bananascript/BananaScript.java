package com.github.unknownbanana.bananascript;

import com.github.unknownbanana.bananascript.exception.BananaScriptNotFoundException;
import com.github.unknownbanana.bananascript.exception.InvalidScriptExtensionException;

import java.io.File;
import java.util.Locale;

public class BananaScript {

    public static void main(String[] args) throws BananaScriptNotFoundException, InvalidScriptExtensionException {
        if (args.length == 1) {
            var path = args[0];
            var file = new File(path);
            if (!file.exists()) {
                throw new BananaScriptNotFoundException("The script \"" + path + "\" is not available");
            }
            if (!path.toLowerCase(Locale.ROOT).endsWith(".bscript")) {
                throw new InvalidScriptExtensionException("The provided script \"" + path + "\" is of invalid type. Only the \"bscript\" extension is allowed!");
            }
        }
    }

}
