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
    
    public StandardGame createStandardGame(HumanPlayer player) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        StandardGame sg = new StandardGame(player, deckDesc);
        return sg;
    }
    
    public PointGame createPointGame(HumanPlayer player) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        PointGame pg = new PointGame(player, deckDesc);
        return pg;
    }
    
}
