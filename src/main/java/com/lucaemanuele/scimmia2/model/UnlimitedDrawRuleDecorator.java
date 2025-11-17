package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class UnlimitedDrawRuleDecorator extends DrawRuleDecorator {
    private Game game;
    
    public UnlimitedDrawRuleDecorator(IDrawRule innerComponent, Game game) {
        super(innerComponent);
        this.game = game;
    }
    
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        while(!this.game.hasCurrentPlayerPlayed()) {
            drawnCards.addAll(this.innerComponent.draw());
        }
        //System.out.println(drawnCards);
        return drawnCards;
    }
}
