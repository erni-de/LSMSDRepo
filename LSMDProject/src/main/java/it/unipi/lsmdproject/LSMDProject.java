/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.unipi.lsmdproject;

import java.time.*;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author erni
 */
public class LSMDProject {

    public static void main(String[] args) {
        double[] coefs = new double[]{0,1.3255};
        Curve curve = new Curve();
        Stack<Coordinates> coords = new Stack<>();
        coords.add(new Coordinates(23.152,34.5));
        coords.add(new Coordinates(23.552,33.5));
        curve.estimateCoefficients(coords, 2, true);
        CoordinatesSquare sq = new CoordinatesSquare(new Coordinates(23.352,34), 1);
        ItineraryUtils.isCurveInSquare(sq ,curve, 100, true);
    }
}
