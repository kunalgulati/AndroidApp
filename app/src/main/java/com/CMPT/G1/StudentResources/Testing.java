package com.CMPT.G1.StudentResources;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Testing extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
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
        setContentView(R.layout.activity_testing);

        // Get post key from intent
        mPostKey = getIntent().getStringExtra(EXTRA_POST_KEY);      // Will create Problem

        /*if (mPostKey == null)
        {
            throw new IllegalArgumentException("Must Pass EXTRA_POST_KEY");
        }*/






        // Initialize views
        textView = (TextView)findViewById(R.id.textView);

    }

    @Override
    protected void onStart() {
        super.onStart();

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://project-30ebd.firebaseio.com/");


        // Initialize Views
        mPostReference = database.child("Faculty of Applied Science").child("School of Computing Science");

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

               String Date = null, Description = null, Location = null, Organizers = null, Time = null, EventName = null;

               for (DataSnapshot child : dataSnapshot.getChildren()) {

                   Post event = child.getValue(Post.class);


                   // Reading the Data,
                   // Important: The data is read from the names, not the constructor
                   // Important: Make sure the spellings are correct
                   Date = event.getDate();
                   Location = event.getLocation();
                   Organizers = event.getOrganizers();
                   Time = event.getTime();
                   Description = event.getDescription();
                   EventName = event.getEventName();
                   


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
                   }*/
                   Toast.makeText(Testing.this, "Name: " + EventName + " Date: " + Date + "  Description: " + Description
                           + "  Location: " + Location + "  Organizers: " + Organizers + " Time: " + Time, Toast.LENGTH_LONG).show();

               }

               textView.setText("Name: " + EventName + " Date: " + Date + "  Description: " + Description
               + "  Location: " + Location + "  Organizers: " + Organizers + " Time: " + Time);


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
}
