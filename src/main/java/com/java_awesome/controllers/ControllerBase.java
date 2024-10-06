package com.java_awesome.controllers;

import com.java_awesome.extensions.IController;
import com.java_awesome.extensions.IView;

public abstract class ControllerBase<V extends IView> implements IController<V> {
    private V view;

    protected ControllerBase(V view) {
        this.view = view;
    }

    @Override
    public V getView() {
        return view;
    }
}
