package com.CHAPTER_FOUR.WorldPopulation;

public class WorldPopulationEstimator {
    static double currentWorldPopulation = 7874765825.0;
     static double estimatedPopulation = 0;
    static double estimatedGrowthRate = 0.018;


    public static double getCurrentWorldPopulation() {
        return currentWorldPopulation;
    }

        public  static double getEstimatedGrowth () {

            for (int year = 1; year <= 75; year++){
            estimatedPopulation = currentWorldPopulation * Math.pow ( 1 + estimatedGrowthRate, year );

            }
            return estimatedPopulation;
        }


    public static int getYearPopulationDoubled() {
        int year = 1;
        for (; year <= 75; year++) {
            estimatedPopulation = currentWorldPopulation * Math.pow ( 1 + estimatedGrowthRate, year );
            if (estimatedPopulation >= (7874765825.0 * 2)){
                return year;
            }
        }
        return year;

    }
}
