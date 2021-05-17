package com.CHAPTER_SIX.DistanceBetweenPoint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceBetweenPointsEstimatorTest {
    @Test
    @DisplayName ( "Check Distance Between Two Points Can Be Calculated" )
        void checkDistanceBetweenTwoPointsCanBeObtained(){
        assertEquals (10.954451150103322,DistanceBetweenPointsEstimator.getDistance(100,200,50,130));
    }
}