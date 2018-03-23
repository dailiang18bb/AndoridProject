package com.pace.cs639spring.hw2;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplay {

    private int mIcon;
    private int mFilterColor;
    private String mName;

    private List<String> mFunFacts;
    private int mFunFactIndex;

    public AnimalDisplay(int icon, String name, String initialFunFact) {
        mIcon = icon;
        mFilterColor = Color.BLACK;
        mName = name;
        mFunFacts = new ArrayList<>();
        mFunFacts.add(initialFunFact);
        mFunFactIndex = 0;
    }

    int getIcon() {
        return mIcon;
    }

    void setColorFilter(int color) {
        mFilterColor = color;
    }

    int getFilterColor() {
        return mFilterColor;
    }

    String getName() {
        return mName;
    }

    String getCurrentFunFact() {
        return mFunFacts.get(mFunFactIndex);
    }

    void addFunFact(String funFact) {
        mFunFacts.add(funFact);
    }

    boolean removeCurrentFunFact() {
        if (mFunFacts.size() <= 1) return false;

        mFunFacts.remove(mFunFactIndex);
        if (mFunFactIndex > mFunFacts.size() - 1) mFunFactIndex = 0;
        return true;
    }

    void incrementFunFactIndex() {
        if (mFunFactIndex == mFunFacts.size() - 1) mFunFactIndex = 0;
        else mFunFactIndex++;
    }
}
