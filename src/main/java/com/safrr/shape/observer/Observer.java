package com.safrr.shape.observer;

public interface Observer {
    void updateArea(ConeEvent coneEvent);
    void updateVolume(ConeEvent coneEvent);
}
