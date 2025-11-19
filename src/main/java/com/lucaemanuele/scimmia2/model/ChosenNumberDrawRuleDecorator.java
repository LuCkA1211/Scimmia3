package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class ChosenNumberDrawRuleDecorator extends DrawRuleDecorator {
    
    protected int maxCardsToDraw;
    
    public ChosenNumberDrawRuleDecorator(IDrawRule innerComponent, int maxCardsToDraw) {
        super(innerComponent);
        this.maxCardsToDraw = maxCardsToDraw;
    }
    
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        while((!this.game.hasCurrentPlayerPlayed()) && (drawnCards.size() < this.maxCardsToDraw)) {
            ArrayList<Card> cardDrawn = this.innerComponent.draw();
            if(cardDrawn.get(0) == null) return drawnCards;  // Deck is empty
            drawnCards.addAll(cardDrawn);
        }
        System.out.println(drawnCards);
        return drawnCards;
    }
}
