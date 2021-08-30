package com.Diary;

import java.util.Scanner;

public class DiaryApp {
    public static void main(String[] args) {
        int userInput = 0;
        String entry;
        Diary diary = new Diary ();
        DiaryUser personalDiary = new DiaryUser ( diary, "ken" );
        Scanner input = new Scanner ( System.in );
        Scanner entries = new Scanner ( System.in );

        String prompt = """
                1.--> Enter Entry.
                2.--> Read Entry.
                3.--> Delete Entry.
                4.--> Delete All Entry.
                5.--> Get Number Of Entry.
                6.--> Close Diary.
                """;
        System.out.println (prompt);

        while (userInput != -1) {
            userInput = input.nextInt ();
            switch (userInput) {
                case 1 -> {
                    System.out.print ( "Input Entry..." );
                    entry = entries.nextLine ();
                    personalDiary.createEntry ( entry );
                    System.out.println ( "entry....." + entry + "\n" );
                    System.out.println ( prompt + "\n" );
                }
                case 2 -> {
                    System.out.print ( "choose Diary Page To Read..." );
                    userInput = input.nextInt ();
                    System.out.print ( personalDiary.readEntry ( userInput )+ "\n" );
                    System.out.println ( prompt + "\n" );
                }
                case 3 -> {
                    System.out.println ( "Choose Diary Page To Delete..." );
                    userInput = input.nextInt ();
                    personalDiary.deleteEntry ( userInput );
                    System.out.println ( diary + "\n" );
                    System.out.println ( prompt + "\n" );
                }
                case 4 -> {
                    personalDiary.deleteAllEntry ();
                    System.out.print ( "All Entry Deleted" + "\n" );
                    System.out.println ( prompt + "\n" );
                }
                case 5 -> {
                    System.out.print ( personalDiary.getNumberOfEntry () + "\n" );
                    System.out.println ( prompt + "\n" );
                }

                case 6 -> System.exit ( 0 );
                default -> throw new IllegalStateException ( "Unexpected value: " + userInput );
            }

        }
    }
}
