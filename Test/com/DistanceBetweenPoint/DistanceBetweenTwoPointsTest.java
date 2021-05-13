package com.DistanceBetweenPoint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceBetweenTwoPointsTest {
    @Test
    @DisplayName ( "Test Distance Between Two Points" )
        void checkDistanceBetweenTwoPointsCanBeComputed(){
        DistanceBetweenTwoPoints distance = new DistanceBetweenTwoPoints();
        distance.getDistanceBetweenTwoPoints();
    }
}
