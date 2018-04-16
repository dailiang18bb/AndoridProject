package com.pace.cs639spring.hw5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateTabsActivity extends AppCompatActivity {

    public static final String TAB_CONTENT = "tab_content";

    ListView mListView;
    CreatedTabsAdapter mAdapter;
    EditText mNameInput;
    EditText mBioInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tabs);
        mListView = findViewById(android.R.id.list);
        mAdapter = new CreatedTabsAdapter(this);
        mListView.setAdapter(mAdapter);
        mNameInput = findViewById(R.id.name);
        mBioInput = findViewById(R.id.bio_input);
    }

    public void onAddDataClicked(View view) {
        if (mAdapter.getCount() >= 4) {
            Toast.makeText(this, R.string.you_cannot_create_more_than_four_tabs, Toast.LENGTH_LONG).show();
            return;
        }

        String name = mNameInput.getText().toString().trim();
        String biography = mBioInput.getText().toString().trim();


        //perform content validation. Nothing should be empty
        if (name.isEmpty()) {
            Toast.makeText(this, R.string.name_field_cannot_be_empty, Toast.LENGTH_LONG).show();
        } else if (biography.isEmpty()) {
            Toast.makeText(this, R.string.biography_field_cannot_be_empty, Toast.LENGTH_LONG).show();
        } else {
            //if both fields are valid. Add them to our adapter
            mAdapter.addNewTab(new TabInformation(name, biography));
            mNameInput.setText("");
            mBioInput.setText("");
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onCreateTabClicked(View view) {
        //ensure that the user has added at least one tab before going to the next screen
        if (mAdapter.isEmpty()) {
            Toast.makeText(this, R.string.you_must_create_at_least_one_tab, Toast.LENGTH_LONG).show();
            return;
        }
        ArrayList<TabInformation> list = new ArrayList<>(mAdapter.getTabInformation());
        startActivity(new Intent(this, DisplayTabsActivity.class).putExtra(TAB_CONTENT, list));
    }

    public void onClearClicked(View view) {
        mAdapter.removeAllTabInformation();
        mAdapter.notifyDataSetChanged();
    }
}
