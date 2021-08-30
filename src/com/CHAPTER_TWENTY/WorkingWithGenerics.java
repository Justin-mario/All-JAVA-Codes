package com.CHAPTER_TWENTY;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithGenerics<T> {
    public static <T> void printArray(T[] numbers){
        for (T elements: numbers) {
            System.out.printf ( "%s %n", elements);
        }
    }

    public static <T> T printArrays(T number){
        String[] arrayOfNumbers = {"RED", "red", "YELLOW", "yellow"};
        ArrayList<T> list = new ArrayList<> ();
        list.add(number);
        System.out.printf ( "%s", list );

    return (T) list;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,3,4,5,6};
        Double[] doubleArray = {2.5, 4.6, 6.7, 9.0};
        Character[] charArray = {'a', 'd', 'r', 'h'};
//    printArrays ();
        printArray ( intArray );
        printArray ( doubleArray );
        printArray ( charArray );

    }
}
