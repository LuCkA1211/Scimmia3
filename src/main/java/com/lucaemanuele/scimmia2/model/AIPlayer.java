package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the Player governed by the system
*/

public class AIPlayer extends Player {
    private IAISelectCardStrategy selectCardStrategy;  // Composition
    
    public AIPlayer(String nickname) {
        super(nickname);
        this.selectCardStrategy = new AIEasyStandardGameStrategy();
    }

    public IAISelectCardStrategy getSelectCardStrategy() {
        return this.selectCardStrategy;
    }

    public void setSelectCardStrategy(IAISelectCardStrategy selectCardStrategy) {
        this.selectCardStrategy = selectCardStrategy;
    }
    
    // Select a card following a strategy
    @Override
    public void playCardFromIndex(int indexCard, Table table) {
        int indexCardPlay = this.selectCardStrategy.selectCardToPlay(this);
        Card cardToPlay = this.hand.getCardFromIndex(indexCardPlay);
        this.playCard(cardToPlay, table);
    }
}
