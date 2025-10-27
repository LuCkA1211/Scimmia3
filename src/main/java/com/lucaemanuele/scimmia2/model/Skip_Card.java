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
    
    /*
    Return the type of card
    */
    @Override
    public String toString() {
        return "Skip";
    }
    
    /*
    Apply effect, in this case the nextPlayer does not take turn
    */
    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        nextPlayer.setHasTakenTurn(true);
    }
    
    /*
    Return the description of the effect
    */
    @Override
    public String descriptionEffect() {
        return "Il prossimo giocatore non gioca il prossimo turno";
    }
}
