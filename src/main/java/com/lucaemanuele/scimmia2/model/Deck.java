package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Collections;

/*
Class which implements the deck as a container of cards
*/
public class Deck {
    private ArrayList<Card> cardsInDeck = new ArrayList<>();
    private DeckDescription deckDesc;
    
    /*
    Constructor
    It create the deck following the business rules.
    The numbers of special cards are given by the DeckDescription
    */
    public Deck(DeckDescription deckDesc) {
        this.deckDesc = deckDesc;
        String[] colors = {"Red","Blue","Green","Yellow"};
        for(String c : colors) {
            for(int i = 1; i < 10; i++) {
                for(int j = 0; j < 3; j++) {
                    NormalCard nc = new NormalCard(i, c);
                    this.cardsInDeck.add(nc);
                }
            }
        }
        
        /*
        Create special cards according to DeckDescription
        */
        int k = 0;
        for(k = 0; k < this.deckDesc.getNumberDraw2(); k++) {
            Draw2_Card d2c = new Draw2_Card();
            this.cardsInDeck.add(d2c);
        }
        for(k = 0; k < this.deckDesc.getNumberDraw4(); k++) {
            Draw4_Card d4c = new Draw4_Card();
            this.cardsInDeck.add(d4c);
        }
        
        
        for(k = 0; k < this.deckDesc.getNumberSkip(); k++) {
            Skip_Card sc = new Skip_Card();
            this.cardsInDeck.add(sc);
        }
        
        for(k = 0; k < this.deckDesc.getNumberDraw2(); k++) {
            Swap_Card d2c = new Swap_Card();
            this.cardsInDeck.add(d2c);
        }
        
        /*
        In the end, shuffle the deck for the first time
        */
        this.shuffle();
        
    }
    
    /*
    Getter and setter
    */
    public ArrayList<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public void setCardsInDeck(ArrayList<Card> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }
    
    /*
    Simulate the shuffle of the deck
    */
    public void shuffle() {
        Collections.shuffle(this.cardsInDeck);
    }
    
    /*
    Draw a precise number of cards.
    If there are a number of cards less than the cards to be drawn, then will be drawn all the cards from deck
    */
    public ArrayList<Card> drawCards (int cardsToDraw) {
        ArrayList<Card> cardsDrawn = new ArrayList<>();
        if(this.cardsInDeck.size() < cardsToDraw) {
            cardsToDraw = this.cardsInDeck.size();
        }
        for(int i = 0; i < cardsToDraw; i++) {
            Card c = this.getTopCard();
            cardsDrawn.add(c);
        }
        return cardsDrawn;
    }
    
    /*
    Return the card on top of the deck, and so the card to be drawn
    */
    public Card getTopCard() {
        if(this.cardsInDeck.isEmpty()) return null;
        return this.cardsInDeck.remove(this.cardsInDeck.size() - 1);
    }
}
