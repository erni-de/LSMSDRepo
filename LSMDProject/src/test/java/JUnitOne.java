/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import it.unipi.lsmdproject.Nominatim.NominatimDocument;
import it.unipi.lsmdproject.Nominatim.NominatimUtils;
import java.io.IOException;
import java.net.MalformedURLException;
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
        NominatimDocument nd = NominatimUtils.getFirstDocument("Vezzano");
        System.out.println(nd.getCoordinates());
        System.out.println(nd.getDisplay_name());
    }
    
}
