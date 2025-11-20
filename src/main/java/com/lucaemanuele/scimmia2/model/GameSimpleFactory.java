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
    Creates a Standard Game
    */
    public StandardGame createStandardGame(HumanPlayer player, String difficulty, int numberCardsToDraw) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        StandardGame sg = new StandardGame(player, deckDesc, difficulty);
        sg.createAndSetDrawRule(numberCardsToDraw, "N");
        return sg;
    }
    
    /*
    Creates a Point Game
    */
    public PointGame createPointGame(HumanPlayer player, String difficulty, int numberCardsToDraw, String penalty) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        PointGame pg = new PointGame(player, deckDesc, difficulty);
        pg.createAndSetDrawRule(numberCardsToDraw, penalty);
        return pg;
    }
    
}
