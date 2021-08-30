package com.CHAPTER_SIXTEEN.counting_duplicate_words;

import java.util.ArrayList;

public class CountingDuplicateWords {
    public  void  countingDuplicateWords(ArrayList<String> list){
      int count =0;

       for (int i = 0; i < list.size (); i++){
           for (int j = i + 1; j < list.size ();  j++) {
               //if (list.get ( i ).contentEquals ( list.get (j) )){
               if (list.get ( i ).contains ( list.get ( j ) )) {
                   count++;
               }

           }

       }
        System.out.println (count);
        System.out.println ( list );

    }

    public static void main(String[] args) {
        CountingDuplicateWords count = new CountingDuplicateWords ();

        ArrayList<String> lists = new ArrayList<> ();
        lists.add ( "shes" );
        lists.add ( "shes" );
        lists.add ( "shes" );
        lists.add ( "shes" );
        lists.add ( "shes" );
        lists.add ( "shes" );


        count.countingDuplicateWords (lists  );

    }
}
