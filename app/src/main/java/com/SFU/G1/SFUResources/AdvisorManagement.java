package com.SFU.G1.SFUResources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdvisorManagement extends AppCompatActivity {

    Button addEvent;
    Button editEvent;
    //Button viewHistory;

    advisorDatabase myDb;
    Bundle extras;
    String username, faculty, department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_management);

        // Gets username from login page
        extras = getIntent().getExtras();
        username = extras.getString("username");
        faculty = extras.getString("faculty");
        department = extras.getString("department");

        //myDb = new advisorDatabase(this);

        addEvent = (Button) findViewById(R.id.add_event_btn);
        editEvent = (Button) findViewById(R.id.edit_event_btn);
        //viewHistory = (Button) findViewById(R.id.view_history_btn);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorAdd.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        // TODO: Sprint 3
        editEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorEditEvent.class );
                intent.putExtra("username", username);
                intent.putExtra("faculty", faculty);
                intent.putExtra("department", department);
                startActivity(intent);
            }
        });

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
