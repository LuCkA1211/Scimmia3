package com.lucaemanuele.scimmia2.model;

import com.lucaemanuele.scimmia2.model.Card;
import com.lucaemanuele.scimmia2.model.DeckDescription;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.model.Player;
import java.util.HashMap;

public class PointGame extends Game {
    private HashMap<Player, Integer> playerPoints = new HashMap<>();

    public PointGame(HumanPlayer player, DeckDescription deckDesc) {
        super(player, deckDesc);
        for(Player p : players) {
            this.playerPoints.put(p, 0);
        }
    }

    public HashMap<Player, Integer> getPlayerPoints() {
        return playerPoints;
    }

    public void updatePoints() {
        if (this.currentPlayer.hasPlayed()) {
            Card playedCard = this.table.getFaceUpCard();
            this.playerPoints.merge(currentPlayer, playedCard.getValue(), Integer::sum);
        }
    }
    
    @Override
    public void checkEndGame() {
        this.updatePoints();
        if(this.playerPoints.get(this.currentPlayer) >= 100) {
            this.winner = this.currentPlayer;
            this.isEnded = true;
        } else if((this.currentPlayer.getHand().getCardsInHand().isEmpty()) || (this.table.getDeck().getCardsInDeck().isEmpty())) {
            int maxPoints = -1;
            this.playerPoints.forEach((p, points) -> {
                if(points > maxPoints) {
                    this.winner = p;
                };
        });
        }
    }
    
}
