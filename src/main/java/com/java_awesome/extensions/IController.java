package com.java_awesome.extensions;

public interface IController <V extends IView> {
    public V getView();
}
