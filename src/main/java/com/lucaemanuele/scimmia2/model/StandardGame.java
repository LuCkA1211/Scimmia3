package com.lucaemanuele.scimmia2.model;

//import com.lucaemanuele.scimmia2.model.*;
//import java.util.ArrayList;

public class StandardGame extends Game {
    
    public StandardGame(HumanPlayer player, DeckDescription deckDesc, String difficulty) {
        super(player, deckDesc, difficulty);
        AIStandardGameSelectCardFactory factory = AIStandardGameSelectCardFactory.getInstance();
        AIPlayer aiPlayer = new AIPlayer("AI1", factory, difficulty);
        this.players.add(aiPlayer);
    }
        
    /*
    Verify if the currentPlayer has no card in the hand or there are no card in deck.
    In the case of the latter, the winner is the player which has less card in hand
    */    
    @Override
    public void checkEndGame() {
        if(this.currentPlayer.noCardsInHand()) {
            this.winner = this.currentPlayer;
            this.isEnded = true;
        } else if(this.table.emptyDeck()) {
            this.isEnded = true;
            int minNumberCards = 100;
            for(Player p : this.players) {
                if(p.getCardsInHand().size() < minNumberCards) {  // Per il momento no pareggio
                    this.winner = p;
                    minNumberCards = p.getCardsInHand().size();
                }
            }
        }
    }
}
