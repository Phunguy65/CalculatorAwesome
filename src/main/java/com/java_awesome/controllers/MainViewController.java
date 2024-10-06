package com.java_awesome.controllers;

import com.java_awesome.interacts.MainViewInteract;
import com.java_awesome.models.CalculatorViewModel;
import com.java_awesome.models.MathFilter;
import com.java_awesome.services.*;
import com.java_awesome.views.MainView;

public class MainViewController extends ControllerBase<MainView>{
    private CalculatorViewModel calculatorDto;
    private MainViewInteract mainViewInteract;
    
    private MainViewController(MainView view) {
        super(view);
    }
    
    public MainViewController(CalculatorViewModel calculatorDto) {
        this(new MainView(new MathFilter()));
        
        this.calculatorDto = calculatorDto;
        this.mainViewInteract = new MainViewInteract(calculatorDto, new CalculatorService(new ShuntingYard()), new CalculatorState());
        this.getView().initialize(calculatorDto, this::calculate);
        
        this.calculatorDto.addPropertyChangeListener("input", evt -> {
            mainViewInteract.parseInput(calculatorDto.getInput());
        });
    }
    
    private void calculate(Runnable afterCalculate) {
        mainViewInteract.calculate();
        updateResult();
        afterCalculate.run();
    }
    
    public void updateResult() {
        mainViewInteract.updateResult();
    }
}
