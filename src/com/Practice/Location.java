package com.Practice;

import java.math.BigInteger;
import java.util.Scanner;

public class Location {
    public int row;
    public static int column;
    public double maxValue;


    public Location(int row, int column, double maxValue){
        this.row = row;
        Location.column = column;
        this.maxValue = maxValue;
    }
    public Location(int row, double maxValue){
        this(row, 5, maxValue);
    }
    public double getMaxValue(){
        return maxValue;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public static void main(String[] args) {
//        System.out.println (Integer.MIN_VALUE);
//        System.out.println (Short.MAX_VALUE);
//        System.out.println (String.format ( "%X",25 ));
//        BigInteger integer = new BigInteger ( "2000000000" );
//        integer.add ( BigInteger.valueOf ( 45000 ) );
//        System.out.println (integer);
        Scanner input = new Scanner ( System.in );
        char[] letter = "java".toCharArray ();
        System.out.println (letter[0]);
    }
}
