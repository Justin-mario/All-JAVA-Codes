package com.Practice.lambda_practices;

import java.util.stream.IntStream;

public class LambdaPractices {
    public static void main(String[] args) {
        int[] numbers = {2,4,6,9,0,12,19,20};


        IntStream.of ( numbers )
                 .forEach ( value -> System.out.printf ( "%d ", value ) );

        System.out.printf ("%n%d ",IntStream.of ( numbers ).count ());
        System.out.printf ("%n%d", IntStream.of ( numbers ).max ().getAsInt ());
        System.out.printf ("%n%d", IntStream.of ( numbers ).min ().getAsInt ());
        System.out.printf ("%n%.2f ", IntStream.of ( numbers ).average ().orElse ( 0 ));

        System.out.printf ("%n%d ", IntStream.of ( numbers )
                                              .reduce ( 0, Integer::sum ));

        System.out.printf ("%n%d ", IntStream.of ( numbers )
                                             .reduce ( 0, (X, Y) -> X + Y * Y ));

        System.out.printf ("%n%d ", IntStream.of ( numbers )
                                             .reduce ( 1, (X, Y) -> X * Y ));
        IntStream.rangeClosed ( 1,10 )
                .filter ( value -> value % 2 == 1 )
                .forEach ( value -> System.out.printf ("%d ", value) );
        
        System.out.println (IntStream.of ( numbers ).summaryStatistics ());
    }
}
