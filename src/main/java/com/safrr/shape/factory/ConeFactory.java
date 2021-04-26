package com.safrr.shape.factory;

import com.safrr.shape.entity.Cone;
import com.safrr.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.safrr.shape.exception.ConeException;

public class ConeFactory {
    private final static Logger logger = LogManager.getLogger();

    public static Cone getConeFromFactory(Point point, double radius, double height) throws ConeException {
        validateData(radius, height);
        Cone cone = new Cone(point, radius, height);
        return cone;
    }

    public static Cone getConeFromFactory(double x, double y, double z, double radius, double height) throws ConeException {
        validateData(radius, height);
        Point point = new Point(x, y, z);
        Cone cone = new Cone(point, radius, height);
        return cone;
    }

    public static Cone getConeFromFactory(double[] array) throws ConeException {
        if (array.length != 5) {
            logger.error("Wrong array size in factory", array.length);
            throw new ConeException("Wrong array size " + array.length);
        }
        double radius = array[3];
        double height = array[4];
        validateData(radius, height);
        Point point = new Point(array[0], array[1], array[2]);
        Cone cone = new Cone(point, radius, height);
        return cone;
    }

    private static void validateData(double radius, double height) throws ConeException {
        if (!ConeDataValidator.isRadiusValid(radius)
                || !ConeDataValidator.isHeightValid(height)) {
            logger.error("Radius or height is invalid");
            throw new ConeException("Radius or height is invalid: " + radius + " or " + height);
        }
    }
}
