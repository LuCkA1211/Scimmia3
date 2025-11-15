package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Random;

public class AIEasyStandardGameStrategy implements IAISelectCardStrategy {

    /*
    Select a random playable card
    */
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        Random rand = new Random();
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        int indexCardPlay = rand.nextInt(playableCards.size());
        return indexCardPlay;
    }
    
}
