package com.CHAPTER_FIVE.FairTax;

import java.util.Scanner;

public class FairTaxApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        double userExpenses;
        double housingTax = 0, foodTax = 0, clothingTax = 0, transportationTax = 0, educationTax = 0,
                healthCareTax = 0, vacationTax = 0;
        double taxPayable = 0;
        int userInput = 0;


        while (userInput != -1) {

            System.out.println ( "\n" + Taxation.displayTaxCategories () + "\n" );
            System.out.print ( "Chose from Available Options: ");
            userInput = input.nextInt ();

            switch (userInput) {
                case 1 -> {
                    System.out.print ( "\nEnter Housing Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    housingTax = Taxation.getHousingTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Housing Expense Is $" + housingTax);
                }
                case 2 -> {
                    System.out.print ( "\nEnter Food Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    foodTax = Taxation.getFoodTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Food Expense Is $" + foodTax);
                }
                case 3 -> {
                    System.out.print ( "\nEnter Clothing Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    clothingTax = Taxation.getClothingTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Clothing Expense Is $" + clothingTax);
                }
                case 4 -> {
                    System.out.print ("\nEnter Transport Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    transportationTax = Taxation.getTransportTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Transport Expense Is $" + transportationTax);
                }
                case 5 -> {
                    System.out.print ("\nEnter Education Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    educationTax = Taxation.getEducationTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Education Expense Is $" + educationTax);
                }
                case 6 -> {
                    System.out.print ("\nEnter HealthCare Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    healthCareTax = Taxation.getHealthCareTax ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " HealthCare Expense Is $" + healthCareTax);
                }
                case 7 -> {
                    System.out.print ( "\nEnter Vacation Expenses To compute tax: " );
                    userExpenses = input.nextDouble ();
                    vacationTax = Taxation.getTaxOnVacation ( userExpenses );
                    System.out.println ("Tax On $" + userExpenses + " Vacation Expense Is $" + vacationTax);
                }
                case 8 -> {
                    taxPayable = housingTax + foodTax + clothingTax + transportationTax + educationTax +
                            healthCareTax + vacationTax;
                    if (taxPayable > 0) {
                        System.out.println ( "\nTotal Tax Is: $" + taxPayable );
                        System.out.println ( "\nThank You For Paying Your Tax" );
                    }
                    else {
                        System.out.println ( "\nNo Expenses To Compute Tax" );
                    }
                    System.out.print ("Input: 1 to Continue 2 To Exit.....");
                    userInput = input.nextInt ();
                    if (userInput == 2){
                        System.out.println ( "\nHave A Nice Day" );
                    System.exit ( 1 );}
                }


            case 9 -> {
                System.out.println ("Have A Nice Day!");
                System.exit ( 1 );
            }
            default -> System.out.println ( "Option Not Available On The Menu" );
        }


        }

    }
    }

