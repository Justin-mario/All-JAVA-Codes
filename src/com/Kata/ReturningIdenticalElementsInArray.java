package com.Kata;


import java.util.ArrayList;

public class ReturningIdenticalElementsInArray {
    public static void main(String[] args) {
        String[] input = {"11, 3, 14, 131, 17", "1, 2, 4, 13, 15"};
        comparingArrayElementStoringInList ( input );
        comparingArrayElement ( input );


    }

    public static StringBuilder comparingArrayElement(String[] input){
        StringBuilder list = new StringBuilder ();
        String[] firstElement = input[0].split ( ", ");
        String[] secondElement = input[1].split ( ", " );
        for (String s : firstElement) {
            for (String value : secondElement) {
                if (s.equalsIgnoreCase ( value )) {
                    list.append ( s ).append ( ", " );}

            }

        }
        if(list.length () == 0){
            System.out.println ("False");
        }
        System.out.println (list);
        return list;
    }

    public static ArrayList<String> comparingArrayElementStoringInList(String[] input){
        ArrayList<String> newList = new ArrayList<> ();
        String[] firstElement = input[0].split ( ", ");
        String[] secondElement = input[1].split ( ", " );
        for (String s : firstElement) {
            for (String value : secondElement) {
                if (s.equalsIgnoreCase ( value )) {
                    newList.add ( s );
                }


            }

        }
        if(newList.size () == 0){
            System.out.println ("False");
            return null;

        }
        System.out.println ( newList );
        return newList;
    }
}
