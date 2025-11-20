package com.lucaemanuele.scimmia2.model;

/*
This class is used to create DrawRule object.

It is a Pure Fabrication class
*/
public class DrawRuleSimpleFactory {
    
    /*
    Singleton
    */
    private static DrawRuleSimpleFactory instance = null;
    
    public static DrawRuleSimpleFactory getInstance() {
        if(instance == null) {
            instance = new DrawRuleSimpleFactory();
        }
        return instance;
    }
    
    private DrawRuleSimpleFactory() {
        
    }
    
    /*
    Based on the input chosen by the user, it creates the chosen DrawRule.
    It is possible to concatenate more than one DrawRule, extending the Base Draw Rule
    
    We can see that we can have something like Penalty(Unlimited(Base(game))), but also Chosen(Base(game)), and so on...
    */
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
