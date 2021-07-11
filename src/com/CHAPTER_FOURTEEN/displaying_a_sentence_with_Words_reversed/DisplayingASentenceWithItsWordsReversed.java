package com.CHAPTER_FOURTEEN.displaying_a_sentence_with_Words_reversed;

import java.util.Scanner;

public class DisplayingASentenceWithItsWordsReversed {

    public static void reverseASentence(String sentence){
        String[] splitSentence = sentence.split ( "\\s*" );
        for (int i = splitSentence.length - 1; i >= 0; i--){
            System.out.print (splitSentence[i] + " ");
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );

        System.out.print ("Input word to reverse ");
        String userInput = input.nextLine ();

        reverseASentence ( userInput );

    }
}
