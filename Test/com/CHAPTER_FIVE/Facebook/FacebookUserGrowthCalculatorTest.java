package com.CHAPTER_FIVE.Facebook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacebookUserGrowthCalculatorTest {
    @Test
    @DisplayName("Check facebook current user base")
    void checkFacebookCurrentNumberOfUsers() {
        FacebookUserGrowthCalculator facebook = new FacebookUserGrowthCalculator ();
        assertEquals ( 1_000_000_000, facebook.getCurrentUser () );
    }

    @Test
    @DisplayName("Check how many months it took facebook to grow to 1_500_000_000 users  ")
    void checkHowLongItTookFaceBookToGrowToTargetRate() {
        FacebookUserGrowthCalculator facebook = new FacebookUserGrowthCalculator ();
        assertEquals ( 11, facebook.getMonthsItTookToGrowToTargetNumber () );

    }

    @Test
    @DisplayName("Check how many months it took facebook to grow to 2_000_000_000 users  ")
    void checkHowLongItTookFacebookToDoubleTheirUserBase() {
        FacebookUserGrowthCalculator facebook = new FacebookUserGrowthCalculator ();
        assertEquals ( 18, facebook.getMonthsItTookToGrowTo2Billion () );
    }
}