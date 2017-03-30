package com.example.myles.sprint2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.R.attr.password;


public class StudentEventDisplay extends AppCompatActivity {

    String AdvisorName, EventName, EventDate, EventTime, EventLocation, EventOrganizers, EventDescription;
    Context ctx = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event_display);

        LinearLayout Layout = (LinearLayout) findViewById(R.id.DisplayLinearLayout);
        TextView Text = new TextView(this);


        //  params.leftMargin = 50;
    //    params.topMargin  = i*50;

        AdvisorName = "kunal";

        AdvisorDatabaseOperations DOP = new AdvisorDatabaseOperations(ctx);
        Cursor CR = DOP.getInformation(DOP);
        CR.moveToFirst();
        do {
            if (AdvisorName.equals(CR.getString(0)))
            {
                EventName = CR.getString(1);
                EventDescription =CR.getString(6);
                /*EventDate = CR.getString(2);
                EventTime =  CR.getString(3);
                EventLocation = CR.getString(4);
                EventOrganizers = CR.getString(5);
                EventDescription = CR.getString(6);*/
            }
        } while (CR.moveToNext());


        /*Text.setText("Name of Event: " + EventName + "\n"
                + "Time: " + EventTime + "\n"
                + "Date: " + EventDate + "\n"
                + "Location: " + EventLocation + "\n"
                + "Organizers: " + EventOrganizers + "\n"
                + "Description: " + EventDescription +"\n"
        );  */



        Text.setGravity(Gravity.LEFT);      // Used for aligning the text
        Layout.addView(Text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case(R.id.about):
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
/////////
// HELp: http://stackoverflow.com/questions/4394293/create-a-new-textview-programmatically-then-display-it-below-another-textview