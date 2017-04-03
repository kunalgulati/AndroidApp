package com.SFU.G1.SFUResources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdvisorEditEvent extends AppCompatActivity {

    Bundle extras;
    String username, faculty, department;
    Query username_query;
    List<List<String>> advisor_event_list;
    List<String> event_details;
    List<Button> BTN_list;
    TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_edit_event);
        getSupportActionBar().setTitle(getResources().getString(R.string.advisor_edit_label));
        tableLayout = (TableLayout) findViewById(R.id.EditEventTableLayout);

        // Obtaining Advisor information
        extras = getIntent().getExtras();
        username = extras.getString("username");
        faculty = extras.getString("faculty");
        department = extras.getString("department");

        // Initializing Lists
        advisor_event_list = new ArrayList<>();
        BTN_list = new ArrayList<>();

        // Accessing Database
        final GenericTypeIndicator<String> t = new GenericTypeIndicator<String>() {};
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child(faculty).child(department);

        myRef.orderByChild("advisor").equalTo(username).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                event_details = new ArrayList<>();
                event_details.add(dataSnapshot.getKey());
                event_details.add(dataSnapshot.child("time").getValue(t));
                event_details.add(dataSnapshot.child("date").getValue(t));
                event_details.add(dataSnapshot.child("location").getValue(t));
                event_details.add(dataSnapshot.child("organizers").getValue(t));
                event_details.add(dataSnapshot.child("description").getValue(t));
                Log.d("Database Edit", "event title  =  "+event_details.get(0));
                Log.d("Database Edit", "event description  =  "+event_details.get(5));
                showEvent(event_details);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    void showEvent(List<String> details_list){
        TableRow tableRow = new TableRow(this);
        Button temp_btn = new Button(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT,
                0));
        tableLayout.addView(tableRow);

        // Button formatting and labelling
        temp_btn.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT,
                1.0f));
        temp_btn.setText(event_details.get(0)+"\n \n"+
                         event_details.get(1)+"\n \n"+
                         event_details.get(2));
        temp_btn.setGravity(Gravity.LEFT);
        temp_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuRed));
        temp_btn.setTextColor(ContextCompat.getColor(this, R.color.white));



        // Padding
        int padding = 25;                       // Declaring the Number of pixels (in DP), to add the padding between the buttons
        tableRow.setPadding(25, padding, 25, 25);  // function used to add the padding
        tableRow.addView(temp_btn);
        BTN_list.add(temp_btn);
    }
}
