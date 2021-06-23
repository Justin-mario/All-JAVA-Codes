package com.CHAPTER_SEVENTEEN.occurance_of_character;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountingOccurrenceOfCharacter {
    public static void writeToFile(){
        Scanner input = new Scanner ( System.in );
        try(Formatter formatter = new Formatter ("src/com/CHAPTER_SEVENTEEN/test/words.txt")){
            System.out.println ("Enter Content of File and press ENTER + CONTROL + D to exit");

            while (input.hasNext ()){
                String words = input.nextLine ();
                formatter.format ( "%s ", words );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
    }

    public static void countOccurrenceOfEachCharacter(){
        Pattern pattern =  Pattern.compile( "" );
        try {
            Map<String, Long> wordCounts =
                    Files.lines( Paths.get("src/com/CHAPTER_SEVENTEEN/test/words.txt"))
                            .map(line -> line.replaceAll("(?!')\\p{P}", ""))
                            .flatMap(line -> pattern.splitAsStream(line))
                            .collect( Collectors.groupingBy(String::toLowerCase,
                                    TreeMap::new, Collectors.counting()));

            wordCounts.entrySet()
                    .stream()
                    .collect(
                            Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                                    TreeMap::new, Collectors.toList()))
                    .forEach((letter, wordList) ->
                    {
                        System.out.printf("%n%C%n", letter);
                        wordList.stream().forEach(word -> System.out.printf(
                                "%13s: %d%n", word.getKey(), word.getValue()));
                    });
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    public static void main(String[] args) {
        writeToFile ();
        countOccurrenceOfEachCharacter ();
    }
}
