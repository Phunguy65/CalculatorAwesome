package com.java_awesome.interacts;

import com.java_awesome.models.CalculatorViewModel;
import com.java_awesome.services.CalculatorService;
import com.java_awesome.services.CalculatorState;
import com.java_awesome.models.MathConverter;

public class MainViewInteract {
    private final CalculatorViewModel calculatorViewModel;
    private final CalculatorState calculatorState;
    private final CalculatorService calculatorService;
    public MainViewInteract(CalculatorViewModel calculatorViewModel, CalculatorService calculatorService, CalculatorState calculatorState) {
        this.calculatorViewModel = calculatorViewModel;
        this.calculatorService = calculatorService;
        this.calculatorState = calculatorState;
    }
    
    public void parseInput(String input) {
        String result = MathConverter.convertTo(input);
        saveInput(result);
    }
    
    private void saveInput(String input) {
        calculatorState.setInput(input);
    }
    
    public void calculate() {
        calculatorState.setOutput(calculatorService.calculate(calculatorState.getInput()));
    }
    
    public void updateResult() {
        calculatorViewModel.setOutput(calculatorState.getOutput());
    }
}
