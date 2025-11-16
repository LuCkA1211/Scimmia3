package com.lucaemanuele.scimmia2.model;

public class AIStandardGameSelectCardFactory implements IAISelectCardStrategyFactory {
    
    public static AIStandardGameSelectCardFactory instance = null;
    
    public static AIStandardGameSelectCardFactory getInstance() {
        if(instance == null) {
            instance = new AIStandardGameSelectCardFactory();
        }
        return instance;
    }
    
    private AIStandardGameSelectCardFactory() {
        
    }
    
    @Override
    public IAISelectCardStrategy createStrategy(String difficulty) {
        switch (difficulty) {
            case "Easy":
                return new AIEasyStandardGameStrategy();
            case "Hard":
                return new AIHardStandardGameStrategy();
            default:
                return null;
        }
    }
}
