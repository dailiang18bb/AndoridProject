package com.example.android.cs639springhw7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NewWordActivity extends AppCompatActivity {

    private EditText mEditWordView;
    private EditText mEditWordDefView;
    private RadioGroup mRadioGroup;
    private RadioButton none, adj, adv, prop;

    public static final String EXTRA_REPLY = "com.example.android.androidroompractice.wordlistsql.REPLY";
    public static final String EXTRA_REPLY_DEF = "com.example.android.androidroompractice.wordlistsql.REPLY_DEF";
    public static final String EXTRA_REPLY_PROP = "com.example.android.androidroompractice.wordlistsql.REPLY_PROP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        mEditWordDefView = findViewById(R.id.edit_word_def);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);

        none = (RadioButton) findViewById(R.id.none_radio_button);
        adj = (RadioButton) findViewById(R.id.adj_radio_button);
        adv = (RadioButton) findViewById(R.id.adv_radio_button);
        prop = (RadioButton) findViewById(R.id.prop_radio_button);

        Button button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    String def = mEditWordDefView.getText().toString();
                    String prop = "";

                    int selectedId = mRadioGroup.getCheckedRadioButtonId();
                    // find which radioButton is checked by id

                    if(selectedId == none.getId()) {
                        prop = "(n.)";
                    } else if(selectedId == adj.getId()) {
                        prop = "(adj.)";
                    } else if(selectedId == adv.getId()) {
                        prop = "(adv.)";
                    } else {
                        prop = "(prep.)";
                    }
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    replyIntent.putExtra(EXTRA_REPLY_DEF, def);
                    replyIntent.putExtra(EXTRA_REPLY_PROP, prop);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
