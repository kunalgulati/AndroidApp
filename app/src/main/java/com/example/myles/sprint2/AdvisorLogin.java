package com.example.myles.sprint2;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdvisorLogin extends AppCompatActivity {

    Button loginBtn;
    EditText Email, Password;
    TextView warningTxt;
    String email, password;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_advisor);

        Email = (EditText) findViewById(R.id.advisor_email);
        Password = (EditText) findViewById(R.id.advisor_password);
        warningTxt = (TextView) findViewById(R.id.warning_text);

        loginBtn = (Button) findViewById(R.id.advisor_login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checkLogin();

                Intent intent = new Intent(getApplicationContext(), AdvisorManagement.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void checkLogin() {
        email = Email.getText().toString();
        password = Password.getText().toString();

        if(!nonEmptyEntry(email) && !nonEmptyEntry(password)){
            setEditText("Please enter a valid email and password");
        } else if(!nonEmptyEntry(email)) {
            setEditText("Please enter a valid email");
        } else if(!nonEmptyEntry(password)){
            setEditText("Please enter a valid password");
        } else {
            validateEntry();
            // Entry in password and email are not empty

        }

    }

    /**
     * @param entry email or password as a string
     * @return returns false if not valid entry, true otherwise
     */
    public boolean nonEmptyEntry(String entry) {
        if (entry.equals("")) {
            return false;
        }
        return true;
    }

    public void setEditText(String msg){
        warningTxt.setText(msg);
        //warningTxt.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.sfuRed));
        warningTxt.postDelayed(new Runnable() {
            @Override
            public void run() {
                warningTxt.setText("");
            }
        }, 4000);
    }

    // TODO: go through advisor database to check if email and password exist
    public boolean validateEntry(){
        /*
        advisorDatabase DB = new advisorDatabase(c);
        DB.putInformation( DB, email, password, null );
        Toast.makeText( getBaseContext(), "Registeration Success", Toast.LENGTH_LONG ).show();
        return true; */
        return true;
    }
}
