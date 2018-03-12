package com.pace.cs639spring.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    BarGraphView mGraphView;
    EditText mDateInput;
    EditText mStudentCountInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGraphView = findViewById(R.id.bar_graph);
        mDateInput = findViewById(R.id.date);
        mStudentCountInput = findViewById(R.id.count);
    }

    public void onAddDataClicked(View view) {
        if (!areInputsFilled()) return;


        Date date;
        //we're only going to accept dates in the format of month/day
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        try {
            date = format.parse(mDateInput.getText().toString()); //try to parse date from string
        } catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.please_enter_in_valid_date,
                    Toast.LENGTH_LONG).show();
            return;
        }


        int studentCount;
        try {
            //try to parse student count from the text field
            studentCount = Integer.parseInt(mStudentCountInput.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.please_enter_in_a_valid_number_of_students,
                    Toast.LENGTH_LONG).show();
            return;
        }

        //add date and student count to graph view
        mGraphView.addData(date.getTime(), studentCount);

        //clear input fields so user can enter in new values if they'd like
        mStudentCountInput.setText("");
        mDateInput.setText("");
    }

    private boolean areInputsFilled() {
        if (mDateInput.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.date_cannot_be_empty,
                    Toast.LENGTH_LONG).show();
            return false;
        } else if (mStudentCountInput.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.please_enter_the_total_amount_of_students_present,
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
