package com.safrr.shape.repository.impl;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.exception.ConeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolumeSpecification {
    private final static Logger logger = LogManager.getLogger();
    private double minVolume;
    private double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Cone cone) {
        CalculationService service = new CalculationServiceImpl();
        double volume = 0;
        try {
            volume = service.calculateVolume(cone);
        } catch (ConeException e) {
            logger.warn("Exception cannot be generated here");
        }
        boolean result = volume >= minVolume && volume <= maxVolume;
        return result;
    }
}
