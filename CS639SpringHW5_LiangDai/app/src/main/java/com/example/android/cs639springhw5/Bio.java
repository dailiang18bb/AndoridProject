package com.example.android.cs639springhw5;

import java.io.Serializable;

public class Bio implements Serializable {

    private String mName;
    private String mBio;

    public Bio(String name, String bio) {
        this.mName = name;
        this.mBio = bio;
    }

    public String getmName() { return mName; }

    public String getmBio() { return mBio; }
}