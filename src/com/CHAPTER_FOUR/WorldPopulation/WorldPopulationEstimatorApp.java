package com.CHAPTER_FOUR.WorldPopulation;

public class WorldPopulationEstimatorApp {
    public static void main(String[] args) {

     double currentPopulation =  WorldPopulationEstimator.getCurrentWorldPopulation ();
       double estimatedPopulation =  WorldPopulationEstimator.getEstimatedGrowth ();
       int yearPopulationDoubled =  WorldPopulationEstimator.getYearPopulationDoubled ();

        System.out.println ("\nCurrent World Population Is\t " + currentPopulation + "\n");
        System.out.println ("Estimated World Population after 75 Years \t" + estimatedPopulation + "\n");
        System.out.println ("Year Current World Population Doubled Is \t" + yearPopulationDoubled + "\n");

    }
}
