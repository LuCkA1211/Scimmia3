package com.lucaemanuele.scimmia2.model;

/*
Class which implements a normal card
*/
public class NormalCard extends Card {

    public NormalCard(int value, String color) {
        this.value = value;
        this.color = color;
    }

    /*
    Does nothing (at the moment)
    */
    @Override
    public void effect(Player currentPlayer, Player nextPlayer, Deck deck) {
        
    }
    
    /*
    Return the color and value of the card
    */
    @Override
    public String toString() {
        return this.color + " " + this.value;
    }
    
    /*
    Return the description of the effect. In this case, says that it hasn't an effect
    */
    @Override
    public String descriptionEffect() {
        return "Questa carta non ha particolari effetti";
    }
}
