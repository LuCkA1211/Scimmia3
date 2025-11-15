package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.model.GameSimpleFactory;
import com.lucaemanuele.scimmia2.model.PointGame;
import com.lucaemanuele.scimmia2.model.StandardGame;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import java.util.Scanner;

public class MenuView {
    
    public MenuView() {
        
    }
    public void printMenu(HumanPlayer p) {
        System.out.println("Bentornato " + p.getNickname() + "!");
        System.out.println("Cosa vuoi fare oggi?");
        System.out.println("1) Standard Game");
        System.out.println("2) Point Game");
        System.out.println("3) Standard Game con custom deck");
        System.out.println("4) Point Game con custom deck");
        System.out.println("Se vuoi uscire inserisci un numero diverso");
        System.out.println("Inserisci il numero sequenziale");
    }
    
    public int getMenuChoice() {
        Scanner scan = new Scanner(System.in);
        int indexMenu = scan.nextInt();
        return indexMenu;
    }
    
    public void printExitGame() {
        System.out.println("Ciao! Alla prossima!");
    }
    
    /*
    While the player won't stop to play, create the modality based on the input.
    */
    public void startScimmia(HumanPlayer player) {
        PlayStandardGameView sgView = PlayStandardGameView.getInstance();
        PlayPointGameView pgView = PlayPointGameView.getInstance();
        boolean stopScimmia = false;
        int indexMenu;
        while(!stopScimmia) {
            this.printMenu(player);
            indexMenu = this.getMenuChoice();
            switch(indexMenu) {
                case 1:
                    sgView.startGame(player);
                    break;
                case 2:
                    pgView.startGame(player);
                    break;
                default:
                    this.printExitGame();
                    stopScimmia = true;
            }
        }
    }
}
