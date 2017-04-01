package com.CMPT.G1.StudentResources;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.List;

public class StudentEvent extends AppCompatActivity {

    Context cxt = this;
    List<Integer> event_pos;
    List<Button> BtnArray;

    // To be fetched from the Database
    private int Total_Rows = 0; // Temp value
private int faculty_index;
    private int department_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event);

        event_pos = new ArrayList<>();
        BtnArray = new ArrayList<>();

        // Getting extra data
        Bundle bundle = getIntent().getExtras();
        faculty_index = bundle.getInt("faculty_index");
        department_index = bundle.getInt("department_index");


        // Getting number of Events from DB
        AdvisorDatabaseOperations DB = new AdvisorDatabaseOperations(cxt);
        Cursor CR = DB.getInformation(DB);
        CR.moveToFirst();
        do {
            Log.d("EventLoad", "Fac_Ind:  " + faculty_index);
            Log.d("EventLoad", "Dep_Ind:  " + department_index);
            if (DepartmentList.DepartmentInfo.Department[faculty_index][department_index].equals(CR.getString(5))) {
                Total_Rows++;
                event_pos.add(CR.getPosition());
            }

        } while (CR.moveToNext());
        CR.close();

        populateEvent();
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


    private void populateEvent() {

        TableLayout table = (TableLayout) findViewById(R.id.StudentEventList);

        for (int row = 0; row < Total_Rows; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    0));
            table.addView(tableRow);

            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f));

            // Padding
            int padding = 25;                       // Declaring the Number of pixels (in DP), to add the padding between the buttons
            tableRow.setPadding(25, padding, 25, 25);  // function used to add the padding


            // Setting the on CLICK Action
            final int finalRow = row;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    gridButtonClick(finalRow);
                }
            });


            tableRow.addView(button);

            //Adding Buttons to the Array
            BtnArray.add(button);
        }                                           // end of for loop

        ProcessButtons();

    }


    private void ProcessButtons()               // Adding data and making changed to the buttons
    {
        AdvisorDatabaseOperations DB = new AdvisorDatabaseOperations(cxt);
        Cursor CR = DB.getInformation(DB);

        for (int row = 0; row < Total_Rows; row++) {
            Button button = BtnArray.get(row);
            CR.moveToPosition(event_pos.get(row));

            // Displays the text at the Center
            // Name of faculties are supposed to fetched from the database
            button.setText(CR.getString(1) + "\n \n"
                    + CR.getString(2) + "\n \n"
                    + CR.getString(3));

            button.setGravity(Gravity.LEFT);      // Used for aligning the text

            button.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuRed));  // Changing the color of button
            button.setTextColor(ContextCompat.getColor(this, R.color.white));  // Changing the color of the text
        }
        CR.close();
        DB.close();
    }


    private void gridButtonClick(int pos)                 // used for on click
    {
        //Toast.makeText(this, "Department Activity", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), StudentEventDisplay.class);
        intent.putExtra("event_pos", event_pos.get(pos));
        startActivity(intent);
    }


}

