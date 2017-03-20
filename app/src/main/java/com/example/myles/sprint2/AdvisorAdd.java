package com.example.myles.sprint2;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdvisorAdd extends AppCompatActivity
{
    //advisorDatabase tempDB = new advisorDatabase(this);

    Button submitBtn;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);


        submitBtn = (Button) findViewById(R.id.submit_btn);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText AdvisorName = (EditText)findViewById(R.id.advisorName);
                EditText EventName = (EditText)findViewById(R.id.eventName);
                EditText Time = (EditText)findViewById(R.id.eventTime);
                EditText Date = (EditText)findViewById(R.id.eventDate);
                EditText Location = (EditText)findViewById(R.id.eventLocation);
                EditText Organizers = (EditText)findViewById(R.id.eventOrganizers);
                EditText Description = (EditText)findViewById(R.id.eventDescription);

                String DatabaseAdvisorName = AdvisorName.getText().toString();
                String DatabaseEventName = EventName.getText().toString();
                String DatabaseTime = Time.getText().toString();
                String DatabaseDate = Date.getText().toString();
                String DatabaseLocation = Location.getText().toString();
                String DatabaseOrganizers = Organizers.getText().toString();
                String DatabseDescription = Description.getText().toString();

                AdvisorDatabaseOperations DB = new AdvisorDatabaseOperations(ctx);
                DB.putInformation( DB, DatabaseAdvisorName, DatabaseEventName,DatabaseTime, DatabaseDate,
                        DatabaseLocation, DatabaseOrganizers, DatabseDescription);
                DB.close();

                Toast.makeText(ctx, "Event Added", Toast.LENGTH_SHORT).show();
                
               finish();

                /*Error Maybe*/
            }
        });
    }




            /*getSetAdvisor c = new getSetAdvisor();
            c.setsEventName(eName1);
            c.setsEventTime(eTime1);
            c.setsEventDate(eDate1);
            c.setsEventLocation(eLocation1);
            c.setsEventOrganizers(eOrganizers1);
            c.setsEventDescription(eDescription1);

            tempDB.insertContact(c);*/

}
