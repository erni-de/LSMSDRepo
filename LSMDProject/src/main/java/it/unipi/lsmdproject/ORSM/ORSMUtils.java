/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject.ORSM;

import com.google.gson.Gson;
import it.unipi.lsmdproject.Geometry.Coordinates;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author erni
 */
public class ORSMUtils {
    /**
     * Requests routing through the given waypoints.
     * @param waypoints waypoints to pass to the method
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException 
     */
    public static void getDocuments(List<Coordinates> waypoints) throws MalformedURLException, ProtocolException, IOException{
        //String url_string = "https://router.project-osrm.org/route/v1/driving/43.72319,10.400153;43.723083,10.402886?geometries=geojson";
        String url_string = "https://router.project-osrm.org/route/v1/driving/";
        for (Coordinates coords : waypoints){
            url_string = url_string + coords.getLongitude() + "," + coords.getLatitude() + ";";
        }
        url_string = url_string.substring(0, url_string.length() - 1);
        url_string = url_string + "?geometries=geojson&overview=full&steps=false";
        URL url = new URL(url_string);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        System.out.println(in.readLine());
    }
    
    /**
     * Requests routing through given waypoints.
     * @param waypoints waypoints to pass to the method
     * @param full_overview if true we get full overview.
     * @param steps if true we get itinerary istruction (i.e. roads routing passes through).
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException 
     */
    public static void getDocuments(List<Coordinates> waypoints, boolean full_overview, boolean steps) throws MalformedURLException, ProtocolException, IOException{
        //String url_string = "https://router.project-osrm.org/route/v1/driving/43.72319,10.400153;43.723083,10.402886?geometries=geojson";
        String url_string = "https://router.project-osrm.org/route/v1/driving/";
        for (Coordinates coords : waypoints){
            url_string = url_string + coords.getLongitude() + "," + coords.getLatitude() + ";";
        }
        url_string = url_string.substring(0, url_string.length() - 1);
        url_string = url_string + "?geometries=geojson";
        if (full_overview){
            url_string = url_string + "&overview=full";
        }
        if (steps){
            url_string = url_string + "&steps=true";
        }
        URL url = new URL(url_string);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        Gson gson = new Gson();
        Response response = gson.fromJson(in.readLine(), Response.class);
        System.out.println(response.getRoutes().get(0).getDistance());
    }
    
    
    
    
    
}
