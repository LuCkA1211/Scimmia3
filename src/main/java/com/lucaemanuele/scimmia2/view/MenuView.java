package com.lucaemanuele.scimmia2.view;

import com.lucaemanuele.scimmia2.controller.MenuHandler;
import com.lucaemanuele.scimmia2.model.PointGame;
import com.lucaemanuele.scimmia2.model.StandardGame;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import java.util.Scanner;

public class MenuView {
    private MenuHandler menuHandler;
    
    public MenuView(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
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
    TODO Standard and Point Custom (first, apply the design pattern)
    */
    /*
    E' l'unica parte che non mi convince molto
    */
    public void startScimmia(HumanPlayer player) {
        PlayStandardGameView sgView = PlayStandardGameView.getInstance();  // Potrebbe essere Singleton
        PlayPointGameView pgView = PlayPointGameView.getInstance();  // Potrebbe essere Singleton
        boolean stopScimmia = false;
        int indexMenu;
        while(!stopScimmia) {
            this.printMenu(player);
            indexMenu = this.getMenuChoice();
            switch(indexMenu) {
                /*
                Factory (Singleton) + Strategy (?)
                */
                case 1:
                    StandardGame sg = this.menuHandler.createStandardGame(player);
                    sgView.setGame(sg);  // Non ricreo la View
                    sgView.play();
                    break;
                case 2:
                    PointGame pg = this.menuHandler.createPointGame(player);
                    pgView.setGame(pg);
                    pgView.play();
                    break;
                default:
                    this.printExitGame();
                    stopScimmia = true;
            }
        }
    }
}
