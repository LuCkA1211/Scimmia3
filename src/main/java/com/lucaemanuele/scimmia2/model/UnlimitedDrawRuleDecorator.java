package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
This class extend the Base Draw Rule, making the player draw more than one card.

This is a ConcreteDecorator class for Decorator Design Pattern
*/
public class UnlimitedDrawRuleDecorator extends DrawRuleDecorator {
    
    public UnlimitedDrawRuleDecorator(IDrawRule innerComponent) {
        super(innerComponent);
    }
    
    
    /*
    Extended Base Draw Rule.
    The player draws as many cards until it draws a playable card.
    */
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        drawnCards = this.addedBehaviour(drawnCards);
        return drawnCards;
    }
    
    public ArrayList<Card> addedBehaviour(ArrayList<Card> drawnCards) {
        while(!this.game.hasCurrentPlayerPlayed()) {
            ArrayList<Card> cardDrawn = this.innerComponent.draw();
            if(cardDrawn.get(0) == null) return drawnCards;  // Deck is empty
            drawnCards.addAll(cardDrawn);
        }
        return drawnCards;
    }
}
