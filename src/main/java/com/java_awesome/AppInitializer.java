package com.java_awesome;

import com.java_awesome.controllers.MainViewController;
import com.java_awesome.extensions.Initialize;
import com.java_awesome.models.CalculatorViewModel;
import com.java_awesome.views.MainWindow;

import javax.swing.*;

public class AppInitializer implements Initialize {
    public AppInitializer() {
    }
    
    @Override
    public void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                MainViewController mainViewController = new MainViewController(new CalculatorViewModel());
                mainWindow.setContentPane(mainViewController.getView().getView());
                mainWindow.setTitle("Calculator Awesome");
                mainWindow.setSize(400, 400);
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setLocationRelativeTo(null);
                mainWindow.setVisible(true);
            }
        });
    }
}