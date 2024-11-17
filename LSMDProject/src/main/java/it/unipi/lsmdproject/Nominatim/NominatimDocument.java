/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject.Nominatim;

import com.google.gson.annotations.SerializedName;
import it.unipi.lsmdproject.Geometry.Coordinates;
import java.io.Serializable;

/**
 *
 * @author erni
 */
public class NominatimDocument implements Serializable{
    /*
    Class to serialize JSON documents returned by HTTP requests to the Nominatim server
    Not all JSON fields are read in this class implementation
    We only retrieve
    */
    
    //public String place_id;
    //public String osm_type;
    //public long osm_id;
    public double lat;
    public double lon;
    //@SerializedName("class")
    //public String class_name;
    //public String type;
    //public long place_rank;
    //public double importance;
    //public String addresstype;
    public String name;
    public String display_name;
    //public String[] boundingbox;
    
    public Coordinates getCoordinates(){
        return new Coordinates(lon, lat);
    }
    
    public String getName(){
        return name;
    }

    public String getDisplay_name() {
        return display_name;
    }
    
    @Override
    public String toString() {
        return "NominatimDocument{" + "lat=" + lat + ", lon=" + lon + ", name=" + name + ", display_name=" + display_name + '}';
    }

    
    
    
    
    
}
