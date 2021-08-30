package com.CHAPTER_SEVEN.TicTacToe;

public enum TicTacToePlayers {
    X,O, EMPTY, PLAYED, NO_WINNER,UP_SYMBOLS, DOWN_SYMBOL
    ;


    @Override
    public String toString() {

        return switch (this){
            case X -> "X";
            case O -> "O";
            case EMPTY -> " ";
            case PLAYED -> "Played";
            case NO_WINNER -> "No_Winner";
            case UP_SYMBOLS -> " | ";
            case DOWN_SYMBOL -> " + ";
        };
    }
}
