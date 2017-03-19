package com.example.myles.sprint2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    Button loginBtn;

    EditText Email, Password;
    String email, password;

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        Email = (EditText) findViewById(R.id.StudentEmail);          // Delete
        Password = (EditText) findViewById(R.id.StudentPassword);  // Delete

        loginBtn = (Button) findViewById(R.id.StudentLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = Email.getText().toString();             // Extracting the text entered in the Email block
                password = Password.getText().toString();    // Extracting the text entered in the Password block

                StudentDatabaseOprations DOP = new StudentDatabaseOprations(ctx);
                Cursor CR = DOP.getInformation(DOP);
                CR.moveToFirst();

                boolean LoginStatus = false;
                do {
                    if (email.equals(CR.getString(0)) && password.equals(CR.getString(1))) {
                        LoginStatus = true;                  // Becomes true if the identity matches
                    }
                } while (CR.moveToNext());

                if (LoginStatus) {
                    Toast.makeText(getBaseContext(), "Login Success, Welcome", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(StudentLogin.this, StudentFaculty.class));
                } else {
                    Toast.makeText(getBaseContext(), "Login Failed, Please Try Again", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });

    }

}





                /*email = Email.getText().toString();     //Delete
                password = Password.getText().toString();       // Delete

                // Put If Condition over here
                StudentDatabaseOprations DB = new StudentDatabaseOprations( ctx );      // Delete
                DB.putInformation( DB, email, password, null );         // Delete


                Toast.makeText( getBaseContext(), "Registeration Success", Toast.LENGTH_LONG ).show();  // Delete



                Intent intent = new Intent(getApplicationContext(), StudentFaculty.class);
                startActivity(intent);*/