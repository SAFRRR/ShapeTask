package com.safrr.shape.entity;

import com.safrr.shape.exception.ConeException;
import com.safrr.shape.observer.ConeEvent;
import com.safrr.shape.observer.Observable;
import com.safrr.shape.observer.Observer;
import com.safrr.shape.util.IdGenerator;
import com.safrr.shape.validator.ConeParamsValidator;

import java.util.ArrayList;
import java.util.Comparator;



public class Cone implements Cloneable, Observable {
    private final long coneId;
    private Point center;
    private double radius;
    private double height;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Cone(Point center, double radius, double height) throws ConeException {
        super();
        if (center == null){
            throw new ConeException("Attempt to create ellipse from null point");
        }
        this.coneId = IdGenerator.generateId();
        this.center = center;
        this.radius = radius;
        this.height = height;
    }

    public long getConeId() {
        return coneId;
    }

    public Point getCenter() {
        return center.clone();
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObservers();
    }

    public double getRadius() {
        return radius.clone;
    }

    public void setRadius(double radius) throws ConeException {
        if (!ConeParamsValidator.isRadiusValid(radius)) {
            throw new ConeException("Radius cannot be null");
        }
        this.radius = radius;
        notifyObservers();
    }

    public double getHeight() {
        return height.clone;
    }

    public void setHeight(double height) throws ConeException {
        if (!ConeParamsValidator.isHeightValid(radius)) {
            throw new ConeException("Height cannot be null");
        }
        this.height = height;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        ConeEvent event = new ConeEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.updateArea(event);
                observer.updateVolume(event);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cone that = (Cone) o;
        return Double.compare(that.radius, radius) == 0 &&
                Double.compare(that.height, height) == 0 &&
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        int result = center == null ? 0 : center.hashCode();
        result = 31 * result + (int) radius;
        result = 31 * result + (int) height;
        return result;
    }

    @Override
    public Cone clone() {
        Cone cone = null;
        try {
            cone = (Cone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cone;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("Cone{");
        builder.append("coneId = ").append(this.getId());
        builder.append("center = ").append(center);
        builder.append(", radius = ").append(radius);
        builder.append(", height = ").append(height);
        return sb.toString();
    }

    public static class HeightComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getHeight(), o2.getHeight());
        }
    }

    public static class RadiusComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
    }

    public static class XPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
        }
    }

    public static class YPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getY(), o2.getCenter().getY());
        }
    }

    public static class ZPointComparator implements Comparator<Cone> {
        @Override
        public int compare(Cone o1, Cone o2) {
            return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
        }
    }
}
