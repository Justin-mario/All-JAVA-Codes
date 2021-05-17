package com.CHAPTER_SIX.DistanceBetweenPoint;

public class DistanceBetweenPointsEstimator {

    public static double getDistance(double x1, double y1, double x2, double y2) {
        double distance = (x1 - x2) + (y1 - y2);
        double coordinateOfPoints = Math.sqrt ( distance );
        System.out.printf ("\nThe Coordinate of points %s%.1f%s%.1f%s%.1f%s%.1f%s%.2f ", "(", x1,  " - ", y1, ") and (", x2, " - ", y2, ") is ", coordinateOfPoints);
        return coordinateOfPoints;
    }
}
