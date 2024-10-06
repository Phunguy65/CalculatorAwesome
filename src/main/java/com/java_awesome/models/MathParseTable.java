package com.java_awesome.models;

import java.util.Map;

import static java.util.Map.entry;

public class MathParseTable {
    
    public final static Map<Integer, String> DisplayTable = Map.ofEntries(
        entry(MathRuler.PLUS_SIGN, "\u002B"),
        entry(MathRuler.MINUS_SIGN, "\u2212"),
        entry(MathRuler.MULTIPLICATION_SIGN, "\u00D7"),
        entry(MathRuler.DIVISION_SIGN, "\u00F7"),
        entry(MathRuler.NUMBER_0, "\u0030"),
        entry(MathRuler.NUMBER_1, "\u0031"),
        entry(MathRuler.NUMBER_2, "\u0032"),
        entry(MathRuler.NUMBER_3, "\u0033"),
        entry(MathRuler.NUMBER_4, "\u0034"),
        entry(MathRuler.NUMBER_5, "\u0035"),
        entry(MathRuler.NUMBER_6, "\u0036"),
        entry(MathRuler.NUMBER_7, "\u0037"),
        entry(MathRuler.NUMBER_8, "\u0038"),
        entry(MathRuler.NUMBER_9, "\u0039"),
        entry(MathRuler.LEFT_PARENTHESIS, "\u0028"),
        entry(MathRuler.RIGHT_PARENTHESIS, "\u0029"),
        entry(MathRuler.DECIMAL_POINT, "\u002E")
    );
    
    public final static Map<Integer, String> RawTable = Map.ofEntries(
            entry(MathRuler.PLUS_SIGN, "\u002B"),
            entry(MathRuler.MINUS_SIGN, "\u002D"),
            entry(MathRuler.MULTIPLICATION_SIGN, "\u002A"),
            entry(MathRuler.DIVISION_SIGN, "\u002F"),
            entry(MathRuler.NUMBER_0, "\u0030"),
            entry(MathRuler.NUMBER_1, "\u0031"),
            entry(MathRuler.NUMBER_2, "\u0032"),
            entry(MathRuler.NUMBER_3, "\u0033"),
            entry(MathRuler.NUMBER_4, "\u0034"),
            entry(MathRuler.NUMBER_5, "\u0035"),
            entry(MathRuler.NUMBER_6, "\u0036"),
            entry(MathRuler.NUMBER_7, "\u0037"),
            entry(MathRuler.NUMBER_8, "\u0038"),
            entry(MathRuler.NUMBER_9, "\u0039"),
            entry(MathRuler.LEFT_PARENTHESIS, "\u0028"),
            entry(MathRuler.RIGHT_PARENTHESIS, "\u0029"),
            entry(MathRuler.DECIMAL_POINT, "\u002E")
    );
    
    public final static Map<String, Character> DisplayToRaw = Map.ofEntries(
            entry(String.valueOf(DisplayTable.get(MathRuler.PLUS_SIGN)), RawTable.get(MathRuler.PLUS_SIGN).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.MINUS_SIGN)), RawTable.get(MathRuler.MINUS_SIGN).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.MULTIPLICATION_SIGN)), RawTable.get(MathRuler.MULTIPLICATION_SIGN).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.DIVISION_SIGN)), RawTable.get(MathRuler.DIVISION_SIGN).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_0)), RawTable.get(MathRuler.NUMBER_0).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_1)), RawTable.get(MathRuler.NUMBER_1).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_2)), RawTable.get(MathRuler.NUMBER_2).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_3)), RawTable.get(MathRuler.NUMBER_3).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_4)), RawTable.get(MathRuler.NUMBER_4).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_5)), RawTable.get(MathRuler.NUMBER_5).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_6)), RawTable.get(MathRuler.NUMBER_6).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_7)), RawTable.get(MathRuler.NUMBER_7).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_8)), RawTable.get(MathRuler.NUMBER_8).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.NUMBER_9)), RawTable.get(MathRuler.NUMBER_9).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.LEFT_PARENTHESIS)), RawTable.get(MathRuler.LEFT_PARENTHESIS).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.RIGHT_PARENTHESIS)), RawTable.get(MathRuler.RIGHT_PARENTHESIS).charAt(0)),
            entry(String.valueOf(DisplayTable.get(MathRuler.DECIMAL_POINT)), RawTable.get(MathRuler.DECIMAL_POINT).charAt(0))
    );
    
}
