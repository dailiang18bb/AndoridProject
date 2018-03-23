package com.pace.cs639spring.hw2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplayListViewAdapter extends BaseAdapter {

    Context mContext;
    List<AnimalDisplay> mAnimalDisplays;
    View.OnClickListener mButtonClickListener;

    private int mSelectedPosition = Adapter.NO_SELECTION;

    AnimalDisplayListViewAdapter(Context context, List<AnimalDisplay> animalDisplays, View.OnClickListener buttonClickListener) {
        mContext = context;
        mAnimalDisplays = animalDisplays;
        mButtonClickListener = buttonClickListener;
    }



    @Override
    public int getCount() {
        return mAnimalDisplays.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimalDisplays.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item, null);
            ViewHolder viewHolder = new ViewHolder((ImageView) convertView.findViewById(R.id.animal_icon),
                    (TextView) convertView.findViewById(R.id.animal_description), (Button) convertView.findViewById(R.id.next_fact_button),
                    (Button) convertView.findViewById(R.id.delete_fact_button));
            viewHolder.mNextButton.setOnClickListener(mButtonClickListener);
            viewHolder.mDeleteButton.setOnClickListener(mButtonClickListener);
            convertView.setTag(viewHolder);
        }

        AnimalDisplay animalDisplay = (AnimalDisplay) getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mImageView.setImageResource(animalDisplay.getIcon());
        viewHolder.mImageView.setColorFilter(animalDisplay.getFilterColor(), PorterDuff.Mode.SRC_IN);
        viewHolder.mDescriptionTextView.setText(mContext.getString(R.string.name_return_description,animalDisplay.getName(), animalDisplay.getCurrentFunFact()));
        viewHolder.mDescriptionTextView.setVisibility(position == mSelectedPosition ? View.VISIBLE : View.GONE);
        viewHolder.mNextButton.setVisibility(viewHolder.mDescriptionTextView.getVisibility());
        viewHolder.mNextButton.setTag(position);
        viewHolder.mDeleteButton.setVisibility(viewHolder.mDescriptionTextView.getVisibility());
        viewHolder.mDeleteButton.setTag(position);
        return convertView;
    }

    public void setSelectedPosition(int position) {
        mSelectedPosition =  position ==  mSelectedPosition ? Adapter.NO_SELECTION : position;
        notifyDataSetChanged();
    }

    public int getSelectedPosition() {
        return mSelectedPosition;
    }

    public boolean isPositionSelected() {
        return mSelectedPosition != Adapter.NO_SELECTION;
    }

    private class ViewHolder {

        ImageView mImageView;
        TextView mDescriptionTextView;
        Button mNextButton;
        Button mDeleteButton;

        ViewHolder(ImageView imageView, TextView descriptionTextView, Button nextButton, Button deleteButton) {
            mImageView = imageView;
            mDescriptionTextView = descriptionTextView;
            mNextButton = nextButton;
            mDeleteButton = deleteButton;
        }
    }
}
