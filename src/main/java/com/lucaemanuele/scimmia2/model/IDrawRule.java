package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;

public interface IDrawRule {
    public ArrayList<Card> draw();
    
    public Game getGame();
}
