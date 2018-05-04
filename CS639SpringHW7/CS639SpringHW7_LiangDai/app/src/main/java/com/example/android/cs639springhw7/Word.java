package com.example.android.cs639springhw7;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @ColumnInfo(name = "word_prop")
    private String mWordProp;

    @ColumnInfo(name = "word_def")
    private String mWordDef;

    //Word class constructor
    public Word(int id, @NonNull String word, @NonNull String mWordDef, @NonNull String mWordProp) {
        this.mId = id;
        this.mWord = word;
        this.mWordDef = mWordDef;
        this.mWordProp = mWordProp;
    }

    // getters

    public int getId() { return mId;}

    public String getWord() {
        return this.mWord;
    }

    public String getWordDef() {
        return this.mWordDef;
    }

    public String getWordProp() {
        return this.mWordProp;
    }

}
