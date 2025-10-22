package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.StandardGame;

public class PlayStandardGameView extends PlayGameView {
    
    @Override
    public void printRules() {
        System.out.println();
        System.out.println("Stai giocando alla modalità Standard");
        System.out.println("L'obiettivo è quello di terminare le carte in mano prima dell'avversario");
        System.out.println("Se le carte nel deck finiscono, allora vince chi ha meno carte in mano");
        System.out.println("Per giocare una carta, deve avere o lo stesso colore o lo stesso numero");
        System.out.println("Esistono carte speciali che possono essere giocate sempre e hanno un effetto. Giocale con consapevolezza!");
        System.out.println("Buon divertimento!");
        System.out.println();
    }
    
    @Override
    public void endTurn() {
        ((StandardGame) this.game).passTurn();
    }
    
}
