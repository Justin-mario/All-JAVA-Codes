package com.CHAPTER_SIX.ParkingCharges;

import java.util.Scanner;

public class ParkingChargesApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        int hoursParked = 0;
        double chargesForBelow_3_hours = 0;
        double chargesForAbove_3_hours = 0;
        double chargesFor_24_hours = 0;
        int counter = 0;


        while (hoursParked != -1) {
            System.out.println ( "\n" + ParkingCharges.displayOptionMenu () );
            System.out.print ("\nchoose Service And Payment Option  ");
            hoursParked = input.nextInt ();
            switch (hoursParked) {
                case 1 -> {
                    System.out.print ( "\nEnter Hours Vehicle Was Parked " );
                    hoursParked = input.nextInt ();
                    chargesForBelow_3_hours = ParkingCharges.getChargesFor3HoursAndLess ( hoursParked );
                    counter++;
                    if(counter > 1){
                    chargesForBelow_3_hours += chargesForBelow_3_hours;}
                    System.out.println (counter);

                }
                case 2 -> {
                    System.out.print ( "\nEnter Hours Vehicle Was Parked " );
                    hoursParked = input.nextInt ();
                    chargesForAbove_3_hours = ParkingCharges.getChargesForAbove3Hours ( hoursParked );
                    counter++;
                    if(counter > 1){
                   chargesForAbove_3_hours += chargesForAbove_3_hours;}
                }
                case 3 -> {
                    System.out.print ( "\nEnter Hours Vehicle Was Parked " );
                    hoursParked = input.nextInt ();
                    chargesFor_24_hours = ParkingCharges.getChargesFor24Hours ( hoursParked );
                    counter++;
                    if(counter > 1){
                    chargesFor_24_hours += chargesFor_24_hours;}
                }
                case 4 ->{
                    double totalCharges = chargesForBelow_3_hours + chargesForAbove_3_hours + chargesFor_24_hours;
                    System.out.println ( "Total Charge Is " + totalCharges );
                    System.out.println ("Total Number Of Customers " + counter);
                    System.out.println ("Thanks For Patronage");
                    System.exit ( 1 );
                }
                default ->
                    System.out.println ( "Option Does Not Exist" );
                }

            }
        }
    }

