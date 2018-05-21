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
    int resultCode = 100;


    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }


    LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    // insert new word
    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    // update the current word
    public void update(Word word) {
        new updateAsyncTask(mWordDao).execute(word);
    }

    private class updateAsyncTask extends AsyncTask<Word, Void, Integer> {
        private WordDao mWordDao;

        private updateAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Integer doInBackground(Word... words) {
            try {
                mWordDao.update(words[0]);
            } catch (Exception e) {
                resultCode = 300;
            }
            return resultCode;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (resultCode == 300) {
                Toast.makeText(MainActivity.getContext(), R.string.update_word_failed, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.getContext(), R.string.successfully_update_the_word, Toast.LENGTH_LONG).show();
            }
        }
    }


    private class insertAsyncTask extends AsyncTask<Word, Void, Integer> {
        private WordDao mWordDao;

        private insertAsyncTask(WordDao wordDao) {
            mWordDao = wordDao;
        }

        @Override
        protected Integer doInBackground(Word... words) {
            try {
                mWordDao.insert(words[0]);
            } catch (Exception e) {
                // handle the word repeat, toast not working because AsyncTask couldn't affect the layout
                //Toast.makeText(MainActivity.getContext(), R.string.the_word_was_already_exist, Toast.LENGTH_SHORT).show();
                //Hi Liang, that is exactly right. You cannot call it inside the asynctasks doInBackground method because it is in another thread.
                // But you can call it inside onPostExecute
                resultCode = 200;
            }
            return resultCode;
        }


        @Override
        protected void onPostExecute(Integer resultCode) {
            super.onPostExecute(resultCode);
            if (resultCode == 100) {
                Toast.makeText(MainActivity.getContext(), R.string.successfully_add_the_word, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.getContext(), R.string.the_word_was_already_exist, Toast.LENGTH_LONG).show();
            }
        }
    }
}
