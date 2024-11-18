/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject.GeneratingData;

/**
 *
 * @author nicol
 */
public class ItalianCity {
    //Campi che c'interessano che leggo dal file delle città italiane
    private String name;
    private double latitude;
    private double longitude;
 
    public ItalianCity(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getName(){
        return name;
    }
    
    public double getLatitude(){
        return latitude;
    }
    
    public double getLongitude(){
        return longitude;
    }
}
