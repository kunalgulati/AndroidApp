package com.example.myles.sprint2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StudentEventDisplay extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event_display);

        LinearLayout Layout = (LinearLayout) findViewById(R.id.DisplayLinearLayout);
        TextView Text = new TextView(this);


        //  params.leftMargin = 50;
    //    params.topMargin  = i*50;




        Text.setText("Name of Event" + "\n \n"
                + "Time:" + "\n \n"
                + "Date:");



        Text.setGravity(Gravity.LEFT);      // Used for aligning the text
        Layout.addView(Text);
    }

}
/////////
// HELp: http://stackoverflow.com/questions/4394293/create-a-new-textview-programmatically-then-display-it-below-another-textview