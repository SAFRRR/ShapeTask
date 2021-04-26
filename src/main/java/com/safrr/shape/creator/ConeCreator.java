package com.safrr.shape.creator;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.entity.ConeParameters;
import com.safrr.shape.entity.Point;
import com.safrr.shape.entity.Warehouse;
import com.safrr.shape.exception.ConeException;
import com.safrr.shape.factory.ConeFactory;
import com.safrr.shape.repository.Repository;
import com.safrr.shape.service.CalculationService;
import com.safrr.shape.service.impl.CalculationServiceImpl;

public class ConeCreator {

    public void fillRepositoryWithCone(Point point, double radius, double height) throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(point, radius, height);
        createWarehouse(cone);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    public void fillRepositoryWithCone(double[] array) throws ConeException {
        Cone cone = ConeFactory.getConeFromFactory(array);
        createWarehouse(cone);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    private void createWarehouse(Cone cone) throws ConeException {
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        CalculationService service = new CalculationServiceImpl();
        double area = ((CalculationServiceImpl) service).calculateArea(cone);
        double volume = service.calculateVolume(cone);
        ConeParameters coneParameters = new ConeParameters();
        coneParameters.setArea(area);
        coneParameters.setVolume(volume);
        warehouse.put(id, coneParameters);
    }
}