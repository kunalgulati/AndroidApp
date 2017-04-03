package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdvisorEditEvent extends AppCompatActivity {

    Bundle extras;
    String username, faculty, department;
    TableLayout tableLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_edit_event);
        tableLayout = (TableLayout) findViewById(R.id.EditEventTableLayout);

        // Obtaining Advisor information
        extras = getIntent().getExtras();
        username = extras.getString("username");
        faculty = extras.getString("faculty");
        department = extras.getString("department");


        // Accessing Database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference().child(faculty).child(department);

        myRef.orderByChild("advisorName").equalTo(username).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Post event = dataSnapshot.getValue(Post.class);
                event.setEventName(dataSnapshot.getKey());
                showEvent(event);
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

    void showEvent( final Post post){
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
        temp_btn.setText(post.getEventName()+"\n \n"+
                         post.getTime()+"\n \n"+
                         post.getDate());
        temp_btn.setGravity(Gravity.LEFT);
        temp_btn.setBackgroundColor(ContextCompat.getColor(this, R.color.sfuRed));
        temp_btn.setTextColor(ContextCompat.getColor(this, R.color.white));

        // Padding
        int padding = 25;                       // Declaring the Number of pixels (in DP), to add the padding between the buttons
        tableRow.setPadding(25, padding, 25, 25);  // function used to add the padding
        tableRow.addView(temp_btn);

        // Setting button click function
        temp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventChange.class);
                Bundle bundle = new Bundle();
                bundle.putString("faculty", faculty);
                bundle.putString("department", department);
                post.writeToBundle(bundle);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
