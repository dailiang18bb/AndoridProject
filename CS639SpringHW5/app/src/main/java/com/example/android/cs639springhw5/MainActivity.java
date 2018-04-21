package com.example.android.cs639springhw5;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static EditText nameEditText, bioEditText;
    private static ArrayList<Bio> bio = new ArrayList<Bio>();
    private static ListView listView;
    BioAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        bioEditText = findViewById(R.id.biography_edit_text);


        bio.add(new Bio("one", "1"));
        bio.add(new Bio("two", "2"));
        bio.add(new Bio("three", "3"));

        adapter = new BioAdapter(this, bio);
        listView = (ListView) findViewById(R.id.biography_list_view);
        listView.setAdapter(adapter);

    }


    public void addTab(View view) {
        if (nameEditText.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.name_text_cannot_be_blank, Toast.LENGTH_SHORT).show();
        } else if (bioEditText.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, R.string.bio_text_cannot_be_blank, Toast.LENGTH_SHORT).show();
        } else if (listView.getCount() >= 4) {
            Toast.makeText(this, R.string.maximum_item_in_the_list_is_4, Toast.LENGTH_SHORT).show();
        } else {
            bio.add(new Bio(nameEditText.getText().toString(), bioEditText.getText().toString()));
            nameEditText.setText("");
            bioEditText.setText("");
            adapter.notifyDataSetChanged();
        }
    }

    public void clearAll(View view) {
        bio.clear();

        adapter.notifyDataSetChanged();

    }


    public void createTabs(View view) {

        if (bio.size() <= 0) {
            Toast.makeText(this, R.string.add_some_tab_first_please, Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = new Intent(this, Second.class);
            intent.putExtra("bioList", (Serializable) bio);
            startActivity(intent);
        }
    }
}


