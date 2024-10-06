package com.java_awesome.services;

import com.java_awesome.models.MathParseTable;
import com.java_awesome.models.MathRuler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import static java.util.Map.entry;

public class ShuntingYard implements ICalculator {
    
    private final Map<String, Integer> Precedence = Map.ofEntries(
            entry(MathParseTable.RawTable.get(MathRuler.PLUS_SIGN), 1),
            entry(MathParseTable.RawTable.get(MathRuler.MINUS_SIGN), 1),
            entry(MathParseTable.RawTable.get(MathRuler.MULTIPLICATION_SIGN), 2),
            entry(MathParseTable.RawTable.get(MathRuler.DIVISION_SIGN), 2)
    );
    
    private final String delimiter = MathParseTable.RawTable.get(MathRuler.DECIMAL_POINT) +
            MathParseTable.RawTable.get(MathRuler.PLUS_SIGN) +
            MathParseTable.RawTable.get(MathRuler.MINUS_SIGN) +
            MathParseTable.RawTable.get(MathRuler.MULTIPLICATION_SIGN) +
            MathParseTable.RawTable.get(MathRuler.DIVISION_SIGN) +
            MathParseTable.RawTable.get(MathRuler.LEFT_PARENTHESIS) +
            MathParseTable.RawTable.get(MathRuler.RIGHT_PARENTHESIS);
    
    private final String BadResult = "NaN";
    
    public ShuntingYard() {
    }
    
    public void validateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }
    }

    public String calculate(String expression) {
        try {
            validateExpression(expression);
            return calculateInternal(expression).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return BadResult;
        }
    }
    
    private BigDecimal calculateInternal(String expression) {
        
        List<String> postfix = toPostfix(expression);
        Stack<BigDecimal> stack = new Stack<>();
        
        for (String token : postfix) {
            if (MathRuler.isOperator(token.charAt(0))) {
                BigDecimal b = stack.pop();
                BigDecimal a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(new BigDecimal(token));
            }
        }
        
        return stack.pop();
        
    }
    
    private List<String> toPostfix(String expression) {
        List<String> postfix = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        StringBuilder number = new StringBuilder();
        boolean lastWasOperator = true;
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (Character.isDigit(c) || c == delimiter.charAt(0)) {
                number.append(c);
                lastWasOperator = false;
            }
            else if(MathParseTable.RawTable.get(MathRuler.MINUS_SIGN).equals(String.valueOf(c)) && lastWasOperator) {
                number.append(c);
            }
            else if (MathRuler.isOperator(c)){
                if(number.length() > 0) {
                    postfix.add(number.toString());
                    number.setLength(0);
                }
                while (!operators.isEmpty() && !MathParseTable.RawTable.get(MathRuler.LEFT_PARENTHESIS).equals(operators.peek()) && Precedence.get(operators.peek()) >= Precedence.get(String.valueOf(c))) {
                    postfix.add(operators.pop());
                }
                operators.push(String.valueOf(c));
                lastWasOperator = true;
            }
            else if (MathParseTable.RawTable.get(MathRuler.LEFT_PARENTHESIS).equals(String.valueOf(c))) {
                
                if (number.length() > 0) {
                    postfix.add(number.toString());
                    number.setLength(0);
                }
                operators.push(String.valueOf(c));
                lastWasOperator = true;
            }
            else if (MathParseTable.RawTable.get(MathRuler.RIGHT_PARENTHESIS).equals(String.valueOf(c))) {
                if(number.length() > 0) {
                    postfix.add(number.toString());
                    number.setLength(0);
                }
                while (!operators.isEmpty() && !MathParseTable.RawTable.get(MathRuler.LEFT_PARENTHESIS).equals(operators.peek())) {
                    postfix.add(operators.pop());
                }
                operators.pop();
                lastWasOperator = false;
            }
        }
        
        if (number.length() > 0) {
            postfix.add(number.toString());
        }
        
        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }
        
        return postfix;
    }
    
    private BigDecimal applyOperator(BigDecimal a, BigDecimal b, String operator) {
        return switch (operator) {
            case "+" -> a.add(b);
            case "-" -> a.subtract(b);
            case "*" -> a.multiply(b);
            case "/" -> a.divide(b, MathContext.DECIMAL128);
            case "^" -> a.pow(b.intValue());
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
