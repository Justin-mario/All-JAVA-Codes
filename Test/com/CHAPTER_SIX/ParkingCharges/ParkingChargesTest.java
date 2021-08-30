package com.CHAPTER_SIX.ParkingCharges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class ParkingChargesTest {

    @Test
    @DisplayName ( "Display Menu Options" )
        void CheckMenuOptionIsDisplayed(){
        assertSame (  """
                PARKING HOURS WITH CHARGES
                
                1 --> 3 Hours Or Less ----------------------  $2.00
                2 --> For Extra Hour Above 3 Hours ---------- $0.50
                3 --> 24 hours ------------------------------ $10.00
                4 --> Get Yesterday Charges And Exit
                
                NO SERVICES ABOVE 24 HOUrs.""",ParkingCharges.displayOptionMenu () );
    }
    @Test
    @DisplayName ( "Check User Can Pay Charges For Between 1 And 3" )
        void checkUserCanPayChargesForBetween_1_and_3_hours(){
        assertEquals(2.0,ParkingCharges.getChargesFor3HoursAndLess(3));
        assertEquals(2.0,ParkingCharges.getChargesFor3HoursAndLess(2));
    }


    @Test
    @DisplayName ( "Check User Can not be charged for Zero hour" )
    void checkUserCannotBeChargedForZeroHour(){
    assertEquals(0,ParkingCharges.getChargesFor3HoursAndLess(0));
    }

    @Test
    @DisplayName ( "Check User Can not be Charged More Than Should be For 3 hours or less of Parked space" )
    void checkUserCannotBeChargedMoreThanFor_3_hoursOrLessOfUsedServices(){
        assertEquals(0.0,ParkingCharges.getChargesFor3HoursAndLess(4));
    }
    @Test
    @DisplayName ( "Check User Can pay charges for services above 3 hours" )
    void checkUserCanPayForServicesAbove_3_hours(){
        assertEquals(2.5,ParkingCharges.getChargesForAbove3Hours(4));
        assertEquals(12.0,ParkingCharges.getChargesForAbove3Hours(23));
    }

    @Test
    @DisplayName ( "Check User Can pay charges for 24 hours services " )
    void checkUserCanPayForServices_24_hoursServices(){
        assertEquals(10,ParkingCharges.getChargesFor24Hours(24));
    }
}
