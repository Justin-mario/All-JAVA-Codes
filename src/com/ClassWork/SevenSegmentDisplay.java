package com.ClassWork;

public class SevenSegmentDisplay {

    private int[][] sevenSegmentArray = new int[5][4];

    public void display() {
        for (int[] rows : sevenSegmentArray) {
            for (int column : rows) {
                if (column == 1)
                    System.out.print ( '#' + "  " );
                if (column == 0)
                    System.out.print ( "   " );
            }
            System.out.println ();
            System.out.println ();
        }
    }

    public void writeOnA() {
        for (int column = 0; column < 4; column++)
            sevenSegmentArray[0][column] = 1;
    }

    public void writeOnB() {
        for (int row = 0; row < 3; row++)
            sevenSegmentArray[row][3] = 1;
    }

    public void writeOnC() {
        for (int row = 2; row < 5; row++)
            sevenSegmentArray[row][3] = 1;
    }

    public void writeOnD() {
        for (int column = 3; column >= 0; column--)
            sevenSegmentArray[4][column] = 1;
    }

    public void writeOnE() {
        for (int row = 4; row >= 2; row--)
            sevenSegmentArray[row][0] = 1;
    }

    public void writeOnF() {
        for (int row = 0; row < 3; row++)
            sevenSegmentArray[row][0] = 1;
    }

    public void writeOnG() {
        for (int column = 0; column < 3; column++)
            sevenSegmentArray[2][column] = 1;
    }

    public void setUp(String userInput) {
        userInput = convertBaseTenToBaseTwo ( userInput );
        for (int i = 0; i < userInput.length (); i++) {
            while(userInput.length () < 8){
                userInput = "0" + userInput ;
            }
            validateInput ( userInput );
            if (userInput.charAt ( 7 ) == '0')
                userInput = " ";

            if (userInput.charAt ( i ) == '1') {
                switch (i) {
                    case 0 -> writeOnA ();
                    case 1 -> writeOnB ();
                    case 2 -> writeOnC ();
                    case 3 -> writeOnD ();
                    case 4 -> writeOnE ();
                    case 5 -> writeOnF ();
                    case 6 -> writeOnG ();
                }
                    }
                }
            }
            

    public void validateInput(String userInput) {
        for (int i = 0; i < userInput.length (); i++) {
            if (userInput.length () > 8){
                throw new IndexOutOfBoundsException();
            }
            if ( userInput.charAt ( i ) != '1' && userInput.charAt ( i ) != '0') {
                throw new IllegalArgumentException ();
            }
        }
    }

    public String convertBaseTenToBaseTwo(String userInput){
       int remainder;
       int quotient = Integer.parseInt ( userInput );
       String reverse = "";
       do{
           remainder = quotient % 2;
           quotient = quotient /2;
            reverse = remainder + reverse ;
       }while(quotient != 0);
        return reverse;


       // String answer = Integer.toBinaryString ( quotientDivision );
        //String answer = Integer.toString ( quotientDivision, 2 );

    }
}


