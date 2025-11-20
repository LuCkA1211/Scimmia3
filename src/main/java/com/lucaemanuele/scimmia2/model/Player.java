package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
Class which implements the common features of AIPlayer and HumanPlayer
*/

public abstract class Player {
    protected Hand hand;
    protected String nickname;
    protected boolean hasPlayed;
    protected boolean hasTakenTurn;

    public Player(String nickname) {
        this.hand = new Hand();
        this.nickname = nickname;
        this.hasPlayed = false;
        this.hasTakenTurn = false;
    }
    /*
    Getter and setter
    */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public boolean hasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }

    public boolean hasTakenTurn() {
        return hasTakenTurn;
    }

    public void setHasTakenTurn(boolean hasTakenTurn) {
        this.hasTakenTurn = hasTakenTurn;
    }
    
    /*
    Add cards to the hand
    */
    public void addCardsToHand(ArrayList<Card> cardToBeAdded) {
        this.hand.addCards(cardToBeAdded);
    }
    
    public abstract void playCardFromIndex(int indexCard, Table table);
    
    /*
    Set that the player is taking the turn (not played yet)
    */
    public void startTurn() {
        this.hasPlayed = false;
        this.hasTakenTurn = true;
    }
    
    /*
    Obtain the playable cards from the hand, giving to it the current FaceUpCard
    Useful to avoid the coupling of Hand and Table
    */
    public ArrayList<Card> getPlayableCards(Table table) {
        Card faceUpCard = table.getFaceUpCard();
        this.hand.setLastFaceUpCard(faceUpCard);
        ArrayList<Card> playableCards = this.hand.getPlayableCards();
        return playableCards;
    }
    
    /*
    Return the cards from its hand
    */
    public ArrayList<Card> getCardsInHand() {
        return this.hand.getCardsInHand();
    }
    
    /*
    Set the cards of its hand
    */
    public void setCardsInHand(ArrayList<Card> cards) {
        this.hand.setCardsInHand(cards);
    }
    
    /*
    Draw a card.
    Useful to avoid the coupling of Hand and Table, or Hand and Deck
    */
    public Card drawCard(Table table) {
        Card drawnCard = table.drawCardFromDeck();
        this.handleDrawnCard(drawnCard, table);
        return drawnCard;
    }
    
    /*
    Verify if the drawn card is playable
    */
    public boolean isDrawnCardPlayable(Card drawnCard) {
        return this.hand.isPlayable(drawnCard);
    }
    
    /*
    Plays a specific card
    */
    public void playCard(Card cardToBePlayed, Table table) {
        table.playCard(cardToBePlayed);
        this.hasPlayed = true;
        this.hand.removeCard(cardToBePlayed);
    }
    
    /*
    If the drawn card is playable, then he plays it, otherwise he adds it to the hand
    */
    public void handleDrawnCard(Card drawnCard, Table table) {
        this.hand.addCard(drawnCard);
        if(this.hand.isPlayable(drawnCard)) {
            this.playCard(drawnCard, table);
        }
    }
    
    /*
    Return if he has finished the cards in hand
    */
    public boolean noCardsInHand() {
        return this.hand.getCardsInHand().isEmpty();
    }
    
}
