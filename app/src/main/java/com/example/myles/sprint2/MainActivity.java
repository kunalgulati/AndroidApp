package com.example.myles.sprint2;

import android.content.Intent;
import android.provider.ContactsContract;
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

        // Only run to setup database categories. Do not run if database is already running
        //setupDatabase();

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

        for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){
            String facultyName = DepartmentList.DepartmentInfo.Faculty[i];
            myRef = database.getReference();
            myRef = myRef.child(facultyName);
            myRef.setValue(i);
        }


        myRef = database.getReference("Faculty of Science");

        for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){

            String facultyName = DepartmentList.DepartmentInfo.Faculty[i];
            myRef = database.getReference(facultyName);

            for(int j = 0; j < DepartmentList.DepartmentInfo.Department[i].length; j++){

                myRef = database.getReference(facultyName);
                String childName = DepartmentList.DepartmentInfo.Department[i][j];
                myRef = myRef.child(childName);
                myRef.setValue(i);
            }
        }


    }

}