package com.safrr.shape.service;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.entity.Point;
import com.safrr.shape.exception.ConeException;

public interface CalculationService {
    double calculateSurfaceArea(Cone cone) throws ConeException;
    double calculateVolume(Cone cone) throws ConeException;
    double calculateVolumeRatio(Cone cone, double z) throws ConeException;
    boolean isCustomCone(Point center, double radius, double height);
    boolean isOnCoordinatePlane(Cone cone) throws ConeException;
}
