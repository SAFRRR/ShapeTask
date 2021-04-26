package com.safrr.shape.validator;

public class ConeParamsValidator {
    public static boolean isRadiusValid(double radius) {
        return radius > 0;
    }

    public static boolean isHeightValid(double height) {
        return height > 0;
    }
}
