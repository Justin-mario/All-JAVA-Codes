package com.CHAPTER_FIVE.FairTax;

public class Taxation {
    static double taxRate = 0.23;
    public static double getTax(double expense) {
        if(expense > 0){
            double taxOnExpenses = expense * taxRate;
            return taxOnExpenses;}
        else {
            return 0.0;
        }
    }

    public static double getHousingTax(double expenses) {
         double housingTax = getTax ( expenses );
        return housingTax;
    }

    public static double getFoodTax( double expenses) {
        double foodTax = getTax ( expenses );
        return foodTax;
    }

    public static double getClothingTax(double expenses) {
        double clothingTax = getTax ( expenses );
        return clothingTax;
    }

    public static double getTransportTax(double expenses) {
        double transportTax = getTax ( expenses );
        return transportTax;
    }

    public static double getEducationTax(double expenses) {
        double educationTax = getTax ( expenses );
        return educationTax;
    }

    public static double getHealthCareTax(double expenses) {
        double healthCareTax = getTax ( expenses );
        return healthCareTax;
    }

    public static double getTaxOnVacation(double expenses) {
        double taxOnVacation = getTax ( expenses );
        return taxOnVacation;
    }


    public static String displayTaxCategories() {
        String prompt = """ 
                Input Expenses from These Categories 
                1 --> Housing.
                2 --> Food.
                3 --> Clothing.
                4 --> Transportation.
                5 --> Education.
                6 --> HealthCare.
                7 --> Vacation.
                8 --> Get Total Tax.
                9 --> Exit Menu""";
        return prompt;
    }
}
