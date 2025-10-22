package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Random;

/*
Class which implements the Player governed by the system
*/

public class AIPlayer extends Player {
    public AIPlayer(String nickname) {
        super(nickname);
    }
    
    // Select a random cards from its playable cards
    @Override
    public void playCardFromIndex(int indexCard, Table table) {
        Random rand = new Random();
        ArrayList<Card> playableCards = this.hand.getPlayableCards();
        int indexCardPlay = rand.nextInt(playableCards.size());
        Card cardToPlay = this.hand.getCardFromIndex(indexCardPlay);
        this.playCard(cardToPlay, table);
    }
}
