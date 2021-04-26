package com.safrr.shape.repository.impl;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.repository.Specification;

public class RadiusSpecification implements Specification {
    double minRadius;
    double maxRadius;

    public RadiusSpecification(double minRadius, double maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Cone cone) {
        double radius = cone.getRadius();
        boolean result = radius >= minRadius && radius <= maxRadius;
        return result;
    }
}
