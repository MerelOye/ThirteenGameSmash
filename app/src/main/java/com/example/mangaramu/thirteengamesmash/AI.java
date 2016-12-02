package com.example.mangaramu.thirteengamesmash;

import java.util.ArrayList;
import java.util.Collections;

public class AI implements Player {
    ThirteenGameLogic gl = new ThirteenGameLogic();
    ArrayList<Integer> cardsSelected = new ArrayList<Integer>();
    ArrayList<Integer> newPlayedCards = new ArrayList<Integer>();

    public ArrayList<Integer> takeTurn(ArrayList<Integer> playPile, ArrayList<Integer> hand) {
        Collections.sort(hand);
        Collections.sort(playPile);
        cardsSelected.clear();
        // If the current card combination is Single
        if (gl.isSingle(playPile)) {
            // Go through the sorted hand
            // If there's a card higher than the one on the play pile, play it
            for (Integer value : hand) {
                cardsSelected.add(value);
                if (gl.checkCardsSelected(playPile, cardsSelected)) {
                    return playCards(cardsSelected);
                } else {
                    cardsSelected.clear();
                }
            }
            // If the current card combination is Double
        } else if (gl.isDouble(playPile)) {
            // Go through the sorted hand
            // If there's a double higher than the one on the play pile, play it
            for (int i = 0; i < hand.size() - 1; i++) {
                cardsSelected.add(hand.get(i));
                cardsSelected.add(hand.get(i + 1));
                if (gl.checkCardsSelected(playPile, cardsSelected)) {
                    return playCards(cardsSelected);
                } else {
                    cardsSelected.clear();
                }
            }
            // If the current card combination is Triple
        } else if (gl.isTriple(playPile)) {
            // Go through the sorted hand
            // If there's a triple higher than the one on the play pile, play it
            for (int i = 0; i < hand.size() - 2; i++) {
                cardsSelected.add(hand.get(i));
                cardsSelected.add(hand.get(i + 1));
                cardsSelected.add(hand.get(i + 2));
                if (gl.checkCardsSelected(playPile, cardsSelected)) {
                    return playCards(cardsSelected);
                } else {
                    cardsSelected.clear();
                }
            }
            // If the current card combination is Straight
        } else if (gl.isStraight(playPile)) {
            // Go through the sorted hand
            // If there's a straight higher than the one on the play pile, play it
            for (int i = 0; i < hand.size() - playPile.size() + 1; i++) {
                for (int j = 0; j < playPile.size(); j++) {
                    cardsSelected.add(hand.get(i + j));
                }
                if (gl.checkCardsSelected(playPile, cardsSelected)) {
                    return playCards(cardsSelected);
                } else {
                    cardsSelected.clear();
                }
            }
        }
        return pass();
    }

    @Override
    public ArrayList<Integer> playCards(ArrayList<Integer> newCards) {
        this.newPlayedCards = newCards;
        return this.newPlayedCards;
    }

    @Override
    public ArrayList<Integer> pass() {
        this.newPlayedCards.clear();
        return this.newPlayedCards;
    }

}
