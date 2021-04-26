package com.safrr.shape.entity;

public class Point implements Cloneable{

    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + Double.hashCode(x);
        result = result * prime + Double.hashCode(y);
        result = result * prime + Double.hashCode(z);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0 && Double.compare(z, point.z) == 0;
    }

    @Override
    public Point clone() {
        Point point = null;
        try {
            point = (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return point;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("x = ").append(x);
        builder.append(", y = ").append(y);
        builder.append(", z = ").append(z);
        return builder.toString();
    }
}