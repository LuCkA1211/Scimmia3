package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Random;

/*
Class which implement the Strategy for Easy Mode for Standard modality, in particular the selection of the card from AI.

This Strategy select a random card from the playable cards.

This class represent the ConcreteStrategy of Startegy Design Pattern
*/

public class AIEasyStandardGameStrategy implements IAISelectCardStrategy {
    Random rand = new Random();
    
    /*
    Select a random playable card
    */
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        int indexCardPlay = rand.nextInt(playableCards.size());
        return indexCardPlay;
    }
    
}
