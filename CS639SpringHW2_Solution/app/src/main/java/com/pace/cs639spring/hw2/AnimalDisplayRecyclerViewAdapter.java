package com.pace.cs639spring.hw2;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kachi on 2/7/18.
 */

public class AnimalDisplayRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    List<AnimalDisplay> mAnimalDisplays;
    View.OnClickListener mClickListener;

    private int mSelectedPosition = Adapter.NO_SELECTION;

    public AnimalDisplayRecyclerViewAdapter(Context context, List<AnimalDisplay> animalDisplays, View.OnClickListener listener) {
        mContext = context;
        mAnimalDisplays = animalDisplays;
        mClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.list_item, null);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        holder.mNextButton.setOnClickListener(mClickListener);
        holder.mDeleteButton.setOnClickListener(mClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalDisplay animalDisplay = mAnimalDisplays.get(position);

        RecyclerViewHolder viewHolder = (RecyclerViewHolder) holder;
        viewHolder.mImageView.setImageResource(animalDisplay.getIcon());
        viewHolder.mImageView.setColorFilter(animalDisplay.getFilterColor(), PorterDuff.Mode.SRC_IN);
        viewHolder.mDescriptionTextView.setText(mContext.getString(R.string.name_return_description,animalDisplay.getName(), animalDisplay.getCurrentFunFact()));
        viewHolder.mDescriptionTextView.setVisibility(position == mSelectedPosition ? View.VISIBLE : View.GONE);
        viewHolder.mNextButton.setVisibility(viewHolder.mDescriptionTextView.getVisibility());
        viewHolder.mNextButton.setTag(position);
        viewHolder.mDeleteButton.setVisibility(viewHolder.mDescriptionTextView.getVisibility());
        viewHolder.mDeleteButton.setTag(position);

        viewHolder.itemView.setOnClickListener(mClickListener);
        viewHolder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return mAnimalDisplays.size();
    }

    public AnimalDisplay getItem(int position) {
        return mAnimalDisplays.get(position);
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

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mDescriptionTextView;
        Button mNextButton;
        Button mDeleteButton;

        RecyclerViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.animal_icon);
            mDescriptionTextView = view.findViewById(R.id.animal_description);
            mNextButton = view.findViewById(R.id.next_fact_button);
            mDeleteButton = view.findViewById(R.id.delete_fact_button);
        }
    }
}
