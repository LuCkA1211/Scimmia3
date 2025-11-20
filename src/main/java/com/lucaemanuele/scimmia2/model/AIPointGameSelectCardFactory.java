package com.lucaemanuele.scimmia2.model;

/*

This class is responsible to create the Strategy for AI Point modality, based on difficulty

This is a concrete subclass for Abstract Factory Design Pattern
*/

public class AIPointGameSelectCardFactory implements IAISelectCardStrategyFactory {
    
    public static AIPointGameSelectCardFactory instance = null;  // Singleton instance
    
    /*
    Singleton method getInstance.
    Verify if there is an existing instance, if not it creates it.
    It assures that there could be only one instance for this class
    */
    public static AIPointGameSelectCardFactory getInstance() {
        if(instance == null) {
            instance = new AIPointGameSelectCardFactory();
        }
        return instance;
    }
    
    /*
    Private constructor for Singleton, it denies the creation of more than one object (with getInstance also)
    */
    private AIPointGameSelectCardFactory() {
        
    }
    
    /*
    Based on the difficult, it will return the ConcreteStrategy for AI Point modality
    */
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
