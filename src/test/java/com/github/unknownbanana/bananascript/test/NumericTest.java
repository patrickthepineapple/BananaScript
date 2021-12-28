package com.github.unknownbanana.bananascript.test;

import com.github.unknownbanana.bananascript.number.NumberConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumericTest {

    @Test
    void isNumericTest() {
        Assertions.assertTrue(NumberConverter.isNumeric("3323465"));
        Assertions.assertFalse(NumberConverter.isNumeric("a23"));
    }

}
