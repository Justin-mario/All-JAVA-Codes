package com.CHAPTER_FIFTEEN.studentpoll;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class StudentSurvey {
    public static void writeToFile(){
        Scanner input = new Scanner ( System.in );
        try(Formatter formatter = new Formatter ("src/com/CHAPTER_FIFTEEN/out/numbers.txt")){
            System.out.println ("Enter Student Responses ENTER + CONTROL + D to Exit");

            while (input.hasNext ()){
                int studentResponses = input.nextInt ();
                formatter.format ( "%d ", studentResponses );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }

    public static int[] processSurveyResponses(){
        int[] frequency = new int[6];
        try (Scanner input = new Scanner ( Paths.get ("src/com/CHAPTER_FIFTEEN/out/numbers.txt") );
        Formatter output = new Formatter ("src/com/CHAPTER_FIFTEEN/out/output.txt")){

            while (input.hasNextInt ()){
                int answer = input.nextInt ();
                try{
                    ++frequency[answer];
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println (e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }

        return frequency;
    }

    public static void readFromFile(int[] frequency){
        try(Formatter output = new Formatter ("src/com/CHAPTER_FIFTEEN/out/output.txt")){
            output.format ( "%s%10s%n", "Rating", "Frequency" );
            for (int i = 1; i < frequency.length; i ++){
                output.format ( "%d%10d%n", i, frequency[i] );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        writeToFile ();
        int[] frequency = processSurveyResponses ();
        readFromFile ( frequency );
    }

}
