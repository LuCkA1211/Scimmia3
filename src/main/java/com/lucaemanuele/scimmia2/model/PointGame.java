package com.lucaemanuele.scimmia2.model;

import java.util.HashMap;

public class PointGame extends Game {
    private HashMap<Player, Integer> playerPoints = new HashMap<>();
    private int pointsToWin = 100;

    public PointGame(HumanPlayer player, DeckDescription deckDesc, String difficulty, int numberCardsToDraw, String penalty) {
        super(player, deckDesc, difficulty, numberCardsToDraw, penalty);
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
            this.updatePlayerPoints(this.currentPlayer, playedCard.getValue());
        }
    }
    
    /*
    Verify if the currentPlayer has reached more than 100 points or has finished the cards in hand or the deck is empty.
    In the case of the last two, verify which player has most point
    */
    @Override
    public void checkEndGame() {
        this.updatePoints();
        if(this.playerPoints.get(this.currentPlayer) >= this.pointsToWin) {
            this.winner = this.currentPlayer;
            this.isEnded = true;
        } else if((this.currentPlayer.noCardsInHand()) || (this.table.emptyDeck())) {
            this.isEnded = true;
            int[] maxPoints = {-1};  // Otherwise there would be error, since the local variables can't be updated inside lambda
            this.playerPoints.forEach((p, points) -> {
                if(points > maxPoints[0]) {
                    this.winner = p;
                    maxPoints[0] = points;
                };
        });
        }
    }
    
    public void updatePlayerPoints(Player player, int pointsToRemove) {
        this.playerPoints.merge(this.getCurrentPlayer(), pointsToRemove, Integer::sum);
    }
    
    public int getSpecificPlayerPoints(Player player) {
        return this.playerPoints.get(player);
    }
    
}
