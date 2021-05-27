package com.CHAPTER_SEVEN.AirlineReservationTest;

import com.CHAPTER_SEVEN.AirLineReservation.AirLineReservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirLineReservationTest {
    AirLineReservation seatReservation;
    @BeforeEach
        void beforeEachTest(){
        seatReservation = new AirLineReservation ();
    }
    @Test
    @DisplayName ( "Test Airline has Ten Empty Seat")
        void checkAirPlaneHasTenSeats(){
        assertEquals(10,seatReservation.getTotalSeatNumber());
    }
    @Test
    @DisplayName ( "Test Seat Can Be Assigned To First Class Passenger")
    void checkSeatsCanBeAssignedToFirstClassPassenger(){
            seatReservation.bookSeat (1);
            seatReservation.bookSeat (1);
        assertEquals (3,seatReservation.bookSeat (1)); }

    @Test
    @DisplayName ( "Test Seat Can Be Assigned To Second Class Passenger" )
        void checkSeatCanBeAssignedToSecondClassPassenger(){
        assertEquals (1,seatReservation.bookSeat (2)); }

    @Test
    @DisplayName ( "Test more tan 5 seats can not be assigned to first class passenger" )
    void checkSeatAssignedToFirstClassPassengerCannotBeMoreThanFive(){
        seatReservation.bookSeat (1);
        seatReservation.bookSeat (1);
        seatReservation.bookSeat (1);
        seatReservation.bookSeat (1);
        seatReservation.bookSeat (1);
        assertEquals (  5, seatReservation.bookSeat (1));
    }

    @Test
    @DisplayName ( "Test Second Class Can Not Take More Than Five Seats" )
    void checkSeatBookedToSecondClassPassengerCannotBeMoreThanFive(){
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);
        seatReservation.bookSeat (2);

        assertEquals (  5, seatReservation.bookSeat (2));
    }
    @AfterEach
    void afterEachTest(){
        seatReservation = null;
    }
}
