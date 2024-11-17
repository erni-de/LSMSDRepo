/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import it.unipi.lsmdproject.Geometry.Coordinates;
import it.unipi.lsmdproject.Nominatim.NominatimDocument;
import it.unipi.lsmdproject.Nominatim.NominatimUtils;
import it.unipi.lsmdproject.ORSM.ORSMUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Stack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author erni
 */
public class JUnitOne {
    
    public JUnitOne() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testNominatimRequests() throws MalformedURLException, IOException{
        NominatimDocument nd = NominatimUtils.getDocuments("Santo Stefano di Magra Piazza Matteotti").get(0);
        System.out.println(nd.getCoordinates());
        System.out.println(nd.getDisplay_name());
        System.out.println(nd.addresstype);
        
    }
    
    @Test
    public void testORSMRequests() throws MalformedURLException, IOException {
        Stack<Coordinates> wp = new Stack<>();
        //Test route for itinerary going from Genova to Pisa passing from La Spezia
        wp.add(NominatimUtils.getFirstDocument("Genova Piazza Principe").getCoordinates());
        wp.add(NominatimUtils.getFirstDocument("Pisa").getCoordinates());
        ORSMUtils.getDocuments(wp, true, false);
    }
    
}
