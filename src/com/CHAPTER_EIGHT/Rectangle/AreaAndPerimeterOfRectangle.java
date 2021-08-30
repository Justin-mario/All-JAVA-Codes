package com.CHAPTER_EIGHT.Rectangle;

import java.util.Scanner;

public class AreaAndPerimeterOfRectangle {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle ( 1.0, 1.0 );
        Scanner input = new Scanner ( System.in );

        System.out.print ( "Input Length of rectangle..." );
        double length = input.nextDouble ();
        System.out.print ( "Input width of rectangle..." );
        double width = input.nextDouble ();
        
        String prompt = """
                Choose From Menu
                1.--> Perimeter Of Rectangle.
                2.--> Area Of Rectangle.""";
        
        System.out.println ( prompt );
        int userChoice = input.nextInt ();
        switch (userChoice) {
            case 1 -> {
                rectangle.setPerimeter ( length, width );
                double perimeter = rectangle.getPerimeter ();
                System.out.println ( "Perimeter of rectangle with length\t" + length + "\t and width\t" + width + "\tis\t" + perimeter );
            }
            case 2 -> {
                rectangle.setArea ( length, width );
                double area = rectangle.getArea ();
                System.out.println ( "Area of rectangle with length\t" + length + "\t and width\t" + width + "\tis\t" + area );
            }
            default -> throw new IllegalStateException ( "Unexpected value: " + userChoice );
        }
    }
}