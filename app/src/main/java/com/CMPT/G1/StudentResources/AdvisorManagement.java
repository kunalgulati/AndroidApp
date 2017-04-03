package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdvisorManagement extends AppCompatActivity {

    Button addEvent;
    //Button editEvent;
    //Button viewHistory;

    advisorDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_management);

        //myDb = new advisorDatabase(this);

        addEvent = (Button) findViewById(R.id.add_event_btn);
        //editEvent = (Button) findViewById(R.id.edit_event_btn);
        //viewHistory = (Button) findViewById(R.id.view_history_btn);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorAdd.class);
                startActivity(intent);
            }
        });

        // TODO: Sprint 3
        /*editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        // TODO: Sprint 3
        /*viewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case(R.id.about):
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
