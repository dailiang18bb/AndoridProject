package com.kachi.room.wordsample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //request code to be used when the ModifyWordActivity is being used to add a new word to dictionary
    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    //request code to be used when the ModifyWordActivity is being used to update a word in the dictionary
    private static final int UPDATE_WORD_ACTIVITY_REQUEST_CODE = 2;
    private WordViewModel mWordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this, new RecyclerViewClickListener() {
            @Override
            public void onViewHolderClick(RecyclerView.ViewHolder viewHolder, int position) {
                WordListAdapter adapter = (WordListAdapter) recyclerView.getAdapter();
                Word word = adapter.getWord(position);
                //add the word in the specified position to the Intent used to start ths ModifyWordActivity
                Intent intent = new Intent(MainActivity.this, ModifyWordActivity.class).
                        putExtra(ModifyWordActivity.EXTRA_WORD, word);
                startActivityForResult(intent, UPDATE_WORD_ACTIVITY_REQUEST_CODE);

            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //starts the ModifyWordActivity without passing a word to the Intent. This signifies that
                //the user wants to create a new word, and not update an existing word
                Intent intent = new Intent(MainActivity.this, ModifyWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                adapter.setWords(words);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //if the result is okay, then proceed
        if (resultCode == RESULT_OK) {
            //if we were adding a new word to the database, then call insert, else call update
            if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE) {
                Word word = data.getParcelableExtra(ModifyWordActivity.EXTRA_WORD);
                mWordViewModel.insert(word);
            } else if (requestCode == UPDATE_WORD_ACTIVITY_REQUEST_CODE) {
                Word word = data.getParcelableExtra(ModifyWordActivity.EXTRA_WORD);
                mWordViewModel.update(word);
            }
        }
    }
}
