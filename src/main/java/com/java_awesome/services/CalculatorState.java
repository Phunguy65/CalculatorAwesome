package com.java_awesome.services;

public class CalculatorState {
    private String input;
    private String output;
    
    public CalculatorState() {
        this.input = "";
        this.output = "";
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    
    public String getOutput() {
        return output;
    }
    
    public void setOutput(String output) {
        this.output = output;
    }
}
