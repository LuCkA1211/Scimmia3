package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public abstract class DrawRuleDecorator implements IDrawRule {
    protected IDrawRule innerComponent;
    
    public DrawRuleDecorator(IDrawRule innerComponent) {
        this.innerComponent = innerComponent;
    }
    
    @Override
    public ArrayList<Card> draw() {
        return this.innerComponent.draw();
    }
}
