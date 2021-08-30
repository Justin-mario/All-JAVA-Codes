package com.CHAPTER_SEVEN.SalesCommissionTest;

import com.CHAPTER_SEVEN.SalesCommission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SalesCommissionTest {
    @Test
    @DisplayName( "Test That An Array of Length Eight Was Created" )
    void checkThatAnArrayOfLengthEightWasCreated(){
        Assertions.assertEquals ( 9, SalesCommission.getArrayLength());
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 200 and 299" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_200_and_299(){
        SalesCommission.getEarningRange (1000);

        assertEquals ( 2,SalesCommission.getEarningRange (1000));
    }
    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 300 and 399" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_300_and_399(){
        assertEquals ( 1,SalesCommission.getEarningRange (2000));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 400 and 499" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_400_and_499(){
        SalesCommission.getEarningRange (3000);
        SalesCommission.getEarningRange (3000);
        assertEquals ( 3,SalesCommission.getEarningRange (3000));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 500 and 599" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_500_and_599(){
        assertEquals ( 1,SalesCommission.getEarningRange (3800));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 600 and 699" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_600_and_699(){
        SalesCommission.getEarningRange (5300);
        SalesCommission.getEarningRange (5000);
        assertEquals ( 3,SalesCommission.getEarningRange (5200));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 700 and 799" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_700_and_799(){
        assertEquals ( 1,SalesCommission.getEarningRange (6350));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 800 and 899" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_800_and_899(){
        assertEquals ( 1,SalesCommission.getEarningRange (7550));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Between 900 and 999" )
    void checkThatArrayCounterIsIncrementedForEarningBetween_900_and_999(){
        assertEquals ( 1,SalesCommission.getEarningRange (8550));
    }

    @Test
    @DisplayName ( "Test That Array Counter Is Incremented For Earning Above" )
    void checkThatArrayCounterIsIncrementedForEarningAbove_1000(){
        assertEquals ( 1,SalesCommission.getEarningRange (10550));
    }
}