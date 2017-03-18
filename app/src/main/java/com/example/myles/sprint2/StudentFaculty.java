package com.example.myles.sprint2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class StudentFaculty extends AppCompatActivity {

    private static  final int Total_Faculties = DepartmentList.DepartmentInfo.Faculty.length;           // Total number of faculties in SFU
    // To be fetched from the Database

    Button BtnArray[] = new Button[Total_Faculties];          // An Array of buttons

    public final static  String message = "send";

    // Name of All the Faculties are fetched from the Class DepartmentList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_faculty);


        populateFaculty();
    }


    private void populateFaculty() {

        TableLayout table = (TableLayout) findViewById(R.id.StudentFaculty);

        for(int row = 0; row  < Total_Faculties; row++)
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


            final int finalRow = row;               // Temporary variable for row

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    gridButtonClick(finalRow);
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
        for (int row = 0; row < Total_Faculties; row++)
        {
            Button button = BtnArray[row];

            button.setText(DepartmentList.DepartmentInfo.Faculty[row]);       // Displays the text at the Center "FacultyName[row]"

            button.setGravity(Gravity.CENTER);      // Used for aligning the text
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuGold));  // Changing the color of button
            button.setTextColor(ContextCompat.getColor(this,R.color.sfuRed));   // Changing the color of the text

        }

    }


    // used for on click
    protected void gridButtonClick(int position)
    {
        int intValue = 9;

        Toast.makeText(this, "Welcome to " + DepartmentList.DepartmentInfo.Faculty[position], Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), StudentDepartment.class);

        // Sending the Data to StudentDepartment
        // The position will be used to identify, which faculty was selected
        intent.putExtra("Send", position);
        startActivity(intent);
    }


}
