package com.java_awesome.views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    public MainWindow(){
        super();
        initUI();
    }
    
    private void initUI() {
        if(this.rootPane != null) {
            this.addWindowFocusListener(new WindowAdapter() {
                @Override
                public void windowGainedFocus(WindowEvent e) {
                    getContentPane().requestFocusInWindow();
                }
            });
        }
    }
    
}
