package com.lucaemanuele.scimmia2.model;

public class DrawRuleSimpleFactory {
    private static DrawRuleSimpleFactory instance = null;
    
    public static DrawRuleSimpleFactory getInstance() {
        if(instance == null) {
            instance = new DrawRuleSimpleFactory();
        }
        return instance;
    }
    
    private DrawRuleSimpleFactory() {
        
    }
    
    public IDrawRule getDrawRule(int numberCardsToDraw, String penalty, Game game) {
        IDrawRule drawRule = new BaseDrawRule(game);
        
        if(numberCardsToDraw > 1) {
            drawRule = new ChosenNumberDrawRuleDecorator(drawRule, numberCardsToDraw);
        } else if(numberCardsToDraw == -1) {
            drawRule = new UnlimitedDrawRuleDecorator(drawRule);
        }
        if(penalty.equals("Y")) {
            drawRule = new PenaltyOnDrawnCardsDrawRuleDecorator(drawRule);
        }
        return drawRule;
    }
}
