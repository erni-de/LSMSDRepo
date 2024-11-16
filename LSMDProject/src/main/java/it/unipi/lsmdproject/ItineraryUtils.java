package it.unipi.lsmdproject;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author erni
 */
public class ItineraryUtils {
        
    public static boolean isCurveInSquare(CoordinatesSquare sq, Curve c, int n_points){
        double[] splittedXRange = sq.getSplittedXRange(n_points);
        for (double x : splittedXRange){
            if (sq.getYCondition(c.useCurve(x))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isCurveInSquare(CoordinatesSquare sq, Curve c, int n_points, boolean verbose){
        System.out.println("Called static method isCurveInSquare");
        System.out.println("    Comparing CoordinateSquare object : " + sq.toString() + " to Curve object c : " + c.toString());
        System.out.println("    Square Edges : ");
        System.out.println("        x = : " + Arrays.toString(sq.x_edges));
        System.out.println("        y = : " + Arrays.toString(sq.y_edges));
        System.out.println("    Curve Coefficients : ");
        System.out.println("        coefs = : " + Arrays.toString(c.pf.getCoefficients()));
        double[] splittedXRange = sq.getSplittedXRange(n_points);
        System.out.println("     Evaluating Curve : ");
        for (double x : splittedXRange){
            System.out.println("        eval x = " + x);
            if (sq.getYCondition(c.useCurve(x))) {
                System.out.println("    Return True");
                return true;
            }
        }
        System.out.println("    Return False");
        return false;
    }
    
}
