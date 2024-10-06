package com.java_awesome.models;

import java.beans.PropertyChangeSupport;

public class CalculatorViewModel {
    private String input;
    private String output;
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public CalculatorViewModel()
    {
    }
    
    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }
    
    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        String oldInput = this.input;
        this.input = input;
        propertyChangeSupport.firePropertyChange("input", oldInput, input);
    }
    
    public String getOutput() {
        return output;
    }
    
    public void setOutput(String output) {
        String oldOutput = this.output;
        this.output = output;
        propertyChangeSupport.firePropertyChange("output", oldOutput, output);
    }
    

}
