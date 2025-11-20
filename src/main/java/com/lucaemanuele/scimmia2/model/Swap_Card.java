package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the special cards Swap
*/
public class Swap_Card extends Card {
    
    /*
    Values of attributes are written in Business Rules
    */
    public Swap_Card() {
        this.color = "Black";
        this.value = 10;
    }
    
    /*
    Return the type of card
    */
    @Override
    public String toString() {
        return "Swap";
    }
    
    /*
    Swap the cards of the current player, and so who played it, and the next player
    */
    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        ArrayList<Card> currentPlayerCards = currentPlayer.getCardsInHand();
        ArrayList<Card> nextPlayerCards = nextPlayer.getCardsInHand();
        currentPlayer.setCardsInHand(nextPlayerCards);
        nextPlayer.setCardsInHand(currentPlayerCards);
    }
    
    /*
    Return the description of the effect
    */
    @Override
    public String descriptionEffect() {
        return "Scambia le carte con il prossimo giocatore";
    }
}
