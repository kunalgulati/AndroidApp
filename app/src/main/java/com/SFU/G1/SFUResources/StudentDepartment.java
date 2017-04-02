package com.SFU.G1.SFUResources;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


public class StudentDepartment extends AppCompatActivity
{
    int faculty_index;

    private int Total_Rows;           // Total number of faculties in sfu
    // To be fetched from the Database

    String Department ="department";
    GridView grid;

    private static Button BtnArray[] = new Button[30];          // An Array of buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_department);

        Bundle bundle = getIntent().getExtras();    // Getting the data from Student Faculty
        faculty_index = bundle.getInt("Send");               // Getting the  data
        Log.d("DepPage","Fac_Ind:  "+faculty_index);

        Total_Rows = DepartmentList.DepartmentInfo.Department[faculty_index].length;


        CustomGrid adapter = new CustomGrid(StudentDepartment.this, Department, Total_Rows, faculty_index);
        grid=(GridView)findViewById(R.id.GridDepartment);
        grid.setAdapter(adapter);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Sending the Data to StudentDepartment
                // The position will be used to identify, which faculty was selected
                Intent intent = new Intent(getApplicationContext(), StudentEvent.class);
                intent.putExtra("faculty_index", faculty_index);
                Log.d("DepPage","Fac_Ind:  "+faculty_index);
                intent.putExtra("department_index", position);



                startActivity(intent);
            }
        });


        //populateDepartment();

    }


/*    private void populateDepartment() {

        TableLayout table = (TableLayout) findViewById(R.id.StudentDepartment);

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


            // Seting the On CLICK Listener
            final int finalRow = row;
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
        for (int row = 0; row < Total_Rows; row++)
        {
            Button button = BtnArray[row];

            button.setText(DepartmentList.DepartmentInfo.Department[faculty_index][row]);
            //button.setText(DepartmentList. fun(row));

            // Name of faculties are supposed to fetched from the database

            button.setGravity(Gravity.CENTER);                     // Used for aligning the text
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuRed));  // Changing the color of button
            button.setTextColor(ContextCompat.getColor(this, R.color.white));  // Changing the color of the text

        }

    }


    // used for on click
    private void gridButtonClick(int department_index)
    {
        // Sending the Data to StudentDepartment
        // The position will be used to identify, which faculty was selected
        Intent intent = new Intent(getApplicationContext(), StudentEvent.class);
        intent.putExtra("faculty_index", faculty_index);
        Log.d("DepPage","Fac_Ind:  "+faculty_index);
        intent.putExtra("department_index", department_index);
        startActivity(intent);
    }*/

}
