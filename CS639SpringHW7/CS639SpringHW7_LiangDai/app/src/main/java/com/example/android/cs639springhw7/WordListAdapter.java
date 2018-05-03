package com.example.android.cs639springhw7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    private onItemClickListener mOnItemClickListener;

    class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);

        }
    }



    //custom on item click listener
    public interface onItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setOnItemClickLitsener(onItemClickListener mOnItemClickLitsener)
    {
        mOnItemClickListener= mOnItemClickLitsener;
    }




    LayoutInflater mInflater;
    private List<Word> mWords;


    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordViewHolder holder, int position) {

        //set on item click listener
        if(mOnItemClickListener!=null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
                {
                    int pos =holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }







        if (mWords == null) {

            holder.wordItemView.setText(R.string.no_word);
        } else {
            Word current = mWords.get(position);
            String addWord = current.getWord() +" "+ current.getWordProp() + " - " + current.getWordDef();
            holder.wordItemView.setText(addWord);
        }

    }

    @Override
    public int getItemCount() {
        return mWords == null ? 0 : mWords.size();
    }




}
