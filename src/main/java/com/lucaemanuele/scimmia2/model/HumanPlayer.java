package com.lucaemanuele.scimmia2.model;

/*
Class which implements the human player, and so who plays against the CPU.
It is responsible to choose which card to play and know when to draw
*/
public class HumanPlayer extends Player {
    public HumanPlayer(String nickname) {
        super(nickname);
    }
    
    /*
    Play a card given an index taken as an input
    */
    @Override
    public void playCardFromIndex(int indexCardPlay, Table table) {
        Card cardToBePlayed = this.hand.getCardFromIndex(indexCardPlay);
        this.playCard(cardToBePlayed, table);
    }
    
    /*
    Re-create the hand, in order to remove all the cards in the hand
    */
    public void clearHand() {
        this.hand = new Hand();
    }
}
