package com.example.android.androidlistviewadapterpractice1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mAnimalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAnimalListView = findViewById(R.id.animal_list_view);
        List<Animal> mAnimalList = new ArrayList<Animal>();
        mAnimalListView.setAdapter();

    }
}
