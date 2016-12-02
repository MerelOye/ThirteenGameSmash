package com.example.mangaramu.thirteengamesmash;

import java.util.ArrayList;

/**
 * Created by mangaramu on 11/29/2016.
 */

public interface Player {
//    ArrayList<Integer> takeTurn(ArrayList<Integer> playedCards, ArrayList<Integer> cards);

    ArrayList<Integer> playCards(ArrayList<Integer> cards);

    ArrayList<Integer> pass();
}
