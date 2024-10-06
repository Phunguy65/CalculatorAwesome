package com.java_awesome.services;

public class CalculatorService {
    
    private final ICalculator calculator;
    
    public CalculatorService(ICalculator calculator) {
        this.calculator = calculator;
    }
    
    public String calculate(String expression) {
        return calculator.calculate(expression);
    }
    
}
