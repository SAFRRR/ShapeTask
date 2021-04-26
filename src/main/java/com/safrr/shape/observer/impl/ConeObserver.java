package com.safrr.shape.observer.impl;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.entity.Warehouse;
import com.safrr.shape.exception.ConeException;
import com.safrr.shape.observer.ConeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.security.Policy;

public class ConeObserver {
    private final static Logger logger = LogManager.getLogger(ConeObserver.class);
    @Override
    public void updateArea(ConeEvent coneEvent) {
        Cone cone = coneEvent.getSource();
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        Policy.Parameters parameters = warehouse.get(id);
        CalculationService service = new CalculationServiceImpl();
        try {
            double surfaceArea = service.calculateArea(cone);
            parameters.setArea(surfaceArea);
        } catch (ConeException e) {
            logger.error("Exception in updateArea method");
        }
    }

    @Override
    public void updateVolume(ConeEvent coneEvent) {
        Cone cone = coneEvent.getSource();
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        ConeParameters parameters = warehouse.get(id);
        CalculationService service = new CalculationServiceImpl();
        try {
            double volume = service.calculateVolume(cone);
            parameters.setVolume(volume);
        } catch (ConeException e) {
            logger.error("Exception in updateVolume method");
        }
    }

}
