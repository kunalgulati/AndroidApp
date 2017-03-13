package com.example.myles.sprint2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    Button loginBtn;

    EditText Email, Password, EventName;
    String email, password, eventname;

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Email =(EditText)findViewById( R.id.StudentEmail);          // Delete
        Password = (EditText)findViewById( R.id.StudentPassword );  // Delete

        loginBtn = (Button) findViewById(R.id.StudentLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = Email.getText().toString();     //Delete
                password = Password.getText().toString();       // Delete

                // Put If Condition over here
                StudentDatabaseOprations DB = new StudentDatabaseOprations( ctx );      // Delete
                DB.putInformation( DB, email, password, null );         // Delete
                Toast.makeText( getBaseContext(), "Registeration Success", Toast.LENGTH_LONG ).show();  // Delete



                Intent intent = new Intent(getApplicationContext(), StudentFaculty.class);
                startActivity(intent);
            }
        });
    }



}
