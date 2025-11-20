package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

/*
This interface define a common interface for DrawRule objects
*/
public interface IDrawRule {
    
    /*
    Functionality to be extended
    */
    public ArrayList<Card> draw();
    
    public Game getGame();
}
