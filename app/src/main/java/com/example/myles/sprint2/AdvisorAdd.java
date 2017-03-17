package com.example.myles.sprint2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AdvisorAdd extends AppCompatActivity {
    advisorDatabase tempDB = new advisorDatabase(this);
    Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);
    }

    public void onAdvisorSignup(View v){
        if(v.getId() == R.id.submit_btn){
            EditText eName = (EditText)findViewById(R.id.eventName);
            EditText eTime = (EditText)findViewById(R.id.eventTime);
            EditText eDate = (EditText)findViewById(R.id.eventDate);
            EditText eLocation = (EditText)findViewById(R.id.eventLocation);
            EditText eOrganizers = (EditText)findViewById(R.id.eventOrganizers);
            EditText eDescription = (EditText)findViewById(R.id.eventDescription);

            String eName1 = eName.getText().toString();
            String eTime1 = eTime.getText().toString();
            String eDate1 = eDate.getText().toString();
            String eLocation1 = eLocation.getText().toString();
            String eOrganizers1 = eOrganizers.getText().toString();
            String eDescription1 = eDescription.getText().toString();

            getSetAdvisor c = new getSetAdvisor();
            c.setsEventName(eName1);
            c.setsEventTime(eTime1);
            c.setsEventDate(eDate1);
            c.setsEventLocation(eLocation1);
            c.setsEventOrganizers(eOrganizers1);
            c.setsEventDescription(eDescription1);

            tempDB.insertContact(c);
        }
    }
}
