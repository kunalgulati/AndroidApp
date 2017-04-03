package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventChange extends AppCompatActivity {

    String faculty, department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);
        Bundle extras = getIntent().getExtras();
        final Post post = new Post();
        Button button = (Button) findViewById(R.id.submit_btn);

        // Receive event info from previous activity
        post.readFromBundle(extras);
        faculty = extras.getString("faculty");
        department = extras.getString("department");

        // Obtain EditText fields
        final EditText EventName = (EditText) findViewById(R.id.eventName);
        final EditText Time = (EditText) findViewById(R.id.eventTime);
        final EditText Date = (EditText) findViewById(R.id.eventDate);
        final EditText Location = (EditText) findViewById(R.id.eventLocation);
        final EditText Organizers = (EditText) findViewById(R.id.eventOrganizers);
        final EditText Description = (EditText) findViewById(R.id.eventDescription);

        // Set starting values as event info
        EventName.setText(post.getEventName());
        Time.setText(post.getTime());
        Location.setText(post.getLocation());
        Organizers.setText(post.getOrganizers());
        Date.setText(post.getDate());
        Description.setText(post.getDescription());

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(EventName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"You must enter an Event Name", Toast.LENGTH_LONG).show();
                }
                else{
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                    // Removing old DB entry
                    DatabaseReference oldRef = firebaseDatabase.getReference().child(faculty).child(department).child(post.getEventName());
                    oldRef.removeValue();

                    // Creating new DB entry and setting values
                    DatabaseReference newRef = firebaseDatabase.getReference().child(faculty).child(department).child(EventName.getText().toString());
                    Post newPost = new Post();
                    newPost.setAdvisorName(post.getAdvisorName());
                    newPost.setDate(Date.getText().toString());
                    newPost.setTime(Time.getText().toString());
                    newPost.setDescription(Description.getText().toString());
                    newPost.setLocation(Location.getText().toString());
                    newPost.setOrganizers(Organizers.getText().toString());
                    newRef.setValue(newPost);

                    // Returning to Management activity
                    Toast.makeText(getApplicationContext(), "Event Changed!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AdvisorManagement.class);
                    intent.putExtra("username", post.getAdvisorName());
                    intent.putExtra("faculty", faculty);
                    intent.putExtra("department", department);
                    startActivity(intent);
                }
            }
        });
    }
}
