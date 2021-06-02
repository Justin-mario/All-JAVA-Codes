package com.CardGame;

import com.CardGame.Exceptions.StackOverFlowException;
import com.CardGame.Exceptions.StackUnderFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.CardGame.Suit.*;
import static org.junit.jupiter.api.Assertions.*;

class CardDecksTest {
    private CardDeck cardDeck;
    @BeforeEach
    void beforeEachTest(){
       cardDeck = new CardDeck (4);
    }
    @Test
        void cardDeckHasFixedSize(){
        assertEquals ( 4,cardDeck.getSize () );
    }

    @Test
    void oncePushed_elementPushedShouldBeLast(){
        CardGame card = CardGame.createStar ( 2 );
        cardDeck.push(card);
        assertSame ( card,cardDeck.peek() );
    }

    @Test
    void pushedTwice_popOnce_peek_shouldReturnFirstElement(){
        CardGame firstCard = CardGame.createCrosses ( 2);
        CardGame secondCard = CardGame.createCircles ( 4 );
        cardDeck.push(firstCard);
        cardDeck.push(secondCard);
        CardGame poppedCard = cardDeck.pop();
        assertSame ( secondCard, poppedCard );
        assertSame ( firstCard,cardDeck.peek() );
    }

    @Test
    void popEmptyCardDEckThrowsException(){
        assertTrue (cardDeck.isEmpty() );
        assertThrows ( StackUnderFlow.class, cardDeck::pop );
    }
    @Test
    void pushIntoFullDeck_throwsStackOverFlowException(){
        CardGame firstCard = CardGame.createStar ( 7 );
        CardGame secondCard = CardGame.createSquares ( 4 );
        CardGame thirdCard = CardGame.createWhot ( 2);
        CardGame fourthCard = CardGame.createTriangle ( 4 );
        cardDeck.push(firstCard);
        cardDeck.push(secondCard);
        cardDeck.push(thirdCard);
        cardDeck.push(fourthCard);
        assertTrue ( cardDeck.isFull() );
        assertThrows ( StackOverFlowException.class, ()-> cardDeck.push(firstCard) );
    }
    @Test
    void pickingEmptyCardDeck_throwsStackUnderflowException(){
        assertTrue (cardDeck.isEmpty() );
        assertThrows ( StackUnderFlow.class, cardDeck::peek );
    }

    @Test
        void checkGameDealerCanShuffleCard(){
        CardGame firstCard = CardGame.createCircles ( 2);
        CardGame secondCard = CardGame.createCrosses ( 4 );
        CardGame thirdCard = CardGame.createStar ( 2);
        cardDeck.push(firstCard);
        cardDeck.push(secondCard);
        cardDeck.push(thirdCard);
        assertSame ( thirdCard,cardDeck.peek() );
        cardDeck.shuffleCard ();
        assertNotSame ( thirdCard,cardDeck.peek() );


    }

}