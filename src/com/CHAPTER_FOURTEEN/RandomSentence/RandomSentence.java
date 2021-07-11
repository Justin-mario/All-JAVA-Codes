package com.CHAPTER_FOURTEEN.RandomSentence;

import java.util.Random;

public class RandomSentence {
    public static void main(String[] args) {
        Random random = new Random ();
        String[] article = {"The", "A", "One", "Some", "Any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] preposition = {"to", "From", "over", "under", "on", "active"};


            String randomArticle = article[random.nextInt (5)];
            String randomNouns = noun[random.nextInt (5)];
            String randomVerb = verb[random.nextInt (5)];
            String randomPreposition = preposition[random.nextInt (5)];
            String randomArticle2 = article[random.nextInt (5)];
            String randomNouns2 = noun[random.nextInt (5)];

            String result = randomArticle + " " + randomNouns + " " + randomVerb + " " + randomPreposition + " " +
                    randomArticle2 + " " + randomNouns2 + ".";
        System.out.println ( result );
    }
}