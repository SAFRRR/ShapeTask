package com.safrr.shape.observer;

import com.safrr.shape.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {
    public class ConeEvent(Cone source){
        super(source);
    }
    @Override
    public Cone getSource() {
        return (Cone) super.getSource();
    }
}

