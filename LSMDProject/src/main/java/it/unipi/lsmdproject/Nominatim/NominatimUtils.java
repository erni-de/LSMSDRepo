/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject.Nominatim;

import it.unipi.lsmdproject.Nominatim.NominatimDocument;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author erni
 */
public class NominatimUtils {

    /**
        Requests all documents given a address name.
    */
    public static List<NominatimDocument> getDocuments(String address) throws ProtocolException, MalformedURLException, IOException {
        
        address = address.replace(" ", "_");
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + address + "&format=json");
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        String[] array = in.readLine().replace("[{", "{").replace("}]", "}").replace("},{", "}},{{").split("\\},\\{");
        
        Gson gson = new Gson();
        List<NominatimDocument> ns = new Stack<>();
        for (String element : array){
            ns.add(gson.fromJson(element, NominatimDocument.class));
        }
        return ns;
    }
    
    /**
        Requests the top n documents given an address name.
    */
    public static List<NominatimDocument> getDocuments(String address, int n) throws ProtocolException, MalformedURLException, IOException {
        address = address.replace(" ", "_");
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + address + "&format=json&limit=" + n);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        String[] array = in.readLine().replace("[{", "{").replace("}]", "}").replace("},{", "}},{{").split("\\},\\{");
        
        Gson gson = new Gson();
        List<NominatimDocument> ns = new Stack<>();
        
        for (String element : array){
            ns.add(gson.fromJson(element, NominatimDocument.class));
        }
        return ns;
    }
    
    /**
        Requests only the most relevant document given an address name.
    */
    public static NominatimDocument getFirstDocument(String address) throws ProtocolException, MalformedURLException, IOException {
        address = address.replace(" ", "_");
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + address + "&format=json&limit=1");
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
        Gson gson = new Gson();
        String s = in.readLine().replace("[{", "{").replace("}]", "}");
        
        return gson.fromJson(s, NominatimDocument.class);
    }
}
