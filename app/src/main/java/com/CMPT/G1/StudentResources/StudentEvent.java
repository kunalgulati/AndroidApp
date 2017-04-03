package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StudentEvent extends AppCompatActivity implements View.OnClickListener{

    // For the Programmatic Layout
    private int Total_Rows = 50; // Temp value
    private int faculty_index;
    private int department_index;
    Button BtnArray[] = new Button[50];          // An Array of buttons
    private String FacultyName;
    private String DepartmentName;
    private String SendName;

    String[] SaveName = new String[50];
    String[] SaveDate = new String[50];
    String[] SaveTime = new String[50];
    String[] SaveLocation = new String[50];
    String[] SaveOrganizers = new String[50];
    String[] SaveDescription = new String[50];

    // For the Database

    String test;
    private DatabaseReference mPostReference;
    DatabaseReference database;
    private ValueEventListener mPostListener;
    private String mPostKey;
    DatabaseReference mRef;

    public static final String EXTRA_POST_KEY ="post_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event);


        // Getting extra data about the options selcted from the previous activity
        Bundle bundle = getIntent().getExtras();
        faculty_index = bundle.getInt("faculty_index");
        department_index = bundle.getInt("department_index");

        FacultyName = DepartmentList.DepartmentInfo.Faculty[faculty_index];
        DepartmentName = DepartmentList.DepartmentInfo.Department[faculty_index][department_index];


        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-30ebd.firebaseio.com/");

        // Initialize Views
        mPostReference = database.child(FacultyName).child(DepartmentName);

        // Counting the total number of post in the google Firebase



        // Get post key from intent
        mPostKey = getIntent().getStringExtra(EXTRA_POST_KEY);      // Will create Problem

        /*if (mPostKey == null)
        {
            throw new IllegalArgumentException("Must Pass EXTRA_POST_KEY");
        }*/




        populateEvent();

    }

    @Override
    protected void onStart() {
        super.onStart();


        // Add value event listener to the post
        // [START post_value_event_listener]


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


              /* Post post = new Post("kunal", "kunal", "kunal", "kunal", "kunal", "kunal");

               for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                   post = singleSnapshot.getValue(Post.class);
                   Toast.makeText(Testing.this, "hellooooo", Toast.LENGTH_LONG).show();
               }*/

                int row = 0;

                String Date = null, Description = null, Location = null, Organizers = null, Time = null, EventName = null;

                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    Post user = child.getValue(Post.class);
                    user.setEventName(child.getKey());

                    // Getting the name of the user
                    EventName = user.getEventName();
                    Date = user.getDate();
                    Location = user.getLocation();
                    Organizers = user.getOrganizers();
                    Time = user.getTime();
                    Description = user.getDescription();


                    // Processing the Button
                    Button button = BtnArray[row];
                    // Displays the text at the Center
                    // Name of faculties are supposed to fetched from the database

                    button.setText("  Name: " + EventName + "\n \n" + "  Date: " + Date + "\n \n" +
                            "  Description: " + Description +"\n \n" + "  Location: " + Location + "\n \n"+
                            "  Organizers: " + Organizers + "\n \n" + "  Time: " + Time);
                    button.setGravity(Gravity.LEFT);      // Used for aligning the text
                    button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.sfuRed));  // Changing the color of button
                    button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));

                    //Saving the Event Name in the Array
                    SaveName[row] = EventName;
                    SaveDate[row] = Date;
                    SaveDescription[row] = Description;
                    SaveLocation[row] = Location;
                    SaveTime[row] = Time;
                    SaveOrganizers[row] = Organizers;

                    // Incrementing the index (row)
                    row++;



                   /*temp = kunal.toString();
                   if (child.getKey().equals("date")) {
                       Date = child.getValue().toString();
                   }
                   if (child.getKey().equals("description")) {
                       Description = child.getValue().toString();
                   }
                   if (child.getKey().equals("location")) {
                       Location = child.getValue().toString();
                   }
                   if (child.getKey().equals("organizers")) {
                       Organizers = child.getValue().toString();
                   }
                   if (child.getKey().equals("time")) {
                       Time = child.getValue().toString();
                   }
                   Toast.makeText(StudentEvent.this, "Name: " + EventName + " Date: " + Date + "  Description: " + Description
                            + "  Location: " + Location + "  Organizers: " + Organizers + " Time: " + Time, Toast.LENGTH_LONG).show();
                    */
                }
                Total_Rows = row;
                changePopulation();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.d("", "Failed to read value.", databaseError.toException());
            }
        };

        mPostReference.addValueEventListener(postListener);

        mPostListener = postListener;

    }

    @Override
    public void onClick(View v) {

    }

    private void populateEvent() {

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

            button.setText("Welcome to the Events Page");
            button.setGravity(Gravity.CENTER);      // Used for aligning the text
            button.setBackgroundColor(Color.rgb(211,211,211)    );  // Changing the color of button


            final int finalRow = row;               // Temporary variable for row
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    gridButtonClick(finalRow);
                }
            });
            tableRow.addView(button);
            //Adding Buttons to the Array
            BtnArray[row] = button;
        }                                           // end of for loop
        //ProcessButtons();

    }                                           // end of for loop






// This fucntion is used to changing the name of the Number of Buttons in the List
    private void changePopulation() {

        // Pressent Size of the table
        int size = 50;

        TableLayout table = (TableLayout) findViewById(R.id.StudentEventList);


        for (int i = Total_Rows; i < size; i++) {
            View child = table.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }

    }                                           // end of for loop


    /*private void ProcessButtons()               // Adding data and making changed to the buttons
    {
        for (int row = 0; row < Total_Rows; row++)
        {
            Button button = BtnArray[row];
            // Displays the text at the Center
            // Name of faculties are supposed to fetched from the database
            button.setText("Name of Event" + "\n \n"
                    + "Time:" + "\n \n"
                    + "Date:");
            button.setGravity(Gravity.LEFT);      // Used for aligning the text
            button.setBackgroundColor(Color.rgb(105, 240, 174));  // Changing the color of button
        }
    }*/

    private void gridButtonClick(int TempRow)                 // used for on click
    {
        String TempName = SaveName[TempRow];
        String TempDate = SaveDate[TempRow];
        String TempDescription = SaveDescription[TempRow];
        String TempLocation = SaveLocation[TempRow];
        String TempOrganizers = SaveOrganizers[TempRow];
        String TempTime = SaveTime[TempRow];

        Intent intent = new Intent(getApplicationContext(), StudentEventDisplay.class);

        intent.putExtra("faculty_index", faculty_index);
        intent.putExtra("department_index", department_index);
        intent.putExtra("event_name", TempName);
        intent.putExtra("date", TempDate);
        intent.putExtra("description", TempDescription);
        intent.putExtra("location", TempLocation);
        intent.putExtra("organizers", TempOrganizers);
        intent.putExtra("time",TempTime);
        startActivity(intent);
    }

}

