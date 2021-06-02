package com.CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardGamePlayingTest {
    @Test
    void cardGameCanBeCreated(){
        CardGamePlaying cardGame = new CardGamePlaying (2, 5);
        assertNotNull ( cardGame );
    }

    @Test
    void gameIsInitializedWithNumberOfPlayerCanBeCreated(){
        CardGamePlaying cardGame = new CardGamePlaying (2, 5);
        assertEquals ( 2,cardGame.getNumberOfPlayers () );
    }
}