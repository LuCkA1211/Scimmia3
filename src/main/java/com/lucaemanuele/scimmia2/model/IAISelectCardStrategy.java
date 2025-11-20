package com.lucaemanuele.scimmia2.model;

/*
This interface represents the Strategy interface of AI Select Card Strategy
*/
public interface IAISelectCardStrategy {
    
    /*
    Select the card to be played
    */
    public int selectCardToPlay(AIPlayer aiPlayer);
}
