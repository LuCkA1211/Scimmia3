package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class UnlimitedDrawRuleDecorator extends DrawRuleDecorator {
    
    public UnlimitedDrawRuleDecorator(IDrawRule innerComponent) {
        super(innerComponent);
    }
    
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        drawnCards = this.addedBehaviour(drawnCards);
        //System.out.println(drawnCards);
        return drawnCards;
    }
    
    public ArrayList<Card> addedBehaviour(ArrayList<Card> drawnCards) {
        while(!this.game.hasCurrentPlayerPlayed()) {
            drawnCards.addAll(this.innerComponent.draw());
        }
        return drawnCards;
    }
}
