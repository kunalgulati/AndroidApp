package com.example.myles.sprint2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdvisorEvent extends AppCompatActivity {

    Button addEvent;
    Button editEvent;
    Button viewHistory;
    advisorDatabase myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_event);

        myDb = new advisorDatabase(this);

        addEvent = (Button) findViewById(R.id.add_event_btn);
        editEvent = (Button) findViewById(R.id.edit_event_btn);
        viewHistory = (Button) findViewById(R.id.view_history_btn);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorAdd.class);
                startActivity(intent);
            }
        });

        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
