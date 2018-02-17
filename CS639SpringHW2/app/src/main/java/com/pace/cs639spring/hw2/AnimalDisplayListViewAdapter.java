package com.pace.cs639spring.hw2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


class singleRow {

    String mDescription;
    int mImage;

}


public class AnimalDisplayListViewAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<singleRow> mList;

    AnimalDisplayListViewAdapter(Context context) {
        mList = new ArrayList<singleRow>();
        mContext = context;
        String[] animals; = {"bat_description", "bird", "butterfly", "cat", "deer", "dog", "duck", "frog", "horse", "rabbit", "whale"};

        Resources res = context.getResources();
        String[] descriptions = res.getStringArray(R.array.);
        int[] images = {R.drawable.ic_bat, R.drawable.ic_bird, R.drawable.ic_butterfly, R.drawable.ic_cat, R.drawable.ic_deer, R.drawable.ic_dog, R.drawable.ic_duck, R.drawable.ic_frog, R.drawable.ic_horse, R.drawable.ic_rabbit, R.drawable.ic_whale};
        for (int i = 0; i < 11; i++) {
            mList.add(new singleRow(descriptions[i], images[i]));
        }
        /*
        * 1. get values from xml
        *
        */
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        * 1. get the root view.
        * 2. other view
        * 3. value
        *
        *
        *
        */

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout., )



        return null;
    }
}
