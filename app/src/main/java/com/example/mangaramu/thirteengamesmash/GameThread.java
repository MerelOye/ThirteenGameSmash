package com.example.mangaramu.thirteengamesmash;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mangaramu on 11/29/2016.
 */

public class GameThread implements Runnable {

    ArrayList<Player> players = new ArrayList<Player>();
    ThirteenGameLogic gameLogic = new ThirteenGameLogic();
    ArrayList<ArrayList<Integer>> playerHands = new ArrayList<ArrayList<Integer>>();// playerhand's number is s
    ArrayList<Integer> deck = new ArrayList<Integer>();
    ArrayList<Integer> PlayPile = new ArrayList<Integer>();
    Map<Integer, Boolean> passedCounter = new HashMap<Integer, Boolean>();

    boolean rungame=true;
    ThirteenCardsSelected cards= new ThirteenCardsSelected();
    GameState state=new GameState();
    Handler[] uihandlers; //0 is gameuihandler
    //0 is gameStateHandler 1 is cardsSelectedHandler 2 is uiUpdatedHandler

    Handler isfinnished = new Handler(){// gets
        @Override
        public void handleMessage(Message msg) {
          boolean done=(Boolean)msg.obj; /// message from gameui should be a boolean that we set.. then when we are done we set it back to the default
        }
    };



    Handler[] gamethreadhandlers = {isfinnished};

    public GameThread(Handler[] x)
    {
        uihandlers=x;
    }

    public Handler[] gethandlers()
    {
        return gamethreadhandlers;
    }


    @Override
    public void run() {


        while(rungame)
        {
        //sendmessageto(uihandlers[0],gameLogic); sends gamelogic(ThirteenGameLogic) to gameuihandls
         //   sendmessageto(uihandlers[1],cards); sends to cards(ThirteenCardsSelected) to carduihandle

        }
    }

    void stopgame()
    {

        rungame=false;
    }
    private void sendmessageto(Handler x,Object f)// method to send messages with a object to a handler
    {
        Message m = Message.obtain();
        m.obj=f;
        m.setTarget(x);
        m.sendToTarget();
    }
    public ArrayList<ArrayList<Integer>>  game_init() // initilize the game's objects
    {
        players.add(new Human());
        players.add(new AI());
        players.add(new AI());
        players.add(new AI());

        for (int i = 0; i < 4; i++) {
            playerHands.add(new ArrayList<Integer>());
            passedCounter.put(i, false);
        }

        for (int i = 0; i < 52; i++) {
            deck.add(i);
        }

        deck = new ShuffleCards().shuffle(deck);

        int j = 0;
        for (int i = 0; i < 52; i++) {
            j = i / 13;
            playerHands.get(j).add(deck.get(i));
        }

        Collections.sort(playerHands.get(0));
        return playerHands;
        //sendmessageto(uihandlers[0],gameLogic);// after the game init we send an intial gamestate!
    }
    private ThirteenGameLogic getThirteenGameLogic() // should only be called after gameinit is called
    {
    return gameLogic;
    }
}
