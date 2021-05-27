package com.CHAPTER_SEVEN.AirLineReservation;

import java.util.Scanner;

public class AirlineReservationApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        AirLineReservation ticketReservation = new AirLineReservation ();

        System.out.print ("Please Type 1 for First Class And 2 For Economy Class....");
        int seatClass = input.nextInt ();
        while(seatClass != -1){
        ticketReservation.bookSeat ( seatClass );
        seatClass = input.nextInt ();}
    }
}
