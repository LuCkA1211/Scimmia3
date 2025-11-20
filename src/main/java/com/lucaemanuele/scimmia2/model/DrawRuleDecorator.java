package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
This is the class that can be used to extend the draw rules

This is the abstract class of Decorator in Decorator Design Pattern
*/
public abstract class DrawRuleDecorator implements IDrawRule {
    
    /*
    It has the same state and a reference to a Component object
    */
    protected IDrawRule innerComponent;
    protected Game game;
    
    /*
    It takes the same state of the inner component
    */
    public DrawRuleDecorator(IDrawRule innerComponent) {
        this.innerComponent = innerComponent;
        this.game = innerComponent.getGame();
    }
    
    /*
    Transfer requests to its Component
    */
    @Override
    public ArrayList<Card> draw() {
        return this.innerComponent.draw();
    }
    
    @Override
    public Game getGame() {
        return innerComponent.getGame();
    }
    
}
