package com.example.myles.sprint2;

import android.content.Context;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdvisorLogin extends AppCompatActivity {

    Button loginBtn;
    EditText Email, Password;
    String email, password;
    Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_advisor);

        /*Email =(EditText)findViewById( R.id.advisor_email);          // Delete
        Password = (EditText)findViewById( R.id.advisor_password );  // Delete*/

        loginBtn = (Button) findViewById(R.id.advisor_login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*email = Email.getText().toString();     //Delete
                password = Password.getText().toString();       // Delete
                // Put If Condition over here
                advisorDatabase DB = new advisorDatabase(c);      // Delete
                DB.putInformation( DB, email, password, null );         // Delete
                Toast.makeText( getBaseContext(), "Registeration Success", Toast.LENGTH_LONG ).show();  // Delete*/

                Intent intent = new Intent(getApplicationContext(), AdvisorEvent.class);
                startActivity(intent);
            }
        });
    }
}
