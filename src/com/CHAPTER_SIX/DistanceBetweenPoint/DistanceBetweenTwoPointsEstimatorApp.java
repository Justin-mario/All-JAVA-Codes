package com.CHAPTER_SIX.DistanceBetweenPoint;

import java.util.Scanner;

public class DistanceBetweenTwoPointsEstimatorApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("Input the point X1...");
        double pointX1 = input.nextDouble ();
        System.out.print ("Input the point Y1...");
        double pointY1 = input.nextDouble ();
        System.out.print ("Input the point X2...");
        double pointX2 = input.nextDouble ();
        System.out.print ("Input the point Y2...");
        double pointY2 = input.nextDouble ();

        DistanceBetweenPointsEstimator.getDistance ( pointX1, pointY1, pointX2, pointY2 );
    }
}
