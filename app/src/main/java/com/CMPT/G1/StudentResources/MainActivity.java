package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button studentBtn;
    Button advisorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Only run to setup database categories. Do not run if database is already running
        //setupDatabase();

        studentBtn = (Button) findViewById(R.id.student_btn);
        advisorBtn = (Button) findViewById(R.id.advisor_btn);

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StudentFaculty.class);
                startActivity(intent);
            }
        });

        advisorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdvisorLogin.class);
                startActivity(intent);
            }
        });

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

    /**
     * This will ONLY work if you are connected to the internet on your AVD/Android device
     * Populates the FireBase database with the Faculty and Departments
     */
    /*private void setupDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;

        for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){
            String facultyName = DepartmentList.DepartmentInfo.Faculty[i];
            myRef = database.getReference(facultyName);
            myRef.setValue(1);
        }

        for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){

            String facultyName = DepartmentList.DepartmentInfo.Faculty[i];
            myRef = database.getReference(facultyName);

            for(int j = 0; j < DepartmentList.DepartmentInfo.Department[i].length; j++){

                myRef = database.getReference(facultyName);
                String childName = DepartmentList.DepartmentInfo.Department[i][j];
                myRef = myRef.child(childName);
                myRef.setValue(0);
            }
        }


    }*/

}