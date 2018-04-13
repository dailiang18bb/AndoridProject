package com.example.android.cs639springhw5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ContainerActivity extends AppCompatActivity implements FragmentA.previousButtonClickListener, FragmentA.nextButtonClickListener {

    public static final String ARGUMENT_NAME = "name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        getFragmentManager().beginTransaction().add(R.id.container, new FragmentA()).commit();
    }

    @Override
    public void onPreviousButtonClicked() {

        if () {
            Bundle args = new Bundle();
            args.putString(ARGUMENT_NAME, name);
            FragmentA fragmentA = new FragmentA();
            fragmentA.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.container, fragmentA).commit();
        }
    }

    @Override
    public void onNextButtonClicked() {

        if (!name.isEmpty()) {
            Bundle args = new Bundle();
            args.putString(ARGUMENT_NAME, name);
            FragmentA fragmentA = new FragmentA();
            fragmentA.setArguments(args);
            getFragmentManager().beginTransaction().replace(R.id.container, fragmentA).commit();
        }
    }
}
