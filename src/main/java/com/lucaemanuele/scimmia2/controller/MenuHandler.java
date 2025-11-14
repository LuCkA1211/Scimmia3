package com.lucaemanuele.scimmia2.controller;

import com.lucaemanuele.scimmia2.model.PointGame;
import com.lucaemanuele.scimmia2.model.StandardGame;
import com.lucaemanuele.scimmia2.model.DeckDescription;
import com.lucaemanuele.scimmia2.model.HumanPlayer;

public class MenuHandler {
    
    public StandardGame createStandardGame(HumanPlayer player) {
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        StandardGame sg = new StandardGame(player, deckDesc);
        return sg;
    }
    
    public PointGame createPointGame(HumanPlayer player) {
        //DeckDescription deckDesc = new DeckDescription(0,0,0,0);
        DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        PointGame pg = new PointGame(player, deckDesc);
        return pg;
    }
    
}
