package com.CardGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
        void playerHasanId(){
        Player player = new Player ("Michael");
        assertEquals ( "Michael", player.getName() );
    }

    @Test
    void playerHasCards(){
        Player player = new Player ("Michael");
        player.addCard(CardGame.createCircles ( 4 ));
        player.addCard(CardGame.createCrosses ( 2 ));
        player.addCard(CardGame.createStar ( 5));


        assertEquals ( 3, player.getNumberOfCards() );
    }
}