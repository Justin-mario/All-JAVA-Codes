package com.CardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
   private String playerName;
   private List<CardGame> cards = new ArrayList<> ();



    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return playerName;
    }

    public void addCard(CardGame card) {
        cards.add ( card );
    }

    public int getNumberOfCards() {
        return cards.size ();
    }
}
