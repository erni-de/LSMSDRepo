/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.lsmdproject;

/**
 *
 * @author erni
 */
public class CoordinatesSquare{
        private Coordinates central_coordinates;
        private double side_size;
        public double[] x_edges = new double[2];
        public double[] y_edges = new double[2];

        public CoordinatesSquare(Coordinates central_coordinates, double side_size) {
            this.central_coordinates = central_coordinates;
            this.side_size = side_size;
            x_edges[0] = central_coordinates.getLongitude() - side_size/2;
            x_edges[1] = central_coordinates.getLongitude() + side_size/2;
            y_edges[0] = central_coordinates.getLatitude() - side_size/2;
            y_edges[1] = central_coordinates.getLatitude() + side_size/2;
        }

        public void setCentral_coordinates(Coordinates central_coordinates) {
            this.central_coordinates = central_coordinates;
        }

        public void setSide_size(double side_size) {
            this.side_size = side_size;
        }

        public Coordinates getCentral_coordinates() {
            return central_coordinates;
        }

        public double getSide_size() {
            return side_size;
        }
        
        public boolean getXCondition(double x_value){
            return x_value >= x_edges[0] && x_value <= x_edges[1];
        }
        
        public boolean getYCondition(double y_value){
            return y_value >= y_edges[0] && y_value <= y_edges[1];
        }       
        
        public double[] getSplittedXRange(int n_points){
            double[] ret = new double[n_points];
            double step = side_size/n_points;
            for (int i = 0; i < n_points; i++){
                ret[i] = x_edges[0] + step * i;
            }
            return ret;
        }
    }
