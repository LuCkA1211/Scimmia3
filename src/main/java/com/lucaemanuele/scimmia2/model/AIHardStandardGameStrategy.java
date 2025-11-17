package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AIHardStandardGameStrategy implements IAISelectCardStrategy {
    
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        
        /*
        Avoid computations
        */
        if(playableCards.size() == 1) {
            return 0;
        }
        
        Random rand = new Random();
        Card lastFaceUpCard = aiPlayer.getHand().getLastFaceUpCard();
        ArrayList<Card> cardsInHand = aiPlayer.getCardsInHand();
        
        /*
        Create HashMap containing occurences for color and value for all cards in hand
        (Try to go in the best direction given the cards in hand)
        */
        HashMap<String, Integer> colorCardsInHandHashMap = new HashMap<>();
        HashMap<Integer, Integer> valueCardsInHandHashMap = new HashMap<>();
        
        /*
        Create ArrayList which splits the playable cards based on value or color
        */
        ArrayList<Card> playableCardsForColor = new ArrayList<>();
        ArrayList<Card> playableCardsForValue = new ArrayList<>();
        
        /*
        "Split" the playableCards
        */
        for(Card c : playableCards) {
            if(c.getColor().equals(lastFaceUpCard.getColor())) {
                playableCardsForColor.add(c);
            }
            if(c.getValue() == lastFaceUpCard.getValue()) {
                playableCardsForValue.add(c);
            }
        }
        
        /*
        Compute the occurencies
        */
        for(Card c: cardsInHand) {
            colorCardsInHandHashMap.merge(c.getColor(), 1, Integer::sum);
            valueCardsInHandHashMap.merge(c.getValue(), 1, Integer::sum);
        }
        
        /*
        Take the choice
        */
        int colorOccurence = 0;
        if(colorCardsInHandHashMap.containsKey(lastFaceUpCard.getColor())) {
            colorOccurence = colorCardsInHandHashMap.get(lastFaceUpCard.getColor());
        }
        
        int valueOccurence = 0;
        if(valueCardsInHandHashMap.containsKey(lastFaceUpCard.getValue())) {
            valueOccurence = valueCardsInHandHashMap.get(lastFaceUpCard.getValue());
        }
        
        if(valueOccurence >= colorOccurence) {
            return rand.nextInt(playableCardsForValue.size());
        } else return rand.nextInt(playableCardsForColor.size());
    }
}
