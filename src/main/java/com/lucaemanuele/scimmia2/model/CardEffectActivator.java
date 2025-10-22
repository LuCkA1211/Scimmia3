package com.lucaemanuele.scimmia2.model;

/*
Class which activate the effect of a played card. Introduced for Pure Fabrication
*/
public class CardEffectActivator {
    public void applyEffect(Card cardPlayed, Player currentPlayer, Player nextPlayer, Deck deck) {
        if(!(cardPlayed instanceof NormalCard)) {
            cardPlayed.effect(currentPlayer, nextPlayer, deck);
        }
    }
}
