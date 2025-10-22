package com.lucaemanuele.scimmia2;

import com.lucaemanuele.scimmia2.controller.MenuHandler;
//import com.lucaemanuele.scimmia2.model.DeckDescription;
import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.view.MenuView;

public class ScimmiaMain {

    public static void main(String[] args) {
        
        HumanPlayer player = new HumanPlayer("Lucka");
        //DeckDescription deckDesc = new DeckDescription(5,5,5,5);
        
        MenuHandler menuHandler = new MenuHandler();
        MenuView menuView = new MenuView(menuHandler);
        menuView.startScimmia(player);
        
    }
    
}
