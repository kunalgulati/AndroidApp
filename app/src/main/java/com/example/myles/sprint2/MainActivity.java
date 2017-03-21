package com.example.myles.sprint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button studentBtn;
    Button advisorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // This code shows how to add stuff to DB
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Applied_Science");

        String name = "Computing_Science";
        myRef = myRef.child(name);
        myRef.setValue("1");
        */

        setupDatabase();

        studentBtn = (Button) findViewById(R.id.student_btn);
        advisorBtn = (Button) findViewById(R.id.advisor_btn);

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StudentFaculty.class);
                startActivity(intent);
            }
        });

        advisorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorLogin.class);
                startActivity(intent);
            }
        });

    }

    private void setupDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        //Database is empty!
        if(myRef.child("Faculty of Science") == null){

            for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){
                String facultyName = DepartmentList.DepartmentInfo.Faculty[i];
                myRef = database.getReference();
                myRef = myRef.child(facultyName);
                myRef.setValue(i);
            }
        }
        myRef = database.getReference("Faculty of Science");

        if(myRef.child("Hello") != null){

            // TODO: get all departments into their correct faculty
//          myRef = database.getReference();
            myRef = myRef.child("nice");
            myRef.setValue(1);
        }



    }
}