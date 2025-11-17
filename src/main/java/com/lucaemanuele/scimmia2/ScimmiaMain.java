package com.lucaemanuele.scimmia2;

import com.lucaemanuele.scimmia2.model.HumanPlayer;
import com.lucaemanuele.scimmia2.view.MenuView;

public class ScimmiaMain {

    public static void main(String[] args) {
        
        HumanPlayer player = new HumanPlayer("Lucka");
        
        MenuView menuView = new MenuView();
        menuView.startScimmia(player);
        
    }
    
}
