package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class ChosenNumberDrawRuleDecorator extends DrawRuleDecorator {
    
    protected int maxCardsToDraw = 3;
    
    public ChosenNumberDrawRuleDecorator(IDrawRule innerComponent) {
        super(innerComponent);
    }
    
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        while((!this.game.hasCurrentPlayerPlayed()) && (drawnCards.size() < this.maxCardsToDraw)) {
            drawnCards.addAll(this.innerComponent.draw());
        }
        System.out.println(drawnCards);
        return drawnCards;
    }
}
