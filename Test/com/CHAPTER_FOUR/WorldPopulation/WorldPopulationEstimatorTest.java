package com.CHAPTER_FOUR.WorldPopulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class WorldPopulationEstimatorTest {
    WorldPopulationEstimator population;
    @BeforeEach
    void beforeEachTest(){
        population = new WorldPopulationEstimator ();
    }

    @Test
    @DisplayName ( "Check current world population in the year 2021" )
    void checkCurrentWorldPopulation(){
        double currentPopulation = population.getCurrentWorldPopulation();
        assertEquals(7874765825.0, currentPopulation);
    }

    @Test
    @DisplayName ( "Check world population after 75 years" )
    void checkWorldPopulationIncreased(){

        assertEquals ( 3.0013800945190346E10, population.getEstimatedGrowth() );
    }

    @Test
    @DisplayName ( "Check for the year the current world population doubles" )
        void checkTheYearCurrentWorldPopulationDoubles(){

        assertEquals ( 39, population.getYearPopulationDoubled()   );
    }


}
