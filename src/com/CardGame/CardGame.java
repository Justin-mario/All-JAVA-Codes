package com.CardGame;

import com.CardGame.Exceptions.InvalidCardValueException;

import static com.CardGame.Suit.*;

public class CardGame {
    private final int value;
    private final Suit suit;


    private CardGame(Suit suit, int value) {
        if (value < 1 || value > 20){
            throw new InvalidCardValueException (value + " Is Not a Valid Card Value");
        }
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {

        return value;
    }

    @Override
    public String toString() {
        return getValue () + " of " + suit.toString ();
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass ().equals ( obj.getClass () )){
            return false; }
        CardGame cardToCompare = (CardGame)  obj;
        if (this.value == cardToCompare.value || this.suit == cardToCompare.suit) {
            return true;
        }
        return false;
    }

    public static CardGame createCircles(int numberOfCard){
        CardGame cardGame = new CardGame ( CIRCLES, numberOfCard );
        return cardGame;
    }

    public static CardGame createCrosses(int numberOfCard){
        CardGame cardGame = new CardGame ( CROSSES, numberOfCard );
        return cardGame;
    }

    public static CardGame createSquares(int numberOfCard){
        CardGame cardGame = new CardGame ( SQUARES, numberOfCard );
        return cardGame;
    }

    public static CardGame createStar(int numberOfCard){
        CardGame cardGame = new CardGame ( STARS, numberOfCard );
        return cardGame;
    }
    public static CardGame createWhot(int numberOfCard){
        CardGame cardGame = new CardGame ( WHOT,20);
        return cardGame;
    }
    public static CardGame createTriangle(int numberOfCard){
        CardGame cardGame = new CardGame ( TRIANGLE, numberOfCard );
        return cardGame;
    }
}
