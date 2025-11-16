package com.lucaemanuele.scimmia2.model;

public class AIPointGameSelectCardFactory implements IAISelectCardStrategyFactory {
    
    public static AIPointGameSelectCardFactory instance = null;
    
    public static AIPointGameSelectCardFactory getInstance() {
        if(instance == null) {
            instance = new AIPointGameSelectCardFactory();
        }
        return instance;
    }
    
    private AIPointGameSelectCardFactory() {
        
    }
    
    @Override
    public IAISelectCardStrategy createStrategy(String difficulty) {
        switch (difficulty) {
            case "Easy":
                return new AIEasyPointGameStrategy();
            case "Hard":
                return new AIHardPointGameStrategy();
            default:
                return null;
        }
    }
}
