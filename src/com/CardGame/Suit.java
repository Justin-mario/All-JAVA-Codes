package com.CardGame;

public enum Suit {
    TRIANGLE, CIRCLES, CROSSES, SQUARES, STARS,WHOT;


    @Override
    public String toString() {
        return switch (this){
            case TRIANGLE -> "Triangle";
            case CIRCLES -> "Circles";
            case CROSSES -> "Crosses";
            case SQUARES ->"Squares";
            case STARS -> "Stars";
            case WHOT ->"Whot";
        };
    }
}
