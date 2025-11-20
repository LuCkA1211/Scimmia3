package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
Class which implement the Strategy for Hard Mode for Standard modality, in particular the selection of the card from AI.

This Strategy select a card based on the the cards in the hand, and it is based on how a human player plays the card normally.
If AIPlayer has a special card, plays it, otherwise it plays a card with a precise strategy.
In the latter case, it computes how many cards of the same color and how many of the same value it has;
then, it sees if it has more cards with the same color or the same value of the faceUpCard;
then, it plays a random card with the same color, if it has more cards with the same color, or with the same value otherwise.

This class represent the ConcreteStrategy of Startegy Design Pattern
*/

public class AIHardStandardGameStrategy implements IAISelectCardStrategy {
    Random rand = new Random();
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        
        /*
        Avoid computations
        */
        if(playableCards.size() == 1) {
            return 0;
        }
        
        /*
        Return always the first special card if it has one in hand
        */
        for(Card c : playableCards) {
            if(!(c instanceof NormalCard)) {
                return playableCards.indexOf(c);
            }
        }
        
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
        
        /*
        If the faceUpCard is special and AIPlayer has not special, play a random card.
        Could be improved
        */
        if(!(lastFaceUpCard instanceof NormalCard)) {
            return rand.nextInt(playableCards.size());
        }
        
        /*
        Get how many cards the AIPlayer has in its hand with the same color of the faceUpCard
        */
        int colorOccurence = 0;
        if(colorCardsInHandHashMap.containsKey(lastFaceUpCard.getColor())) {
            colorOccurence = colorCardsInHandHashMap.get(lastFaceUpCard.getColor());
        }
        
        /*
        Get how many cards the AIPlayer has in its hand with the same value/number of the faceUpCard
        */
        int valueOccurence = 0;
        if(valueCardsInHandHashMap.containsKey(lastFaceUpCard.getValue())) {
            valueOccurence = valueCardsInHandHashMap.get(lastFaceUpCard.getValue());
        }
        
        /*
        If it has more playable cards with the same number respect to same color, take a random card with the same value
        Else take a random card with the same color.
        */
        int indexPlay = 0;
        Card cardToPlay = null;
        if(valueOccurence >= colorOccurence) {
            indexPlay = rand.nextInt(playableCardsForValue.size());  // Map index random to index of playableCards
            cardToPlay = playableCardsForValue.get(indexPlay);
        } else {
            indexPlay = rand.nextInt(playableCardsForColor.size());
            cardToPlay = playableCardsForColor.get(indexPlay);
        }
        
        return playableCards.indexOf(cardToPlay);
    }
}
