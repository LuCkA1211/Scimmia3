package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.Game;
import com.lucaemanuele.scimmia2.model.Card;
import com.lucaemanuele.scimmia2.model.Deck;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.model.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class PlayGameView {
    protected Game game;
    protected Scanner scan = new Scanner(System.in);
    
    protected PlayGameView() {
        
    }
    /*
    Set the current game the player is going to play
    */
    public void setGame(Game game) {
        this.game = game;
    }
        
    public abstract void printRules();
    
    public void printFaceUpCard(Card c) {
        System.out.println("La faceUpCard attuale è " + c.toString());
    }
    
    public void printCurrentPlayer(String nickname) {
        System.out.println("Tocca a " + nickname);
    }
    
    public void printPassTurn() {
        System.out.println("Passo il turno");
    }
    
    public void printNumberDeckCards(Deck deck) {
        System.out.println("Carte rimanenti nel deck: " + deck.getCardsInDeck().size());
        System.out.println();
    }
    
    public void printWinner(Player p) {
        System.out.println("The winner is : " + p.getNickname());
        System.out.println();
    }
    
    public void printPlayedCard(Card c) {
        System.out.println("E' stata giocata la carta " + c.toString());
    }
    
    public void printCards(ArrayList<Card> cardsInHand) {
        int counter = 1;
        for(Card c : cardsInHand) {
            System.out.print(counter + ") ");
            System.out.println(c.toString());
            counter++;
        }
        System.out.println();
    }
    
    public void printPlayableCards(ArrayList<Card> playableCards) {
        if(playableCards.isEmpty()) {
            System.out.println("Non hai carte giocabili, devi pescare");
        } else {
            System.out.println("Le tue playable cards sono: ");
            printCards(playableCards);
            System.out.println("Quale carta giochi? Inserisci il numero sequenziale.");
        }
    }
    
    public void printDifficulty() {
        System.out.println("Seleziona la difficoltà");
        System.out.println("1) Easy");
        System.out.println("2) Hard");
    }
    
    public void printNumberCardsToDraw() {
        System.out.println("Inserisci il numero di carte massimo da pescare quando non hai carte giocabili");
        System.out.println("Se non vuoi avere limiti inserisci -1");
    }
    
    public int getPlayableCard() {
        int indexCardPlay = this.scan.nextInt();
        this.scan.nextLine();
        return indexCardPlay - 1;
    }
    
    public String getDifficulty() {
        int difficultyInt = this.scan.nextInt();
        this.scan.nextLine();
        HashMap <Integer, String> difficultyMap = new HashMap<>();
        difficultyMap.put(1, "Easy");
        difficultyMap.put(2, "Hard");
        return difficultyMap.get(difficultyInt);
    }
    
    public int getNumberCardsToDraw() {
        int numberCardsToDraw = this.scan.nextInt();
        this.scan.nextLine();
        return numberCardsToDraw;
    }

    public void printDrawnCards(ArrayList<Card> drawnCards) {
        System.out.print("Hai pescato: ");
        for(int i = 0; i < drawnCards.size(); i++) {
            System.out.print(drawnCards.get(i).toString());
            if((drawnCards.size() != 1) && (i != (drawnCards.size() - 1))) {
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println();
    }
    
    public void printEffect(Card cardPlayed) {
        System.out.println(cardPlayed.descriptionEffect());
        System.out.println();
    }
    
    public abstract void startGame(HumanPlayer player);
    
    /*
    Interaction between player and game.
    Represent the classic mechanic of the game
    */
    public void play() {
        this.printRules();
        Card faceUpCard = this.game.start();
        this.printFaceUpCard(faceUpCard);
        while(!this.game.isEnded()) {
            this.takeTurn();
        }
        Player winner = this.game.getWinner();
        this.printWinner(winner);
    }
    
    /*
    Describe the interaction between player and the game in order to take a turn.
    See System Diagram
    */
    public void takeTurn() {
        int indexCard = 0;
        String nicknameCurrentPlayer = this.game.assignPlayer();
        if(!this.game.hasCurrentPlayerTakenTurn()) {
            this.printCurrentPlayer(nicknameCurrentPlayer);
            ArrayList<Card> cardsInHand = this.game.getCardsInHand();
            ArrayList<Card> playableCards = this.game.getPlayableCards();
            if(this.game.getCurrentPlayer() instanceof HumanPlayer) {
                this.printCards(cardsInHand);
                this.printPlayableCards(playableCards);
            }
            if(!playableCards.isEmpty()) {
                if(this.game.getCurrentPlayer() instanceof HumanPlayer) {
                    indexCard = this.getPlayableCard();
                }
                this.game.playCardFromIndex(indexCard);
            } else {
                ArrayList<Card> drawnCards = this.game.draw();
                if(this.game.getCurrentPlayer() instanceof HumanPlayer) {
                    this.printDrawnCards(drawnCards);
                }
            }
            if(this.game.hasCurrentPlayerPlayed()) {
                Card cardPlayed = this.game.getFaceUpCard();
                this.printPlayedCard(cardPlayed);
                this.printEffect(cardPlayed);
            }
        }
        this.endTurn();
    }
    
    /*
    Describe what happens at the end of the turn.
    To be implemented in each modality
    */
    public abstract void endTurn();
        
}
