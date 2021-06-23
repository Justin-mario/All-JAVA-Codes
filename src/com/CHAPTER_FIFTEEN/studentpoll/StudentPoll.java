package com.CHAPTER_FIFTEEN.studentpoll;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class StudentPoll {
    public static void writeToFile(){
        Scanner input = new Scanner ( System.in );
        try(Formatter formatter = new Formatter ("numbers.txt")){
            System.out.println ("Enter Student Responses ENTER + CONTROL + D to Exit");
            formatter.format ( "%s", "Student Responses: " );

            while (input.hasNext ()){
                int studentResponses = input.nextInt ();
                formatter.format ( "%d %s", studentResponses, " " );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        writeToFile ();
    }
}
