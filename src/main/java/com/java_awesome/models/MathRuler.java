package com.java_awesome.models;

public class MathRuler {
    
    public static final int PLUS_SIGN = 0x002B;
    public static final int MINUS_SIGN = 0x002D;
    public static final int MULTIPLICATION_SIGN = 0x002A;
    public static final int DIVISION_SIGN = 0x002F;
    
    public static final int NUMBER_0 = 0x0030;
    public static final int NUMBER_1 = 0x0031;
    public static final int NUMBER_2 = 0x0032;
    public static final int NUMBER_3 = 0x0033;
    public static final int NUMBER_4 = 0x0034;
    public static final int NUMBER_5 = 0x0035;
    public static final int NUMBER_6 = 0x0036;
    public static final int NUMBER_7 = 0x0037;
    public static final int NUMBER_8 = 0x0038;
    public static final int NUMBER_9 = 0x0039;
    
    public static final int LEFT_PARENTHESIS = 0x0028;
    public static final int RIGHT_PARENTHESIS = 0x0029;
    
    public static final int DECIMAL_POINT = 0x002E;
    
    private static final String operators = MathParseTable.RawTable.get(PLUS_SIGN) +
            MathParseTable.RawTable.get(MINUS_SIGN) +
            MathParseTable.RawTable.get(MULTIPLICATION_SIGN) +
            MathParseTable.RawTable.get(DIVISION_SIGN);
    
    public static boolean isOperator(String token) {
        return operators.contains(token);
    }
    
    public static boolean isOperator(char c) {
        return isOperator(String.valueOf(c));
    }
    
    public static boolean isDigit(char c){
        return c >= NUMBER_0 && c <= NUMBER_9;
    }
    
    public static boolean isParenthesis(char c){
        return c == LEFT_PARENTHESIS || c == RIGHT_PARENTHESIS;
    }
    
    public static boolean isDot(char c){
        return c == DECIMAL_POINT;
    }
    
    public static boolean isMathCharacter(char c){
        return isOperator(c) || isDigit(c) || isParenthesis(c) || isDot(c);
    }
    
    
}
