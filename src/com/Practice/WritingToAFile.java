package com.Practice;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;



public class WritingToAFile {

    public  void openFile() {
        Scanner input  = new Scanner ( System.in );
        try (Formatter formatter = new Formatter ("student.txt"))
        {
            System.out.println ("Enter Student Record and Enter + CRL + D to stop");
            formatter.format ( "%s %s %s %s %s%n", "Firstname", "SecondName", "Level", "Year", "Age" );

            while (input.hasNext ()){
                String firstName = input.nextLine ();
                String lastname = input.nextLine ();
                int level = input.nextInt ();
                int year = input.nextInt ();

                formatter.format ( "%s %s %d %d %d%n", firstName, lastname, level, year, LocalDate.now ().getYear () - year );


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }



    public static void main(String[] args) {
        WritingToAFile studentRecord = new WritingToAFile ();
        studentRecord.openFile ();

    }
}
