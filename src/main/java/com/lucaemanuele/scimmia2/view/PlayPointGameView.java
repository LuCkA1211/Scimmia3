package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.PointGame;
import com.lucaemanuele.scimmia2.model.Player;
import java.util.HashMap;

public class PlayPointGameView extends PlayGameView {
    
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
    
    @Override
    public void endTurn() {
        ((PointGame) this.game).passTurn();
        HashMap<Player, Integer> playerPoints = ((PointGame) this.game).getPlayerPoints();
        this.printActualPoints(playerPoints);
    }
    
}
