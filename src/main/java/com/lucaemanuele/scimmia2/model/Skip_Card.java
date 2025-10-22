package com.lucaemanuele.scimmia2.model;

/*
Class which implements the special card Skip
*/
public class Skip_Card extends Card {
    
    /*
    Values of attributes are written in Business Rules
    */
    public Skip_Card() {
        this.color = "Black";
        this.value = 10;
    }
    
    @Override
    public String toString() {
        return "Skip";
    }
    
    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        nextPlayer.setHasTakenTurn(true);
    }
    
    public String descriptionEffect() {
        return "Il prossimo giocatore non gioca il prossimo turno";
    }
}
