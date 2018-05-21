package com.example.android.cs639springhw5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;

public class Second extends AppCompatActivity implements Serializable {

    private static ArrayList<Bio> mBioTab;

    TextView nameTab, bioTab, nameBottom1, nameBottom2, nameBottom3, nameBottom4;
    Button nextBttn, previousBttn;
    int listSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_tab);

        mBioTab = (ArrayList<Bio>) getIntent().getSerializableExtra("bioList");
        //test whether the arraylist has been sent
//        for(int i = 0;i<mBioTab.size();i++){
//            Log.v("tag", "name:" + mBioTab.get(i).getmName());
//            Log.v("tag", "name:" + mBioTab.get(i).getmBio());
//        }


        listSize = mBioTab.size();

        nameTab = (TextView) findViewById(R.id.name_tab);
        bioTab = (TextView) findViewById(R.id.bio_tab);
        nextBttn = (Button) findViewById(R.id.next_tab_button);
        previousBttn = (Button) findViewById(R.id.previous_tab_button);
        nameBottom1 = (TextView) findViewById(R.id.name_tab_bottom_1);
        nameBottom2 = (TextView) findViewById(R.id.name_tab_bottom_2);
        nameBottom3 = (TextView) findViewById(R.id.name_tab_bottom_3);
        nameBottom4 = (TextView) findViewById(R.id.name_tab_bottom_4);


        previousBttn.setVisibility(View.GONE);

        Bundle arg = new Bundle();
        arg.putSerializable("mBioList", mBioTab);
        FragmentA fragmentA = new FragmentA();
        fragmentA.setArguments(arg);


        switch (listSize) {
            case 1:
                nameBottom1.setVisibility(View.VISIBLE);
                nameBottom2.setVisibility(View.GONE);
                nameBottom3.setVisibility(View.GONE);
                nameBottom4.setVisibility(View.GONE);
                nameBottom1.setText(mBioTab.get(0).getmName());
                break;
            case 2:
                nameBottom1.setVisibility(View.VISIBLE);
                nameBottom2.setVisibility(View.VISIBLE);
                nameBottom3.setVisibility(View.GONE);
                nameBottom4.setVisibility(View.GONE);
                nameBottom1.setText(mBioTab.get(0).getmName());
                nameBottom2.setText(mBioTab.get(1).getmName());
                break;
            case 3:
                nameBottom1.setVisibility(View.VISIBLE);
                nameBottom2.setVisibility(View.VISIBLE);
                nameBottom3.setVisibility(View.VISIBLE);
                nameBottom4.setVisibility(View.GONE);
                nameBottom1.setText(mBioTab.get(0).getmName());
                nameBottom2.setText(mBioTab.get(1).getmName());
                nameBottom3.setText(mBioTab.get(2).getmName());
                break;
            case 4:
                nameBottom1.setVisibility(View.VISIBLE);
                nameBottom2.setVisibility(View.VISIBLE);
                nameBottom3.setVisibility(View.VISIBLE);
                nameBottom4.setVisibility(View.VISIBLE);
                nameBottom1.setText(mBioTab.get(0).getmName());
                nameBottom2.setText(mBioTab.get(1).getmName());
                nameBottom3.setText(mBioTab.get(2).getmName());
                nameBottom4.setText(mBioTab.get(3).getmName());
                break;
        }
    }
}


