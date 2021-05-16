package com.CHAPTER_FIVE;

import com.CHAPTER_FIVE.FairTax.Taxation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxationTest {

    @Test
    @DisplayName ( "Display categories of Tax" )
    void checkUserCanAccessCategoriesOfTax(){
     assertSame ( """
                Input Expenses from These Categories
                1 --> Housing.
                2 --> Food.
                3 --> Clothing.
                4 --> Transportation.
                5 --> Education.
                6 --> HealthCare.
                7 --> Vacation.
                8 --> Get Total Tax.
                9 --> Exit Menu""", Taxation.displayTaxCategories () );
    }
    @Test
    @DisplayName("Check users can Pay 23% tax on Housing")
    void checkUsersCanPayHousingTax() {
        assertEquals ( 920, Taxation.getHousingTax ( 4000.0 ) );
    }

    @Test
    @DisplayName("Check users can Pay 23% tax on food purchases")
    void checkUsersCanPayFoodPurchasesTax() {
        assertEquals ( 218.5805, Taxation.getFoodTax ( 950.35 ) );
    }

    @Test
    @DisplayName("Check users can Pay 23% tax on clothing purchases")
    void checkUsersCanPayClothingPurchasesTax() {
        assertEquals ( 333.5, Taxation.getClothingTax ( 1450 ) );
    }

    @Test
    @DisplayName("Check users can Pay 23% tax on transportation")
    void checkUsersCanPayTransportationTax() {
        assertEquals ( 3450.0, Taxation.getTransportTax ( 15000 ) );
    }

    @Test
    @DisplayName("Check users can not input negative amount as expenses")
    void checkUsersCannotEnterNegativeValueAsExpenses() {
        assertEquals ( 0.0, Taxation.getTransportTax ( -15000 ) );
    }

    @Test
    @DisplayName("Check users can Pay 23% tax on education")
    void checkUsersCanPayEducationTax() {
        assertEquals ( 20700.0, Taxation.getEducationTax ( 90000 ) );
    }
    @Test
    @DisplayName("Check users can Pay 23% tax on healthcare")
    void checkUsersCanPayHealthCareTax() {
        assertEquals ( 1541.0, Taxation.getHealthCareTax ( 6700 ) );
    }

    @Test
    @DisplayName("Check users can Pay 23% tax on vacation")
    void checkUsersCanPayTaxOnVacation() {
        assertEquals ( 3450.0, Taxation.getTaxOnVacation ( 15000 ) );
    }
}