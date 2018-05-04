package com.example.android.cs639springhw7;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static Context context;

    private WordViewModel mWordViewModel;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    public static final String EXTRA_REPLY_MODIFY_WORD = "com.example.android.androidroompractice.wordlistsql.REPLY_MODIFY_WORD";
    public static final String EXTRA_REPLY_MODIFY_WORDPROP = "com.example.android.androidroompractice.wordlistsql.REPLY_MODIFY_WORDPROP";
    public static final String EXTRA_REPLY_MODIFY_WORDDEF = "com.example.android.androidroompractice.wordlistsql.REPLY_MODIFY_WORDDEF";

    private int positionId;
    private int positionIdUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                adapter.setWords(words);
                positionId = words.size() + 1;

//                int a = words.get(2).getId();
//                Log.v("MainActivity", String.valueOf(positionId )+a );
            }
        });

        // set on item click
        adapter.setOnItemClickListener(new WordListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, String word, String wordDef, String wordProp) {
                // TODO Modify the word
                Toast.makeText(MainActivity.this, "you clicked on the " + position + " row", Toast.LENGTH_SHORT).show();

                //Log.v("MainActivity", word + " " + wordDef + " " + wordProp);
                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                intent.putExtra(EXTRA_REPLY_MODIFY_WORD, word);
                intent.putExtra(EXTRA_REPLY_MODIFY_WORDDEF, wordDef);
                intent.putExtra(EXTRA_REPLY_MODIFY_WORDPROP, wordProp);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
                //Log.v("MainActivity", ""+ position);
                positionIdUpdate = position + 1;
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(positionId, data.getStringExtra(NewWordActivity.EXTRA_REPLY), data.getStringExtra(NewWordActivity.EXTRA_REPLY_DEF), data.getStringExtra(NewWordActivity.EXTRA_REPLY_PROP));
            //Log.v("MainActivity", word.getWord() + word.getWordDef() + word.getWordProp());
            mWordViewModel.insert(word);
        } else if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == NewWordActivity.RESULT_UPDATE) {
            Word word = new Word(positionIdUpdate, data.getStringExtra(NewWordActivity.EXTRA_REPLY), data.getStringExtra(NewWordActivity.EXTRA_REPLY_DEF), data.getStringExtra(NewWordActivity.EXTRA_REPLY_PROP));
            //Log.v("MainActivity", word.getWord() + word.getWordDef() + word.getWordProp());
            mWordViewModel.update(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public static Context getContext() {
        return context;
    }
}

