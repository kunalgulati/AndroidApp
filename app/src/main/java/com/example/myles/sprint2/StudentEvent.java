package com.example.myles.sprint2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class StudentEvent extends AppCompatActivity
{

    private static  final int Total_Rows = 3;           // Total number of faculties in SFU
    // To be fetched from the Database

    Button BtnArray[] = new Button[Total_Rows];          // An Array of buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event);

        populatEvent();
    }


    private void populatEvent() {

        TableLayout table = (TableLayout) findViewById(R.id.StudentEventList);

        for(int row = 0; row  < Total_Rows; row++)
        {
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
            tableRow.setPadding(25,padding,25,25);  // function used to add the padding



            // Setting the on CLICK Action
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    gridButtonClick();
                }
            });


            tableRow.addView(button);

            //Adding Buttons to the Array
            BtnArray[row] = button;
        }                                           // end of for loop

        ProcessButtons();

    }


    private void ProcessButtons()               // Adding data and making changed to the buttons
    {
        for (int row = 0; row < Total_Rows; row++)
        {
            Button button = BtnArray[row];

            button.setText("Name of Event");       // Displays the text at the Center
            // Name of faculties are supposed to fetched from the database

            button.setGravity(Gravity.CENTER);      // Used for aligning the text
            button.setBackgroundColor(Color.rgb(105, 240, 174));  // Changing the color of button

        }

    }


    private void gridButtonClick()                 // used for on click
    {
        Toast.makeText(this, "Department Activity", Toast.LENGTH_LONG).show();
    }


}
