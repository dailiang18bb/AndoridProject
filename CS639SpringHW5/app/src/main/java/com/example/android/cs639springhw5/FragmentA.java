package com.example.android.cs639springhw5;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {

    ArrayList<Bio> mBioList;
    TextView mNameTab, mBioTab;

    interface nextButtonClickListener {
        void onNextButtonClicked();
    }

    interface previousButtonClickListener {
        void onPreviousButtonClicked();
    }


    nextButtonClickListener mNextButtonListener;
    previousButtonClickListener mPreviousButtonListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_tab, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mNextButtonListener = (nextButtonClickListener) context;
            mPreviousButtonListener = (previousButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(toString() + " must implement the BackButtonClickListener");
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        mBioList = (ArrayList<Bio>) args.getSerializable("mBiolist");

        mNameTab = getView().findViewById(R.id.name_tab);
        mBioTab = getView().findViewById(R.id.bio_tab);
        mNameTab.setText(mBioList.get(0).getmName());
        mBioTab.setText(mBioList.get(0).getmBio());


        getView().findViewById(R.id.next_tab_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNextButtonListener.onNextButtonClicked();
            }
        });

        getView().findViewById(R.id.previous_tab_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPreviousButtonListener.onPreviousButtonClicked();
            }
        });


    }
}
