package it.unipi.lsmdproject.Geometry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author erni
 */
import it.unipi.lsmdproject.Geometry.Coordinates;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Curve{
    /*
    Curve class represents an equation of the form
    y = b0 + b1 * x + b2 * x^2 + b3 * x^3 +...
    with polinamial grade equal to [no. of coefficients - 1]
    */
    PolynomialFunction pf;

    public Curve(double[] coefficients) {
        pf = new PolynomialFunction(coefficients);
    }

    public Curve() {
    }
    
    public void estimateCoefficients(List<Coordinates> points, int degree){
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(degree);
        pf = new PolynomialFunction(fitter.fit(Coordinates.toWeightedObservedPoints(points).toList()));  
    }
    
    public void estimateCoefficients(List<Coordinates> points, int degree, boolean verbose){
        System.out.println("Called estimateCoefficients");
        System.out.println("    Estimating Coefficients of Curve object : " + this.toString() + " ...");
        System.out.println("    Input points : " + points.toString());
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(degree);
        pf = new PolynomialFunction(fitter.fit(Coordinates.toWeightedObservedPoints(points).toList()));  
        if (verbose) {
            System.out.println("    Estimated Coefficients : " + Arrays.toString(pf.getCoefficients()));
        }
    }
    
    public double useCurve(double x){
        return pf.value(x);
    }
}