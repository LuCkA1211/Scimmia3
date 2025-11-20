package com.lucaemanuele.scimmia2.model;

/*
This class is responsible to create the Strategy for AI Standard modality, based on difficulty

This is a concrete subclass for Abstract Factory Design Pattern
*/
public class AIStandardGameSelectCardFactory implements IAISelectCardStrategyFactory {
    
    public static AIStandardGameSelectCardFactory instance = null;  // Singleton instance
    
    /*
    Singleton method getInstance.
    Verify if there is an existing instance, if not it creates it.
    It assures that there could be only one instance for this class
    */
    public static AIStandardGameSelectCardFactory getInstance() {
        if(instance == null) {
            instance = new AIStandardGameSelectCardFactory();
        }
        return instance;
    }
    
    /*
    Private constructor for Singleton, it denies the creation of more than one object (with getInstance also)
    */
    private AIStandardGameSelectCardFactory() {
        
    }
    
    /*
    Based on the difficult, it will return the ConcreteStrategy for AI Standard modality
    */
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
