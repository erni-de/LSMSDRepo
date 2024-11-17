package it.unipi.lsmdproject.Geometry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author erni
 */

import java.util.List;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class Coordinates {
    private double longitude;
    private double latitude;

    public Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" + "longitude=" + longitude + ", latitude=" + latitude + '}';
    }
    
    public static WeightedObservedPoints toWeightedObservedPoints(List<Coordinates> list){
        WeightedObservedPoints wop = new WeightedObservedPoints();
        for(Coordinates element : list){
            wop.add(element.getLongitude(), element.getLatitude());
        }
        return wop;
    }
        
}
