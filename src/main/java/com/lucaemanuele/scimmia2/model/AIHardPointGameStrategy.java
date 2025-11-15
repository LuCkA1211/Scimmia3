package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class AIHardPointGameStrategy implements IAISelectCardStrategy {
    
    /*
    Select the card with the maximum value
    */
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        int maxCardIndex = 0;
        int max = -1;
        for(int i = 0; i < playableCards.size(); i++) {
            if(playableCards.get(i).getValue() > max) {
                max = playableCards.get(i).getValue();
                maxCardIndex = i;
            }
        }
        return maxCardIndex;
    }
}
