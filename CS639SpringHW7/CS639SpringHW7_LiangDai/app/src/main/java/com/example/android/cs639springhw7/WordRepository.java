package com.example.android.cs639springhw7;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.List;

public class WordRepository {


    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;


    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }


    LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private class insertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mWordDao;

        private insertAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            try {

                mWordDao.insert(words[0]);
            } catch (Exception e) {
                // handle the word repeat, toast not working because AsyncTask couldn't affect the layout
                //Toast.makeText(MainActivity.getContext(), R.string.the_word_was_already_exist, Toast.LENGTH_SHORT).show();
            }
            return null;
        }
    }
}
