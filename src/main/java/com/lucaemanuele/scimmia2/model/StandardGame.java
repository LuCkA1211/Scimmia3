package com.lucaemanuele.scimmia2.model;

import com.lucaemanuele.scimmia2.model.*;
import java.util.ArrayList;

public class StandardGame extends Game {
    
    public StandardGame(HumanPlayer player, DeckDescription deckDesc) {
        super(player, deckDesc);
    }
        
        
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
