package com.CMPT.G1.StudentResources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class StudentEventDisplay extends AppCompatActivity{

    String AdvisorName, EventName, EventDate, EventTime, EventLocation, EventOrganizers, EventDescription;
    LinearLayout Layout;
    private String FacultyName;
    private String DepartmentName;
    private int faculty_index;
    private int department_index;

    private String Name;
    public String Location;
    public String Time;
    public String Organizers;
    public String Date;
    public String Description;

    TextView Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event_display);



        // Getting extra data about the options selcted from the previous activity
        Bundle bundle = getIntent().getExtras();
        faculty_index = bundle.getInt("faculty_index");
        department_index = bundle.getInt("department_index");
        Name = bundle.getString("event_name");
        Date = bundle.getString("date");
        Description = bundle.getString("description");
        Location = bundle.getString("location");
        Time = bundle.getString("time");
        Organizers = bundle.getString("organizers");




        Toast.makeText(this, "Testing " + faculty_index + " " + department_index + " " + Name, Toast.LENGTH_LONG).show();

        FacultyName = DepartmentList.DepartmentInfo.Faculty[faculty_index];
        DepartmentName = DepartmentList.DepartmentInfo.Department[faculty_index][department_index];

        Layout= (LinearLayout) findViewById(R.id.DisplayLinearLayout);
        Text = new TextView(this);



        Text.setText("Name: " + Name + "\n \n" + " Date: " + Date + "\n \n" +
                "  Description: " + Description +"\n \n" + "  Location: " + Location + "\n \n"+
                "  Organizers: " + Organizers + "\n \n" + " Time: " + Time);

        Text.setGravity(Gravity.LEFT);      // Used for aligning the text
        Layout.addView(Text);



    }

}
/////////
// HELp: http://stackoverflow.com/questions/4394293/create-a-new-textview-programmatically-then-display-it-below-another-textviewthen-display-it-below-another-textview