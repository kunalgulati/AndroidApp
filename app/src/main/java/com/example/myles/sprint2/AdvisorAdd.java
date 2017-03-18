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

    //advisorDatabase tempDB = new advisorDatabase(this);
    Button submitBtn;
    EditText eName, eTime, eDate, eLocation, eOrganizers, eDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);

        eName = (EditText)findViewById(R.id.eventName);
        eTime = (EditText)findViewById(R.id.eventTime);
        eDate = (EditText)findViewById(R.id.eventDate);
        eLocation = (EditText)findViewById(R.id.eventLocation);
        eOrganizers = (EditText)findViewById(R.id.eventOrganizers);
        eDescription = (EditText)findViewById(R.id.eventDescription);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAdvisorSubmit();
            }
        });
    }

    public void onAdvisorSubmit(){

        String strName = eName.getText().toString();
        String strTime = eTime.getText().toString();
        String strDate = eDate.getText().toString();
        String strLocation = eLocation.getText().toString();
        String strOrganizers = eOrganizers.getText().toString();
        String strDescription = eDescription.getText().toString();


        getSetAdvisor c = new getSetAdvisor();
        c.setsEventName(strName);
        c.setsEventTime(strTime);
        c.setsEventDate(strDate);
        c.setsEventLocation(strLocation);
        c.setsEventOrganizers(strOrganizers);
        c.setsEventDescription(strDescription);

        //tempDB.insertContact(c);

    }
}
