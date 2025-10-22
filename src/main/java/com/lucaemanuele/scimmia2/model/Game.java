package com.lucaemanuele.scimmia2.model;

import com.lucaemanuele.scimmia2.model.*;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Game {
    protected boolean isEnded;
    protected Player winner;
    protected Player currentPlayer;
    protected Player nextPlayer;
    protected ArrayList<Player> players;
    protected Table table;
    protected int numberStartingCards;
    protected CardEffectActivator cardEffectActivator;
    private int indexPlayer;
    
    public Game(HumanPlayer player, DeckDescription deckDesc) {
        this.numberStartingCards = 7;
        AIPlayer aiPlayer = new AIPlayer("AI1");
        AIPlayer aplayer = new AIPlayer("AI2");  // Test purpose
        this.players = new ArrayList<>();
        this.players.add(aplayer);
        this.players.add(aiPlayer);
        this.table = new Table(deckDesc);
        this.cardEffectActivator = new CardEffectActivator();
        this.winner = null;
        this.isEnded = false;
        this.indexPlayer = 0;
    }
    
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    
    public boolean isEnded() {
        return isEnded;
    }

    public void setIsEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }
    
    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
        public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
    
    public void giveStartingCards() {
        for(Player p : this.players) {
            ArrayList<Card> startingCards = this.table.getCardsFromDeck(numberStartingCards);
            p.addCardsToHand(startingCards);
        }
    }
    
    // Choose in what order the players play
    public void assignOrderPlayers() {
        Collections.shuffle(this.players);
    }
    
    public Card start() {
        this.assignOrderPlayers();
        this.giveStartingCards();
        this.table.setFirstPlayableCard();
        return this.table.getFaceUpCard();
    }
    
    public Card getFaceUpCard() {
        return this.table.getFaceUpCard();
    }
    
    public abstract void checkEndGame();
    
    
    public String assignPlayer() {
        this.currentPlayer = this.players.get(this.indexPlayer);
        this.nextPlayer = this.players.get((this.indexPlayer + 1) % this.players.size());
        return this.currentPlayer.getNickname();
    }
    
    public ArrayList<Card> getCardsInHand() {
        return this.currentPlayer.getCardsInHand();
    }
    
    public ArrayList<Card> getPlayableCards() {
        return this.currentPlayer.getPlayableCards(this.table);
    }
    
    public void playCardFromIndex(int indexCard) {
        this.currentPlayer.playCardFromIndex(indexCard, table);
        this.activateEffect();
    }
    
    public Card drawCard() {
        Card cardDrawn = this.currentPlayer.drawCard(table);
        if(this.currentPlayer.hasPlayed()) {
            this.activateEffect();
        }
        return cardDrawn;
    }
    
    public void activateEffect() {
        Card faceUpCard = this.getFaceUpCard();
        Deck deck = this.table.getDeck();
        cardEffectActivator.applyEffect(faceUpCard, currentPlayer, nextPlayer, deck);
    }
    
    public void passTurn() {
        this.currentPlayer.setHasTakenTurn(false);
        this.indexPlayer = (this.indexPlayer + 1) % this.players.size();
        this.checkEndGame();
    }
    
    public boolean hasCurrentPlayerPlayed() {
        return this.currentPlayer.hasPlayed();
    }
    
    public boolean hasCurrentPlayerTakenTurn() {
        return this.currentPlayer.hasTakenTurn();
    }
}
