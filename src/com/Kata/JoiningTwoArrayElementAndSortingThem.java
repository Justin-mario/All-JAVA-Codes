package com.Kata;
import java.util.*;

public class JoiningTwoArrayElementAndSortingThem {

    public static void joiningAndSortingTwoElementsOfArray(int[] firstList, int[] secondList){
        List<Integer> newList = new ArrayList<> ();
       for (int i = 0; i < firstList.length; i++){
           newList.add ( firstList[i] );
           newList.add ( secondList[i] );
       }

        Integer[] anotherList = new Integer[newList.size ()];
        for (int i = 0; i < newList.size (); i++) {
            anotherList[i] = newList.get ( i );
        }


//        Collections.sort ( newList );


    sortArray ( anotherList );

    }

    public static void sortArray(Integer[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                int tempI = list[i];
                int tempJ = list[j];
                if (tempI > tempJ){
                    list[i] = tempJ;
                    list[j] = tempI;

                }
            }
        }
        nonDuplicate ( Arrays.asList ( list ) );
        System.out.println (Arrays.toString ( list ));


    }
    public static void nonDuplicate(Collection<Integer> list){
        Set<Integer> set = new HashSet<> (list);
//        for(Integer value : set){
//            System.out.println (value + " ");
//        }

        System.out.println (set);
    }

    public static void main(String[] args) {
        int[] firstList = {13,15,19};
        int[] secondList = {11,13,18};
        joiningAndSortingTwoElementsOfArray ( firstList,secondList );
    }
}
