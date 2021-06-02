package com.CardGame;

import com.CardGame.Exceptions.InvalidCardValueException;
import org.junit.jupiter.api.Test;

import static com.CardGame.Suit.*;
import static org.junit.jupiter.api.Assertions.*;

class CardGamePlayTest {
    @Test
        void circleCanBeCreated(){
            CardGame card = CardGame.createCircles ( 5 );
            assertSame ( CIRCLES, card.getSuit() );
    }
    @Test
    void squareCanBeCreated(){
        CardGame card = CardGame.createSquares ( 1 );
        assertSame ( SQUARES, card.getSuit() );
    }

    @Test
    void starsCanBeCreated(){
        CardGame card = CardGame.createStar ( 2 );
        assertSame ( STARS, card.getSuit() );
    }
    @Test
    void TriangleCanBeCreated(){
        CardGame card = CardGame.createTriangle ( 3 );
        assertSame ( TRIANGLE, card.getSuit() );
    }
    @Test
    void whotCardsCanBeCreated(){
        CardGame card = CardGame.createWhot (20);
        assertEquals ( WHOT, card.getSuit () );
    }

    @Test
    void crossesCardsCanBeCreated(){
        CardGame card = CardGame.createCrosses ( 1 );
        assertEquals ( CROSSES, card.getSuit () );
    }


    @Test
    void numericCardsCanBeCreated(){
        CardGame card = CardGame.createCrosses ( 8 );
        assertEquals ( 8, card.getValue() );
    }

    @Test
    void invalidCardExceptionIsThrownWhenValueIsInvalid(){
        assertThrows ( InvalidCardValueException.class, ()-> CardGame.createTriangle (21) );
        assertThrows ( InvalidCardValueException.class, ()-> CardGame.createTriangle (0) );
    }
    @Test
    void CheckCardCanBeDisplayed(){
        CardGame card = CardGame.createSquares ( 8);
        String expectedToString = "8 of Squares";
        assertEquals ( expectedToString, card.toString () );
        card = CardGame.createStar ( 13);
        expectedToString = "13 of Stars";
        assertEquals ( expectedToString, card.toString () );
    }

    @Test
        void checkSameCardValueAreEquals(){
        CardGame kingOfSpade = CardGame.createSquares ( 13 );
        CardGame kingOfHeart = CardGame.createSquares ( 13 );
        assertEquals ( kingOfHeart,kingOfSpade );
    }

    @Test
    void checkSameSuitValueAreEquals(){
        CardGame kingOfSpade = CardGame.createTriangle ( 13 );
        CardGame queenOfSpade = CardGame.createTriangle ( 12 );
        CardDeck cardDeck = new CardDeck ( 2 );
        assertEquals (kingOfSpade,queenOfSpade );
        assertNotEquals (cardDeck,kingOfSpade );
    }
}