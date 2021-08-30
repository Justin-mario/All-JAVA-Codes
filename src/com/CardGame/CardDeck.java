package com.CardGame;

import com.CardGame.Exceptions.StackOverFlowException;
import com.CardGame.Exceptions.StackUnderFlow;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

public class CardDeck {
    private CardGame[] cardArray;
    private int lastPushedLocation = -1;
    SecureRandom random = new SecureRandom ();


    public CardDeck(int numberOfCard) {
        cardArray = new CardGame[numberOfCard];

    }

    public int getSize() {
        return cardArray.length;
    }

    public void push(CardGame card) {
        if (isFull ()) throw new StackOverFlowException ( "Card deck is full" );
        lastPushedLocation++;
        cardArray[lastPushedLocation] = card;
    }

    public CardGame peek() {
        if (isEmpty ()) throw new StackUnderFlow ( "Card deck is empty" );
        return cardArray[lastPushedLocation];
    }


    public CardGame pop() {
        if (isEmpty ()) throw new StackUnderFlow ( "Card deck is empty" );

        return cardArray[lastPushedLocation--];
    }

    public boolean isEmpty() {
        return lastPushedLocation == -1;
    }

    public boolean isFull() {

        return (lastPushedLocation == getSize () - 1);
    }

    public static CardDeck createFullCardDeck(){
        CardDeck newCardDeck = new CardDeck ( 54 );
        for (Suit suit: Suit.values ()) {
            switch (suit){
                case TRIANGLE:
                    for (int i = 1; i < 15; i++){
                        if (i != 6 || i != 9){
                        newCardDeck.push (CardGame.createTriangle ( i ));}
                    }
                case CIRCLES:
                    for (int i = 1; i < 15; i++){
                        if (i != 6 || i != 9){
                        newCardDeck.push (CardGame.createCircles ( i ));}
                    }
                case CROSSES:
                    for (int i = 1; i < 15; i++){
                        if (i != 6 || i != 8 || i != 9){
                        newCardDeck.push (CardGame.createCrosses ( i ));}
                    }
                case SQUARES:
                    for (int i = 1; i < 15; i++){
                        if (i != 6 || i != 8 || i != 9){
                            newCardDeck.push (CardGame.createSquares ( i ));}
                    }
                case STARS:
                    for (int i = 1; i < 9; i++){
                        if (i != 6 ){
                            newCardDeck.push (CardGame.createStar ( i ));}
                    }
                case WHOT:
                    for (int i = 1; i < 6; i++){
                        newCardDeck.push ( CardGame.createWhot (i) );
                    }
            }

        }
       return newCardDeck;
    }

    public void shuffleCard() {
//        for (int i = 0; i < cards.length; i++) {
//            CardGamePlay temp = cards[i];
//           int randomIndex = random.nextInt ( cards.length );
//            cards[i] = cards[randomIndex];
//            cards[randomIndex] = temp;
//
//        }
        Collections.shuffle ( Arrays.asList ( cardArray ) );
    }
}
