package com.CHAPTER_SEVEN;

import java.util.Scanner;

public class SalesCommissionApp {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        int userInput = -1;
        while (userInput != 0) {
            System.out.print ( "input Sales Commission To Compute...." );
            userInput = input.nextInt ();
            SalesCommission.getEarningRange ( userInput );
            System.out.println ( "Press 1 to Continue ....0 To Exit" );
              if (userInput == 0){
                  for (int result:SalesCommission.commission) {
                      System.out.print (result);
                      System.out.println ();
                  }
                  System.exit ( 0 );
              }
            }



        }
    }

