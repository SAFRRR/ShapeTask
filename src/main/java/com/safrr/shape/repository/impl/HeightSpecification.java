package com.safrr.shape.repository.impl;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.repository.Specification;

public class HeightSpecification implements Specification {

    private double maxHeight;

    public HeightSpecification(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Cone cone) {
        boolean result = cone.getHeight() <= maxHeight;
        return result;
    }
}