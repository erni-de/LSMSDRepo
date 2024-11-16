/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package it.unipi.lsmdproject;

import java.util.List;
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
public class CurveTest {
    
    public CurveTest() {
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

    /**
     * Test of setCoefficients method, of class Curve.
     */
    @Test
    public void testSetCoefficients() {
        System.out.println("setCoefficients");
        List<Coordinates> points;
        points = new Stack<>();
        points.add(new Coordinates(40.7896,11.92834));
        points.add(new Coordinates(41.785445,13.92834));
        points.add(new Coordinates(46.7896,11.42834));
        Curve instance = new Curve();
        instance.setCoefficients(points);
        System.out.println(instance.toString());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
