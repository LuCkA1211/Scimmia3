package com.lucaemanuele.scimmia2.model;

/*
Class which implements the human player, and so who plays against the CPU.
It is responsible to choose which card to play and know when to draw
*/
public class HumanPlayer extends Player {
    public HumanPlayer(String nickname) {
        super(nickname);
    }
    
    @Override
    public void playCardFromIndex(int indexCardPlay, Table table) {
        Card cardToBePlayed = this.hand.getCardFromIndex(indexCardPlay);
        this.playCard(cardToBePlayed, table);
    }
}
