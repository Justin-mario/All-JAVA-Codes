package com.CHAPTER_SEVEN.Fibonacci;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceTest {
    @Test
    void fibonacciWithInt(){
        assertEquals ( 3, FibonacciSequence.fibonacciWithIntValue ( 5 ) );
    }

    @Test
    void fibonacciWithDouble(){
        assertEquals ( 34.0, FibonacciSequence.fibonacciWithIntDouble ( 10.0 ) );

    }
}