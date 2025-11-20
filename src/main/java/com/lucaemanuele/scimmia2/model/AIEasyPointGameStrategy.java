package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
Class which implement the Strategy for Easy Mode for Point modality, in particular the selection of the card from AI

This strategy makes a weighted selection and is inspired from StackOverflow (weighted random selection from array),
but it should be a known algorithm.

More precisely, this strategy first sort the playable cards by value in increasing order;
then, it computes the weight in a way that the last elements of the ArrayList are more probable to be selected;
then, since the weights are normalized, and so between 0 and 1, the strategy select a random number between 0 and 1;
then use this number to find the element to be chosen (selecting the first element with the weight smaller than the random number).

This class represent the ConcreteStrategy of Strategy Design Pattern
*/

public class AIEasyPointGameStrategy implements IAISelectCardStrategy {
    
    @Override
    public int selectCardToPlay(AIPlayer aiPlayer) {
        Random rand = new Random();
        ArrayList<Card> playableCards = aiPlayer.getHand().getPlayableCards();
        
        /*
        Sort the playableCards by value (increasing order)
        */
        ArrayList<Card> sortedPlayableCards = new ArrayList<>(playableCards);
        Collections.sort(sortedPlayableCards, Comparator.comparing(Card::getValue));
        double weights[] = new double[playableCards.size()];
        double sumCoefficients = 0;
        
        /*
        Compute the weights and the sum of the coefficients.
        The sum is computed in an increasing order, since the last elements are the most valuable
        */
        for(int i = 0; i < weights.length; i++) {
            weights[i] = i + 1;
            sumCoefficients += weights[i];
        }
        
        /*
        Normalization
        */
        for(int i = 0; i < weights.length; i++) {
            weights[i] /= sumCoefficients;
        }
        
        /*
        Obtain random fp element in (0;1)
        */
        double randomNumber = rand.nextDouble();
        
        /*
        Find the element
        */
        int maxIndex = 0;
        for(int i = 0; i < weights.length; i++) {
            if(weights[i] < randomNumber) {
                maxIndex = i;
            } else break;
        }
        
        /*
        Obtain the index of the card in playableCards, given the index in sortedPlayableCards
        */
        Card cardToPlay = sortedPlayableCards.get(maxIndex);
        int index = playableCards.indexOf(cardToPlay);
        return index;
    }
}
