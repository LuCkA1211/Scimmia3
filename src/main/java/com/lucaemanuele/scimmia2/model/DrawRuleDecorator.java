package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public abstract class DrawRuleDecorator implements IDrawRule {
    protected IDrawRule innerComponent;
    protected Game game;
    
    public DrawRuleDecorator(IDrawRule innerComponent) {
        this.innerComponent = innerComponent;
        this.game = innerComponent.getGame();
    }
    
    @Override
    public ArrayList<Card> draw() {
        return this.innerComponent.draw();
    }
    
    @Override
    public Game getGame() {
        return innerComponent.getGame();
    }
    
}
