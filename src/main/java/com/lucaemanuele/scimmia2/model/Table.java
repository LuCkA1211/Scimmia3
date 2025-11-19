package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the table, and so where the game is played
*/
public class Table {
    private Deck deck;
    private Card faceUpCard;  // Says what card must be played
    
    public Table(DeckDescription deckDesc) {
        this.deck = new Deck(deckDesc);
        this.faceUpCard = null;
    }

    /*
    Getter and setter
    */
    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getFaceUpCard() {
        return faceUpCard;
    }

    public void setFaceUpCard(Card faceUpCard) {
        this.faceUpCard = faceUpCard;
    }
    
    /*
    Obtain a specific cards from the deck
    */
    public ArrayList<Card> getCardsFromDeck(int numberCards) {
        ArrayList<Card> cardsFromDeck = this.deck.drawCards(numberCards);
        return cardsFromDeck;
    }
    
    /*
    Obtain the top card of the deck
    */
    public Card drawCardFromDeck() {
        Card c = this.deck.getTopCard();
        return c;
    }
    
    public boolean emptyDeck() {
        return this.deck.getCardsInDeck().isEmpty();
    }
    
    /*
    Set the first face up card of the game
    */
    public void setFirstPlayableCard() {
        Card firstPlayableCard = this.deck.getTopCard();
        this.setFaceUpCard(firstPlayableCard);
    }
    
    public void playCard(Card c) {
        this.setFaceUpCard(c);
    }
    
    public int getNumberOfCardsInDeck() {
        return this.deck.getCardsInDeck().size();
    }
    
}
