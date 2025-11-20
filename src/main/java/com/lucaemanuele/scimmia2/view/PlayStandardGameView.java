package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.BaseDrawRule;
import com.lucaemanuele.scimmia2.model.GameSimpleFactory;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.model.StandardGame;
import com.lucaemanuele.scimmia2.model.UnlimitedDrawRuleDecorator;

public class PlayStandardGameView extends PlayGameView {
    private static PlayStandardGameView instance = null;
    
    public static PlayStandardGameView getInstance() {
        if(instance == null) {
            instance = new PlayStandardGameView();
        }
        return instance;
    }
    
    private PlayStandardGameView() {
        super();
    }
    
    /*
    Takes as input the choices of the rule of the user in order to create the game and plays it
    */
    @Override
    public void startGame(HumanPlayer player) {
        GameSimpleFactory gsf = GameSimpleFactory.getInstance();
        this.printDifficulty();
        String difficulty = this.getDifficulty();
        this.printNumberCardsToDraw();
        int numberCardsToDraw = this.getNumberCardsToDraw();
        StandardGame sg = gsf.createStandardGame(player, difficulty, numberCardsToDraw);
        this.setGame(sg);
        this.play();
    }
    
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
    
    /*
    Tell the game that the player has ended the turn
    */
    @Override
    public void endTurn() {
        ((StandardGame) this.game).passTurn();
    }
    
}
