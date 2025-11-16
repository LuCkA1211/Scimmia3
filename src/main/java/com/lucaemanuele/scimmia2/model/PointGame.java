package com.lucaemanuele.scimmia2.model;

import com.lucaemanuele.scimmia2.model.Card;
import com.lucaemanuele.scimmia2.model.DeckDescription;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.model.Player;
import java.util.HashMap;

public class PointGame extends Game {
    private HashMap<Player, Integer> playerPoints = new HashMap<>();

    public PointGame(HumanPlayer player, DeckDescription deckDesc, String difficulty) {
        super(player, deckDesc, difficulty);
        AIPointGameSelectCardFactory factory = AIPointGameSelectCardFactory.getInstance();
        AIPlayer aiPlayer = new AIPlayer("AI1", factory, difficulty);
        this.players.add(aiPlayer);
        for(Player p : players) {  // Attribute added wrt Game
            this.playerPoints.put(p, 0);
        }
    }

    /*
    Getter and setter
    */
    public HashMap<Player, Integer> getPlayerPoints() {
        return playerPoints;
    }

    /*
    Update the points of the currentPlayer if he has played
    */
    public void updatePoints() {
        if (this.currentPlayer.hasPlayed()) {
            Card playedCard = this.table.getFaceUpCard();
            this.playerPoints.merge(currentPlayer, playedCard.getValue(), Integer::sum);
        }
    }
    
    /*
    Verify if the currentPlayer has reached more than 100 points or has finished the cards in hand or the deck is empty.
    In the case of the last two, verify which player has most point
    */
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
