package com.SFU.G1.SFUResources;

import android.content.Intent;
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

public class StudentFaculty extends AppCompatActivity {

    // Total number of faculties in SFU
    private static final int Total_Faculties = DepartmentList.DepartmentInfo.Faculty.length;

    // Creates a button for each faculty at SFU
    Button BtnArray[] = new Button[Total_Faculties];

    public final static String message = "send";

    // Name of All the Faculties are fetched from the Class DepartmentList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_faculty);

        populateFaculty();
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

    private void populateFaculty() {

        TableLayout table = (TableLayout) findViewById(R.id.StudentFaculty);

        for (int row = 0; row < Total_Faculties; row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
            table.addView(tableRow);

            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,
                    1.0f));

            // Padding
            // Declaring the Number of pixels (in DP), to add the padding between the buttons
            int padding = 25;
            tableRow.setPadding(padding, padding, padding, padding);

            // Temporary variable for row
            final int currentRow = row;

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    gridButtonClick(currentRow);
                }
            });


            tableRow.addView(button);

            //Adding Buttons to the Array
            BtnArray[row] = button;
        } // end of for loop

        ProcessButtons();

    }

    // Adding data and making changed to the buttons
    private void ProcessButtons()
    {
        for (int row = 0; row < Total_Faculties; row++) {
            Button button = BtnArray[row];

            // Displays the text at the Center "FacultyName[row]"
            button.setText(DepartmentList.DepartmentInfo.Faculty[row]);

            // Used for aligning the text
            button.setGravity(Gravity.CENTER);
            // Changing the color of button
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuRed));
            // Changing the color of the text
            button.setTextColor(ContextCompat.getColor(this, R.color.white));
        }

    }


    // used for on click
    protected void gridButtonClick(int position) {
        //Toast.makeText(this, "Welcome to " + DepartmentList.DepartmentInfo.Faculty[position], Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), StudentDepartment.class);

        // Sending the Data to StudentDepartment
        // The position will be used to identify, which faculty was selected
        intent.putExtra("Send", position);
        Log.d("FacultyPage", "Fac_Ind:  " + position);
        startActivity(intent);
    }


}
