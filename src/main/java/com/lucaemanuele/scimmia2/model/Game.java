package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public abstract class Game {
    protected boolean isEnded;
    protected Player winner;
    protected Player currentPlayer;
    protected Player nextPlayer;
    protected ArrayList<Player> players;
    protected Table table;
    protected int numberStartingCards;
    protected CardEffectActivator cardEffectActivator;
    protected int indexPlayer;
    protected IDrawRule drawRule;
    
    public Game(HumanPlayer player, DeckDescription deckDesc, String difficulty) {
        this.numberStartingCards = 7;
        player.clearHand();
        this.players = new ArrayList<>();
        this.players.add(player);
        this.table = new Table(deckDesc);
        this.cardEffectActivator = new CardEffectActivator();
        this.winner = null;
        this.isEnded = false;
        this.indexPlayer = 0;
    }
    
    /*
    Set the Draw Rule, after creating it
    */
    public void setDrawRule(IDrawRule drawRule) {
        this.drawRule = drawRule;
    }
    
    /*
    Getter and setter
    */
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
    
    public void createAndSetDrawRule(int numberCardsToDraw, String penalty) {
        this.drawRule = DrawRuleSimpleFactory.getInstance().getDrawRule(numberCardsToDraw, penalty, this);
    }
    
    /*
    Give the first card to each player
    */
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
    
    /*
    Decide the order of the players to take turn, give the first card to them and showing the first faceUpCard
    */
    public Card start() {
        this.assignOrderPlayers();
        this.giveStartingCards();
        this.table.setFirstPlayableCard();
        return this.table.getFaceUpCard();
    }
    
    /*
    Return the faceUpCard
    */
    public Card getFaceUpCard() {
        return this.table.getFaceUpCard();
    }
    
    /*
    To be implemented in every modality, checks whether the game is finished and who is the winner
    */
    public abstract void checkEndGame();
    
    /*
    Assign who is the currentPlayer and the nextPlayer
    */
    public String assignPlayer() {
        this.currentPlayer = this.players.get(this.indexPlayer);
        this.currentPlayer.setHasPlayed(false);
        this.nextPlayer = this.players.get((this.indexPlayer + 1) % this.players.size());
        return this.currentPlayer.getNickname();
    }
    
    /*
    Return the cards in hand of the currentPlayer
    */
    public ArrayList<Card> getCardsInHand() {
        return this.currentPlayer.getCardsInHand();
    }
    
    /*
    Return the playable cards in hand of the currentPlayer
    */
    public ArrayList<Card> getPlayableCards() {
        return this.currentPlayer.getPlayableCards(this.table);
    }
    
    /*
    Play a card given an index (for HumanPlayer will come as an input, for AIPlayer as a random number), activating the effect
    */
    public void playCardFromIndex(int indexCard) {
        this.currentPlayer.playCardFromIndex(indexCard, table);
        this.activateEffect();
    }
    
    /*
    Make a player draw a card, playing it if possible (and activating the effect) and return it to the view.
    
    It will follow theDraw Rule chosen by the player at the creation
    */
    public ArrayList<Card> draw() {
        return this.drawRule.draw();
    }
    
    /*
    Activate the effect of the last played card
    */
    public void activateEffect() {
        Card faceUpCard = this.getFaceUpCard();
        Deck deck = this.table.getDeck();
        cardEffectActivator.applyEffect(faceUpCard, currentPlayer, nextPlayer, deck);
    }
    
    /*
    The currentPlayer passes the turn and the index of the currentPlayer will be updated
    */
    public void passTurn() {
        this.currentPlayer.setHasTakenTurn(false);
        this.indexPlayer = (this.indexPlayer + 1) % this.players.size();
        this.checkEndGame();
    }
    
    /*
    Checks if the currentPlayer has played in his turn
    */
    public boolean hasCurrentPlayerPlayed() {
        return this.currentPlayer.hasPlayed();
    }
    
    /*
    Checks if the currentPlayer has taken the turn
    Useful for Skip Card
    */
    public boolean hasCurrentPlayerTakenTurn() {
        return this.currentPlayer.hasTakenTurn();
    }
    
    /*
    Return the number of cards in the hand for each player
    */
    public HashMap<Player, Integer> getNumberOfCardsInHand() {
        HashMap<Player, Integer> numberCardsInHandPlayer = new HashMap<>();
        for(Player p : this.players) {
            numberCardsInHandPlayer.put(p, p.getCardsInHand().size());
        }
        return numberCardsInHandPlayer;
    }
    
    /*
    Return the number of remaining cards in the deck
    */
    public int getNumberOfCardsInDeck() {
        return this.table.getNumberOfCardsInDeck();
    }
}
