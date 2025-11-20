package com.lucaemanuele.scimmia2.model;

/*
This interface represent the interface for the creation of the Strategies.

It is the interface for Abstract Factory Pattern
*/
public interface IAISelectCardStrategyFactory {
    
    /*
    Return a Strategy based on the difficulty
    */
    public IAISelectCardStrategy createStrategy(String difficulty);
}
