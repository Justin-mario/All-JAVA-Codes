package com.Kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KataTest {
    @Test
    void checkArrayElementsHasBeenCreated(){
        Kata kata = new Kata ();
        int[] arrayList = {2,4,6,8};
        assertArrayEquals ( arrayList, kata.getArrayElements () );
    }

    @Test
    void checkArrayElementsCanBeShuffled(){
        Kata kata = new Kata ();
        int[] arrayList = {2,4,6,8};
        assertNotEquals ( arrayList,kata.getShuffledArray());
    }
}