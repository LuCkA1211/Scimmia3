package com.lucaemanuele.scimmia2.model;

public class GameSimpleFactory {
    private static GameSimpleFactory instance = null;
    
    public static GameSimpleFactory getInstance() {
        if(instance == null) {
            instance = new GameSimpleFactory();
        }
        return instance;
    }
    
    private GameSimpleFactory() {
        
    }
    
    public StandardGame createStandardGame(HumanPlayer player, String difficulty, int numberCardsToDraw) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        StandardGame sg = new StandardGame(player, deckDesc, difficulty);
        sg.createAndSetDrawRule(numberCardsToDraw, "N");
        return sg;
    }
    
    public PointGame createPointGame(HumanPlayer player, String difficulty, int numberCardsToDraw, String penalty) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        PointGame pg = new PointGame(player, deckDesc, difficulty);
        pg.createAndSetDrawRule(numberCardsToDraw, penalty);
        return pg;
    }
    
}
