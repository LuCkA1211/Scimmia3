package com.lucaemanuele.scimmia2.model;

/*
Class which implements a normal card
*/
public class NormalCard extends Card {

    public NormalCard(int value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        
    }
    
    public String descriptionEffect() {
        return "Questa carta non ha particolari effetti";
    }
}
