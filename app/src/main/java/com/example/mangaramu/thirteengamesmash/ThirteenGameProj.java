package com.example.mangaramu.thirteengamesmash;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class ThirteenGameProj extends Activity implements TitleScreen.buttonselect,menufrag.quitmenusselect, GameUI.gamebutton{
    FragmentManager fm;
    FragmentTransaction ft;
    GameUI thirgame = new GameUI();
    TitleScreen thirmenu = new TitleScreen();
    menufrag menfr=new menufrag();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getFragmentManager();
        fm.beginTransaction().add(R.id.gamehold,thirmenu).commit();
        fm.executePendingTransactions();

    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void singlemultibutton(int x) { //takes in an int passed by a the titlescreen fragment then changes fragement to what that value corrisponds to
        switch (x){ // to see which button was pressed from the title menu
            case 0:
                fm.beginTransaction().replace(R.id.gamehold,thirgame).commit();
                fm.executePendingTransactions();
                break;
            case 1:
                break;
            default:
                break;
        }

    }

    @Override
    public void quitmenu(int f) { //takes in an int passed by a the game fragment then changes fragement to what that value corrisponds to
        switch (f){
            case 0:

                fm.beginTransaction().replace(R.id.gamehold,thirmenu).remove(menfr).commit();
                fm.executePendingTransactions();
                break;
            case 1:
                fm.beginTransaction().remove(menfr).commit();
                fm.executePendingTransactions();
                break;
            default:
                break;
        }

    }

    @Override
    public void gamebuttonclick(int x) {
        switch (x){ //takes in an int passed by a the menufrag game menu fragment then changes fragement to what that value corrisponds to
            case 0://play
                break;
            case 1://pass
                break;
            case 2:

                    fm.beginTransaction().add(android.R.id.content, menfr).commit();
                    fm.executePendingTransactions();

            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if(fm.findFragmentById(android.R.id.content) instanceof menufrag)// check if our fragment within android.R.id.content is an instanceof menufrag so we can change back button behavior
        {
            fm.beginTransaction().remove(menfr).commit();
            fm.executePendingTransactions();
        }
        else if(fm.findFragmentById(R.id.gamehold) instanceof GameUI)
        {
            fm.beginTransaction().add(android.R.id.content, menfr).commit();
            fm.executePendingTransactions();
        }
        else {
            super.onBackPressed();
        }
    }
}
