package com.safrr.shape.entity;

public class ConeParameters {

    private double area;
    private double volume;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConeParameters that = (ConeParameters) obj;

        return Double.compare(that.area, area) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(volume);
        result = result * prime + Double.hashCode(area);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("ConeParameters :");
        builder.append("area=").append(area);
        builder.append(", volume=").append(volume);
        return builder.toString();
    }
}