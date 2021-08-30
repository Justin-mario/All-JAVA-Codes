package com.ClassWork;

public class SevenSegmentDisplayApp {
    public static void main(String[] args) {

        SevenSegmentDisplay segmentDisplay = new SevenSegmentDisplay ();
        String userInput = "7";

        try {
            segmentDisplay.setUp ( userInput );
        }
        catch (IndexOutOfBoundsException e){
            System.out.println ("Length Of Input Must Not Be More Than Eight");
        }
        catch (IllegalArgumentException e){
            System.out.println ("Value Of Input Must Be 0 or 1");
        }

        segmentDisplay.display (  );

       // segmentDisplay.convertBaseTenToBaseTwo ( "54" );
    }

}
