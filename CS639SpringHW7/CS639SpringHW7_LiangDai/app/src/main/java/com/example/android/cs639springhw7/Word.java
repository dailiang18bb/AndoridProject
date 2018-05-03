package com.example.android.cs639springhw7;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @ColumnInfo(name = "word_prop")
    private String mWordProp;

    @ColumnInfo(name = "word_def")
    private String mWordDef;


    public Word(@NonNull String word,@NonNull String mWordDef,@NonNull String mWordProp) {
        this.mWord = word;
        this.mWordDef = mWordDef;
        this.mWordProp = mWordProp;
    }

    public String getWord() {
        return this.mWord;
    }


    public String getmWordExp() {
        return this.mWordDef;
    }

    public String getmWordProp() {
        return this.mWordProp;
    }

}
