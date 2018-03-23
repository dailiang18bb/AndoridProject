package com.pace.cs639spring.hw2;

import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kachi on 2/14/18.
 */

public class AnimalDisplayRecyclerFragment extends Fragment {

    RecyclerView mRecyclerView;
    AnimalDisplayRecyclerViewAdapter mAdapter;
    EditText mNewFunFactText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.animal_display_recycler_view, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mNewFunFactText = view.findViewById(R.id.fun_fact_edit_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configureListView();
        configureFunFactAdditionArea();
        addColorClickListeners();
    }

    private void configureListView() {
        List<AnimalDisplay> animalDisplays = new ArrayList<>(10);
        animalDisplays.add(new AnimalDisplay(R.drawable.bird, getString(R.string.bird_title), getString(R.string.bird_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.cat, getString(R.string.cat_title), getString(R.string.cat_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.dog, getString(R.string.dog_title), getString(R.string.dog_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.fish, getString(R.string.fish_title), getString(R.string.fish_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.lizard, getString(R.string.lizard_title), getString(R.string.lizard_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.rabbit, getString(R.string.rabbit_title), getString(R.string.rabbit_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.rat, getString(R.string.rat_title), getString(R.string.rat_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.snake, getString(R.string.snake_title), getString(R.string.snake_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.squirrel, getString(R.string.squirrel_title), getString(R.string.squirrel_description)));
        animalDisplays.add(new AnimalDisplay(R.drawable.turtle, getString(R.string.turtle_title), getString(R.string.turtle_description)));

        mAdapter = new AnimalDisplayRecyclerViewAdapter(getActivity(), animalDisplays, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int) v.getTag();
                AnimalDisplay display = mAdapter.getItem(position);

                switch (v.getId()) {
                    case R.id.row:
                        mAdapter.setSelectedPosition(position);
                        break;
                    case R.id.next_fact_button:
                        nextFunFact(display);
                        break;
                    case R.id.delete_fact_button:
                        deleteFunFact(display);
                        break;
                }
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void nextFunFact(AnimalDisplay display) {
        display.incrementFunFactIndex();
        mAdapter.notifyDataSetChanged();
    }

    private void deleteFunFact(AnimalDisplay display) {
        boolean success = display.removeCurrentFunFact();
        if (success) mAdapter.notifyDataSetChanged();
        else {
            Toast.makeText(getActivity(), R.string.could_not_remove_fun_fact_at_least_one_needed, Toast.LENGTH_LONG).show();
        }
    }

    private void configureFunFactAdditionArea() {
        getView().findViewById(R.id.bttn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewFunFactText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.fun_fact_text_cannot_be_blank, Toast.LENGTH_LONG).show();
                } else if (!mAdapter.isPositionSelected()) {
                    Toast.makeText(getActivity(), R.string.please_select_an_animal_image_before_adding_fun_fact,
                            Toast.LENGTH_LONG).show();
                } else {
                    AnimalDisplay display = (AnimalDisplay) mAdapter.getItem(mAdapter.getSelectedPosition());
                    display.addFunFact(mNewFunFactText.getText().toString());
                    mNewFunFactText.setText("");
                    mAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void addColorClickListeners() {
        View.OnClickListener colorListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mAdapter.isPositionSelected()) {
                    AnimalDisplay display = (AnimalDisplay) mAdapter.getItem(mAdapter.getSelectedPosition());
                    display.setColorFilter(((ColorDrawable)view.getBackground()).getColor());
                    mAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(), R.string.please_select_an_animal_image_before_choosing_a_color,
                            Toast.LENGTH_LONG).show();
                }
            }
        };
        getView().findViewById(R.id.red).setOnClickListener(colorListener);
        getView().findViewById(R.id.orange).setOnClickListener(colorListener);
        getView().findViewById(R.id.green).setOnClickListener(colorListener);
        getView().findViewById(R.id.blue).setOnClickListener(colorListener);
        getView().findViewById(R.id.yellow).setOnClickListener(colorListener);
    }
}
