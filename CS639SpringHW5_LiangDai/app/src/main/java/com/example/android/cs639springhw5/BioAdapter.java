package com.example.android.cs639springhw5;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BioAdapter extends ArrayAdapter<Bio> {


    public BioAdapter(Activity context, ArrayList<Bio> bio) {
        super(context, 0, bio);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        getCount();


        Bio bio = getItem(position);


        TextView nameListView = (TextView) listItemView.findViewById(R.id.name_list);
        nameListView.setText(bio.getmName());

        TextView bioListView = (TextView) listItemView.findViewById(R.id.bio_list);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        bioListView.setText(bio.getmBio());

        return listItemView;
    }
}
