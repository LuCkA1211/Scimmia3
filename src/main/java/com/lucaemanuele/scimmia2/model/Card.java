package com.lucaemanuele.scimmia2.model;

/*
Class which contains the common element for each type of cards, so value and color
*/
public abstract class Card {
    protected int value;
    protected String color;
    
    /*
    Getter and setter
    */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    @Override
    public String toString() {
        return this.color + " " + this.value;
    }
    
    /*
    Implemented in each type of card
    */
    public abstract void effect(Player currentPlayer, Player nextPlayer, Deck deck);

    public abstract String descriptionEffect();
}
