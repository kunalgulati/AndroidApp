package com.example.myles.sprint2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button studentBtn;
    Button advisorBtn;

    // Adding Dummmy Students to the Student Login Database
    String Student_Login_Email = "a";     //"student@sfu.ca";
    String Student_Login_Password = "a";
    Context ctx = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentBtn = (Button) findViewById(R.id.student_btn);
        advisorBtn = (Button) findViewById(R.id.advisor_btn);

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StudentDatabaseOprations DB = new StudentDatabaseOprations( ctx );
                DB.putInformation( DB, Student_Login_Email, Student_Login_Password, null );         // Delete

                Intent intent = new Intent(getApplicationContext(), StudentLogin.class);
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
}