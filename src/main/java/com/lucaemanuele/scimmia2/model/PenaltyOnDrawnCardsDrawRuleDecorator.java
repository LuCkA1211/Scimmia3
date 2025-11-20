package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
This class extend the Base Draw Rule. The player will take a penalty of 5 points in Point Game for each drawn card

This is a ConcreteDecorator class for Decorator Design Pattern
*/
public class PenaltyOnDrawnCardsDrawRuleDecorator extends DrawRuleDecorator {
    
    protected int penaltyWeight = 5;  // Added state
    
    public PenaltyOnDrawnCardsDrawRuleDecorator(IDrawRule innerComponent) {
        super(innerComponent);
    }
    
    /*
    Extended Base Draw Rule, in which the player will takes a 5 points penalty for each drawn card.
    */
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> drawnCards = innerComponent.draw();
        this.addedBehaviour(drawnCards);
        return drawnCards;
    }
    
    public void addedBehaviour(ArrayList<Card> drawnCards) {
        int currentPlayerPoints = ((PointGame) this.game).getPlayerPoints().get(((PointGame) this.game).getCurrentPlayer());
        int pointsToRemove = drawnCards.size() * this.penaltyWeight;
        if(pointsToRemove > currentPlayerPoints) {
            pointsToRemove = currentPlayerPoints;
        }
        ((PointGame)this.game).getPlayerPoints().merge(game.getCurrentPlayer(), -pointsToRemove, Integer::sum);
    }
    
}
