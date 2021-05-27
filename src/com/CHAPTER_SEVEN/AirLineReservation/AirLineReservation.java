package com.CHAPTER_SEVEN.AirLineReservation;

import java.util.Arrays;

public class AirLineReservation {

    private final boolean[] airlineSeat = new boolean[10];
    private int firstClassSeatReserved = 0;
    private int secondClassSeatReserved = 0;
    public  int getTotalSeatNumber() {
        return airlineSeat.length;
    }

    public int bookSeat(int planeClass) {
        switch (planeClass) {
            case 1 -> {
                if (firstClassSeatReserved >= 5 ){
                    System.out.println ("Sorry First Class Is Fully Booked.....Would You Like To Book Economy Class?"
                            + " Press 2 to Booked Economy Press 3 To Exit");
                    if (firstClassSeatReserved ==5 && secondClassSeatReserved == 5){
                        System.out.println ("Sorry Seats Are Fully Booked Next Flight Leaves In 3 Hours");
                        System.exit ( 1 );
                    }}

                else if (firstClassSeatReserved < 5){
                        airlineSeat[firstClassSeatReserved++] = true;
                    System.out.println ("Seat No: "+ firstClassSeatReserved + "\t Booked On First Class");
                    System.out.print ("Please Type 1 for First Class And 2 For Economy Class....");
                    return firstClassSeatReserved;}
                else return 5;
            }
            case 2 -> {
                if (secondClassSeatReserved >= 5 ){
                    System.out.println ("Sorry Economy Class Is Fully Booked.....Would You Like To Book First Class?"
                            + " Press 1 to Booked First Class Press 3 To Exit");
                    if (firstClassSeatReserved ==5 && secondClassSeatReserved == 5){
                        System.out.println ("Sorry Seats Are Fully Booked Next Flight Leaves In 3 Hours");
                        System.exit ( 1 );
                        }
                }
                else if (secondClassSeatReserved < 5){
                    airlineSeat[5+secondClassSeatReserved++] = true;
                    System.out.println ("Seat No: " +secondClassSeatReserved + "\tBooked On Second Class");
                    System.out.print ("Please Type 1 for First Class And 2 For Economy Class....");

                return secondClassSeatReserved;}
                else return 5;
            }
            case 3 ->{
                System.out.println ("Next Flight Leaves In 3 Hours");
                System.exit ( 1 );
            }
            default -> throw new AirPlaneClassOutOfBoundException ( );
        }

        return planeClass;
    }

    @Override
    public String toString() {
        return Arrays.toString ( airlineSeat );
    }
}
