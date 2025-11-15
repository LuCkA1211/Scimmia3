package com.lucaemanuele.scimmia2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
        Algorithm inspired from StackOverflow (weighted random selection from array)
        */
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
