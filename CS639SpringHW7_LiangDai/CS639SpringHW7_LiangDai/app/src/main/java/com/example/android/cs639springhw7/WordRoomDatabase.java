package com.example.android.cs639springhw7;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities = {Word.class}, version = 3) //every time when you install the app on the phone, then you change the database, you have to update the version
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static WordRoomDatabase sInstance;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (sInstance == null) {
            synchronized (WordRoomDatabase.class) {
                if (sInstance == null) {
                    // create database here....
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return sInstance;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(sInstance).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }


        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word(1,"LiangDai","That's my name.", "(n.)");
            mDao.insert(word);
            word = new Word(2,"New", "It has never been seen or discovered or invented before. ","(adj.)");
            mDao.insert(word);
            word = new Word(3,"World","Usually refers to the earth, including both the planet itself and the organisms that live on it.", "(n.)");
            mDao.insert(word);
            return null;
        }
    }


}
