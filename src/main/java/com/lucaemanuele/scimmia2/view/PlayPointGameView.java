package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.GameSimpleFactory;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.model.PenaltyOnDrawnCardsDrawRuleDecorator;
import com.lucaemanuele.scimmia2.model.PointGame;
import com.lucaemanuele.scimmia2.model.Player;
import com.lucaemanuele.scimmia2.model.UnlimitedDrawRuleDecorator;
import com.lucaemanuele.scimmia2.model.BaseDrawRule;
import java.util.HashMap;

public class PlayPointGameView extends PlayGameView {
    private static PlayPointGameView instance = null;
    
    public static PlayPointGameView getInstance() {
        if(instance == null) {
            instance = new PlayPointGameView();
        }
        return instance;
    }
    
    private PlayPointGameView() {
        super();
    }
    
    @Override
    public void startGame(HumanPlayer player) {
        GameSimpleFactory gsf = GameSimpleFactory.getInstance();
        this.printDifficulty();
        String difficulty = this.getDifficulty();
        this.printNumberCardsToDraw();
        int numberCardsToDraw = this.getNumberCardsToDraw();
        this.printPenalty();
        String penalty = this.getPenalty();
        PointGame pg = gsf.createPointGame(player, difficulty);
        PenaltyOnDrawnCardsDrawRuleDecorator drawRule = new PenaltyOnDrawnCardsDrawRuleDecorator(new UnlimitedDrawRuleDecorator(new BaseDrawRule(pg)));
        pg.setDrawRule(drawRule);
        this.setGame(pg);
        this.play();
    }
    
    public void printPenalty() {
        System.out.println("Vuoi inserire la penalità di 5 punti per ogni carta pescata?");
        System.out.println("Scrivi Y se la vuoi, N se non la vuoi");
    }
    
    public String getPenalty() {
        String penalty = this.scan.nextLine();
        return penalty;
    }
    
    public void printActualPoints(HashMap<Player, Integer> playerPoints) {
        System.out.println("I punteggi attuali sono: ");
        playerPoints.forEach((p, points) -> {
            System.out.println(p.getNickname() + ": " + points);
        });
    }

    @Override
    public void printRules() {
        System.out.println();
        System.out.println("Stai giocando alla modalità a punti");
        System.out.println("L'obiettivo è quello di raggiungere 100 punti prima dell'avversario");
        System.out.println("Per giocare una carta, deve avere o lo stesso colore o lo stesso numero");
        System.out.println("Le carte speciali possono essere giocate sempre e hanno un effetto");
        System.out.println("Ricorda che le carte hanno il punteggio uguale al numero raffigurato sulla carta. Se sono speciali, valgono 10 punti");
        System.out.println("Se un giocatore termina le carte in mano o finiscono le carte nel deck, allora il gioco termina e vince chi ha totalizzato più punti");
        System.out.println();
    }
    
    /*
    Tell the PointGame to update the point and show the total points of each player
    */
    @Override
    public void endTurn() {
        ((PointGame) this.game).passTurn();
        HashMap<Player, Integer> playerPoints = ((PointGame) this.game).getPlayerPoints();
        this.printActualPoints(playerPoints);
    }
    
}
