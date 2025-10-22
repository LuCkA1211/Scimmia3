package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the special card Draw4
*/
public class Draw2_Card extends Card {

    /*
    Values of attributes are written in Business Rules
    */
    public Draw2_Card() {
        this.value = 10;
        this.color = "Black";
    }
    
    @Override
    public String toString() {
        return "Draw_2";
    }

    /*
    Add two cards to the next player
    */
    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        ArrayList<Card> cardsDrawn = deck.drawCards(2);
        nextPlayer.addCardsToHand(cardsDrawn);
    }
    
    public String descriptionEffect() {
        return "Il prossimo giocatore pesca due carte";
    }
    
}
