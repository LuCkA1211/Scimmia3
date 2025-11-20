package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the Player governed by the system

*/

public class AIPlayer extends Player {
    private IAISelectCardStrategy selectCardStrategy;  // Composition (notice that this class is also the Context object of Strategy Design Pattern)
    
    public AIPlayer(String nickname, IAISelectCardStrategyFactory factory, String difficulty) {
        super(nickname);
        this.selectCardStrategy = factory.createStrategy(difficulty);  // It can be for Standard, Point, Easy, Hard... it does not know anything about implementation
    }

    /*
    Getter and setter
    */
    public IAISelectCardStrategy getSelectCardStrategy() {
        return this.selectCardStrategy;
    }

    public void setSelectCardStrategy(IAISelectCardStrategy selectCardStrategy) {
        this.selectCardStrategy = selectCardStrategy;
    }
    
    // Select a card following a strategy and plays it
    @Override
    public void playCardFromIndex(int indexCard, Table table) {
        int indexCardPlay = this.selectCardStrategy.selectCardToPlay(this);
        Card cardToPlay = this.hand.getCardFromIndex(indexCardPlay);
        this.playCard(cardToPlay, table);
    }
}
