package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the hand, and so it contains the card to be played.
This class is responsible to show which card can be played
*/
public class Hand {
    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> playableCards;
    private Card lastFaceUpCard;
    
    public Hand() {
        this.cardsInHand = new ArrayList<>();
        this.playableCards = new ArrayList<>();
        this.lastFaceUpCard = null;
    }

    /*
    Getter and setter
    */
    public ArrayList<Card> getPlayableCards() {
        return playableCards;
    }

    public void setPlayableCards(ArrayList<Card> playableCards) {
        this.playableCards = playableCards;
    }

    public Card getLastFaceUpCard() {
        return lastFaceUpCard;
    }
    
    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(ArrayList<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public void setLastFaceUpCard(Card lastFaceUpCard) {
        this.lastFaceUpCard = lastFaceUpCard;
        this.updatePlayableCards();
    }
    
    /*
    Add a single card to the hand
    */
    public void addCard(Card card) {
        this.cardsInHand.add(card);
    }
    
    /*
    Add more than one card to the hand
    */
    public void addCards(ArrayList<Card> cards) {
        this.cardsInHand.addAll(cards);
    }
    
    /*
    Remove a specific card from the hand
    */
    public void removeCard(Card c) {
        this.cardsInHand.remove(c);
    }
    
    /*
    Return a playable card given an index
    */
    public Card getCardFromIndex(int index) {
        return this.playableCards.get(index);
    }
    
    /*
    Verify if a specific card is playable. The Hand is the information expert
    */
    public boolean isPlayable(Card card) {
        String faceUpCardColor = this.lastFaceUpCard.getColor();
        int faceUpCardValue = this.lastFaceUpCard.getValue();
        if(this.lastFaceUpCard.color.equals("Black")) return true;
        if((card.getColor().equals(faceUpCardColor)) || (card.getValue() == faceUpCardValue) || !(card instanceof NormalCard)) return true;
        return false;
    }
    
    /*
    Update the playableCards
    */
    public void updatePlayableCards() {
        ArrayList<Card> updatedPlayableCards = new ArrayList<>();
        for(Card c : this.cardsInHand) {
            if(this.isPlayable(c)) {
                updatedPlayableCards.add(c);
            }
        }
        this.playableCards = updatedPlayableCards;
    }
    
    
}
