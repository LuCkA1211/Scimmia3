package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class PenaltyOnDrawnCardsDrawRuleDecorator extends DrawRuleDecorator {
    
    protected int penaltyWeight = 5;
    
    public PenaltyOnDrawnCardsDrawRuleDecorator(IDrawRule innerComponent) {
        super(innerComponent);
    }
    
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
