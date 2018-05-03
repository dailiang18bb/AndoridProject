package com.example.android.cs639springhw7;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "word_table")
public class Word {


    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "word")
    private String mWord;

    @ColumnInfo(name = "word_prop")
    private String mWordProp;

    @ColumnInfo(name = "word_exp")
    private String mWordExp;


    public Word(@NonNull String word) {
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }

    public void setmWordExp(@NonNull String mWordExp) {
        this.mWordExp = mWordExp;
    }

    public String getmWordExp() {
        return this.mWordExp;
    }

    public void setmWordProp(@NonNull String mWordProp) {
        this.mWordProp = mWordProp;
    }

    public String getmWordProp() {
        return this.mWordProp;
    }
}
