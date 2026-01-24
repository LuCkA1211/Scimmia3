package com.lucaemanuele.scimmia2.model;

/*
This class is used to create the Game object, based on its input.

This class is a Pure Fabrication class
*/
public class GameSimpleFactory {
    
    /*
    Singleton
    */
    private static GameSimpleFactory instance = null;
    
    public static GameSimpleFactory getInstance() {
        if(instance == null) {
            instance = new GameSimpleFactory();
        }
        return instance;
    }
    
    private GameSimpleFactory() {
        
    }
    
    /*
    Create a specific Game, with the specific modality and draw rule
    */
    public Game createGame(HumanPlayer player, String difficulty, int numberCardsToDraw, String penalty, String modality) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        if(modality.equals("Standard")) {
            StandardGame game = new StandardGame(player, deckDesc, difficulty, numberCardsToDraw, penalty);
            return game;
        } else if(modality.equals("Point")) {
            PointGame game = new PointGame(player, deckDesc, difficulty, numberCardsToDraw, penalty);
            return game;
        }
        return null;
    }
    
}
