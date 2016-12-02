package com.example.mangaramu.thirteengamesmash;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mangaramu on 11/29/2016.
 */

public class GameUI extends Fragment {


    Map<Integer, Integer> cardMapping = new ThirteenGameLogic().generateCardMapping();

    ArrayList<ImageView> CardsInHand = new ArrayList<ImageView>();

    ViewGroup.MarginLayoutParams cardMargins;

    GameThread newgame; //our gamethread object

    View v;
    Button play, pass, menu;
    ListView playerHand;
    ListView recentPlay;
    ImageView card2left;
    ImageView card2front;
    ImageView card2right;
    View card1, card2;
    int cardNumber;
    gamebutton f;

    Handler gameuihandle = new Handler() // handler for the game ui stuff;
    {
        @Override
        public void handleMessage(Message msg) {
            updategameui( v, (GameState)msg.obj);
        }
    };
    Handler carduihandle =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            updateplayerhandui(v,(ThirteenCardsSelected)msg.obj);

        }
    };
    Handler[] threadtalk;
    Handler[] Uitalk={gameuihandle,carduihandle}; // Uitalk object


    @Override
    public void onAttach(Context context) {
        try {
            f = (gamebutton) context;
        } catch (ClassCastException e) {
            Log.d("Class Exception", "Attaching class needs to implement the gamebutton interface ");
        }
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fraggame, container, false);
        play = (Button) v.findViewById(R.id.playbutt);
        pass = (Button) v.findViewById(R.id.passbutt);
        menu = (Button) v.findViewById(R.id.menubutton);
        card2front = (ImageView) v.findViewById(R.id.hand2front);
        card2left = (ImageView) v.findViewById(R.id.hand2left);
        card2right = (ImageView) v.findViewById(R.id.hand2right);
        newgame = new GameThread(Uitalk);// creation of the gamethread
        threadtalk=newgame.gethandlers();//gets the thread handlers  0 should be isfinnished
        ArrayList<ArrayList<Integer>> playerHands= newgame.game_init(); // initilize the game and get the player hands


        ImageView card1 = (ImageView) v.findViewById(R.id.card1);
        ImageView card2 = (ImageView) v.findViewById(R.id.card2);
        ImageView card3 = (ImageView) v.findViewById(R.id.card3);
        ImageView card4 = (ImageView) v.findViewById(R.id.card4);
        ImageView card5 = (ImageView) v.findViewById(R.id.card5);
        ImageView card6 = (ImageView) v.findViewById(R.id.card6);
        ImageView card7 = (ImageView) v.findViewById(R.id.card7);
        ImageView card8 = (ImageView) v.findViewById(R.id.card8);
        ImageView card9 = (ImageView) v.findViewById(R.id.card9);
        ImageView card10 = (ImageView) v.findViewById(R.id.card10);
        ImageView card11 = (ImageView) v.findViewById(R.id.card11);
        ImageView card12 = (ImageView) v.findViewById(R.id.card12);
        ImageView card13 = (ImageView) v.findViewById(R.id.card13);

        CardsInHand.add(card1);
        CardsInHand.add(card2);
        CardsInHand.add(card3);
        CardsInHand.add(card4);
        CardsInHand.add(card5);
        CardsInHand.add(card6);
        CardsInHand.add(card7);
        CardsInHand.add(card8);
        CardsInHand.add(card9);
        CardsInHand.add(card10);
        CardsInHand.add(card11);
        CardsInHand.add(card12);
        CardsInHand.add(card13);


//        ViewGroup.MarginLayoutParams cardMargins = (ViewGroup.MarginLayoutParams) CardsInHand.get(0).getLayoutParams();
//        cardMargins.topMargin = 20;
//        CardsInHand.get(0).setLayoutParams(cardMargins);

//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) CardsInHand.get(0).getLayoutParams();
//        lp.topMargin = lp.topMargin - 20;
//        CardsInHand.get(0).setLayoutParams(lp);

        final Map<Integer, Boolean> shiftedUp = new HashMap<Integer, Boolean>();

        for (int i = 0; i < 13; i++) {
            shiftedUp.put(i, false);
        }

        for (int i = 0; i < 13; i++) {
            cardNumber = i;
            CardsInHand.get(i).setOnClickListener(new View.OnClickListener() {
                int temp = cardNumber;

                @Override
                public void onClick(View v) {
                    cardMargins = (ViewGroup.MarginLayoutParams) CardsInHand.get(temp).getLayoutParams();
                    //TransitionManager.beginDelayedTransition(container);
                    if (!shiftedUp.get(temp)) {
                        cardMargins.bottomMargin = cardMargins.bottomMargin + 20;
                        shiftedUp.put(temp, true);
                    } else {
                        cardMargins.bottomMargin = cardMargins.bottomMargin - 20;
                        shiftedUp.put(temp, false);
                    }
                    CardsInHand.get(temp).setLayoutParams(cardMargins);
                }

            });
            CardsInHand.get(i).setBackgroundResource(cardMapping.get(playerHands.get(0).get(i)));
        }

        //for to fill the deck with integers
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.gamebuttonclick(0);// --FIXME may not be like this when implement actual game

            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.gamebuttonclick(1);// --FIXME may not be like this when implement actual game
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.gamebuttonclick(2);

            }

        });
//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Something happened","something number 1");
//
//            }
//        });
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //players.clear();
        //playerHands.clear();
        //deck.clear();
        CardsInHand.clear();
    }

    public interface gamebutton { // interface for handling menu selects
        void gamebuttonclick(int x);
    }

    public void updategameui(View f, GameState d)//should update the player's cards and the playpile and should only be called if there is something to change!  //TODO -- needs code for when things get played!
    {
        ArrayList<ArrayList<Integer>> tmpplayerHands = d.playerHands;
        ArrayList<Integer> tmpcardsplayed = d.cardsplayed;
        int tmpplayer = d.player;




    }
    public void updateplayerhandui(View f, ThirteenCardsSelected d)//FIXME needs actual code!
    {
        ArrayList<Integer>tmpcarsselect=d.cardsslected;
        int tmpplayer = d.player;


    }


}
