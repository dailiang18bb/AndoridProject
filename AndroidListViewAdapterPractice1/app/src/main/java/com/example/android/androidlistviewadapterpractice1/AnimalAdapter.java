package com.example.android.androidlistviewadapterpractice1;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {

    public AnimalAdapter(Context context, Resources resources, List<Animal> animalList){

    }

    ListView mAninalDisplay;

    @Override
    public int getCount() { return mAninalDisplay.size(); }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
