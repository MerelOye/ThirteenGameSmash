package com.example.mangaramu.thirteengamesmash;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mangaramu on 11/30/2016.
 */

public class menufrag extends Fragment {
    ListView qmenu;
    ArrayList<String>c=new ArrayList<>();
    quitmenusselect quitmenu;
    View v;
    Button quit, back2game;
    ArrayAdapter t;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.menufrag,container,false);
        Resources res = getResources();
          quit= (Button)v.findViewById(R.id.quitbutt);
        back2game= (Button)v.findViewById(R.id.retgamebut);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitmenu.quitmenu(0);
            }
        });
        back2game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitmenu.quitmenu(1);
            }
        });

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
      try
      {
          quitmenu=(quitmenusselect)context;
      }
      catch(ClassCastException e)
      {
          Log.d("Class Exception", "Attaching class must implemtne the quitmenuselectinterface");
      }
        super.onAttach(context);
    }

    public interface quitmenusselect// interface for handling menu selects
    {
        void quitmenu(int f);
    }
}
