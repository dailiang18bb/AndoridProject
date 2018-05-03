package com.example.android.cs639springhw7;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

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
            mWordDao.insert(words[0]);
            return null;
        }
    }
}
