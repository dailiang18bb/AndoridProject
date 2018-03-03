package com.example.android.customviewbarchart;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CharlesView mCharlesView;
    String dateString = "";
    int countInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCharlesView = findViewById(R.id.charles_view);
    }

    public void addData(View view) {
        EditText date = (EditText) findViewById(R.id.date_input);
        EditText count = (EditText) findViewById(R.id.count_input);
        //get the data from editText
        dateString = date.getText().toString();
        countInt = Integer.parseInt(count.getText().toString());

        if (dateString.length() > 5 || dateString.length() < 3) {
            Toast.makeText(getApplicationContext(), "Please input a valid date type!!!", Toast.LENGTH_LONG).show();
        } else if (countInt >= 0 || countInt <= 200) {
            //put the data into ArrayList
            mCharlesView.add(dateString, countInt);
        } else {
            Toast.makeText(getApplicationContext(), "Please input a valid count number!!!", Toast.LENGTH_LONG).show();
        }

        //empty the editText
        date.setText("");
        count.setText(null);
    }
}
