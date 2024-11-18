/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.unipi.lsmdproject;

import it.unipi.lsmdproject.Nominatim.NominatimUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.*;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author erni
 */
public class LSMDProject {

    public static void main(String[] args) throws MalformedURLException, IOException, IOException {
        System.out.println("Prima della staampa");
        System.out.println(NominatimUtils.getFirstDocument("Viareggio").getCoordinates());
        System.out.println("Dopo la staampa");
    }
}
