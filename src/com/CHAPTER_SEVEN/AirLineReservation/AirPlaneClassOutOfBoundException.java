package com.CHAPTER_SEVEN.AirLineReservation;

public class AirPlaneClassOutOfBoundException extends ArrayIndexOutOfBoundsException{
    String message = "Class Does Not Exist";

    @Override
    public String getMessage() {
        return message;
    }
}
