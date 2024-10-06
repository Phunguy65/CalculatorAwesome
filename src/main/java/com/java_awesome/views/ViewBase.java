package com.java_awesome.views;

import com.java_awesome.extensions.IView;

import javax.swing.*;

public abstract class ViewBase extends JPanel implements IView {
    
    @Override
    public JComponent getView() {
        return this;
    }
    
}
