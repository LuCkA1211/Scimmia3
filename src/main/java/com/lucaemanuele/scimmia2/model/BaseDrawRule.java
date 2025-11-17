package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public class BaseDrawRule implements IDrawRule {
    private Game game;
    
    public BaseDrawRule(Game game) {
        this.game = game;
    }
    
    /*
    Make a player draw a card, playing it if possible (and activating the effect) and return it to the view
    */
    @Override
    public ArrayList<Card> draw() {
        ArrayList<Card> cardsDrawn = new ArrayList<>();
        Card cardDrawn = this.game.getCurrentPlayer().drawCard(this.game.getTable());
        cardsDrawn.add(cardDrawn);
        if(this.game.getCurrentPlayer().hasPlayed()) {
            this.game.activateEffect();
        }
        return cardsDrawn;
    }
}
