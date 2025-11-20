package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
This class extend the Base Draw Rule, making the player draw more than one card.

This is a ConcreteDecorator class for Decorator Design Pattern
*/
public class ChosenNumberDrawRuleDecorator extends DrawRuleDecorator {
    
    protected int maxCardsToDraw;  // Added state
    
    /*
    Takes the state of the inner component and adds to it the max number of cards to be drawn
    */
    public ChosenNumberDrawRuleDecorator(IDrawRule innerComponent, int maxCardsToDraw) {
        super(innerComponent);
        this.maxCardsToDraw = maxCardsToDraw;
    }
    
    /*
    Extended Base Draw Rule, make it possible to draw more than one card.
    The player can draw as many cards as the max number, chosen at creation time.
    */
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = this.innerComponent.draw();
        drawnCards = this.addedBehaviour(drawnCards);
        return drawnCards;
    }
    
    public ArrayList<Card> addedBehaviour(ArrayList<Card> drawnCards) {
        while((!this.game.hasCurrentPlayerPlayed()) && (drawnCards.size() < this.maxCardsToDraw)) {
            ArrayList<Card> cardDrawn = this.innerComponent.draw();
            if(cardDrawn.get(0) == null) return drawnCards;  // Deck is empty
            drawnCards.addAll(cardDrawn);
        }
        return drawnCards;
        
    }
}
