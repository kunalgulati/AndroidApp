package com.example.myles.sprint2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AdvisorAdd extends AppCompatActivity {
    Button submitBtn;
    Spinner spinner;
    Spinner spinnerFaculty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);

        submitBtn = (Button) findViewById(R.id.submit_btn);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerFaculty = (Spinner) findViewById(R.id.spinner_faculty);

        populateSpinner();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText EventName = (EditText) findViewById(R.id.eventName);
                EditText Time = (EditText) findViewById(R.id.eventTime);
                EditText Date = (EditText) findViewById(R.id.eventDate);
                EditText Location = (EditText) findViewById(R.id.eventLocation);
                EditText Organizers = (EditText) findViewById(R.id.eventOrganizers);
                EditText Description = (EditText) findViewById(R.id.eventDescription);

                String DatabaseEventName = EventName.getText().toString();
                String DatabaseTime = Time.getText().toString();
                String DatabaseDate = Date.getText().toString();
                String DatabaseLocation = Location.getText().toString();
                String DatabaseOrganizers = Organizers.getText().toString();
                String DatabaseDescription = Description.getText().toString();
                String department = spinner.getSelectedItem().toString();
                String faculty = spinnerFaculty.getSelectedItem().toString();

                List<String> eventDetails = new ArrayList<String>();
                eventDetails.add(DatabaseEventName);
                eventDetails.add(DatabaseTime);
                eventDetails.add(DatabaseDate);
                eventDetails.add(DatabaseLocation);
                eventDetails.add(DatabaseOrganizers);
                eventDetails.add(DatabaseDescription);
                eventDetails.add(department);
                eventDetails.add(faculty);

                addEvent(eventDetails);

                finish();
            }
        });
    }


    private void addEvent(List<String> event){
        int facultyIndex = event.size() - 1;
        int departmentIndex = event.size() - 2;
        String facultyName = event.get(facultyIndex);
        String departmentName = event.get(departmentIndex);
        //Log.i("test","faculty name is: " + facultyName);
        //Log.i("test","department name is: " + departmentName);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef;
        //Toast.makeText(this, "ref parent is:" + myRef.getParent(), Toast.LENGTH_LONG).show();

        // Add all relevant fields
        myRef = database.getReference(facultyName + "/" +departmentName + "/" + event.get(0));
        myRef.child("time").setValue(event.get(1));
        myRef.child("date").setValue(event.get(2));
        myRef.child("location").setValue(event.get(3));
        myRef.child("organizers").setValue(event.get(4));
        myRef.child("description").setValue(event.get(5));
    }



    private void populateSpinner() {

        List<String> spinnerArr = new ArrayList<>();
        for(int i = 0; i < DepartmentList.DepartmentInfo.Department.length; i++){
            for(int j = 0; j < DepartmentList.DepartmentInfo.Department[i].length; j++){
                spinnerArr.add(DepartmentList.DepartmentInfo.Department[i][j]);
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);


        List<String> spinnerArr2 = new ArrayList<>();
        for(int i = 0; i < DepartmentList.DepartmentInfo.Faculty.length; i++){
            spinnerArr2.add(DepartmentList.DepartmentInfo.Faculty[i]);
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArr2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems2 = (Spinner) findViewById(R.id.spinner_faculty);
        sItems2.setAdapter(adapter2);

    }
}
