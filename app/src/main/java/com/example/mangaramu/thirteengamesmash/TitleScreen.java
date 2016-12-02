package com.example.mangaramu.thirteengamesmash;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mangaramu on 11/29/2016.
 */

public class TitleScreen extends Fragment {

    View v;
    Button singleplayer;
    Button multiplayer;
    buttonselect menubuttons;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragtitle,container,false);
        singleplayer=(Button)v.findViewById(R.id.singleButton);
        multiplayer= (Button)v.findViewById(R.id.multibutton);

        //for to fill the deck with integers

        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menubuttons.singlemultibutton(0);

            }
        });

        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
    }

    public interface buttonselect { // interface for handling menu selects
        void singlemultibutton(int x);
    }

    @Override
    public void onAttach(Context context) { // checks to see if the attaching class implemented the button select interface
        try {
            menubuttons = (buttonselect) context;

        } catch (ClassCastException x) {
            Log.d("Class Cast Error", "Attaching class must implement the buttonselect interface");

        }
        super.onAttach(context);
    }
}
