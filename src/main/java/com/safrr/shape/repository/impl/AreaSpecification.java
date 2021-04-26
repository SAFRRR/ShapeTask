package com.safrr.shape.repository.impl;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification {
    private final static Logger logger = LogManager.getLogger();
    double minArea;
    double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationService service = new CalculationServiceImpl();
        double area = 0;
        try {
            area = service.calculateSurfaceArea(cone);
        } catch (ConeException e) {
            logger.info("exception cannot be generated here");
        }
        boolean result = area >= minArea && area <= maxArea;
        return result;
    }
}
