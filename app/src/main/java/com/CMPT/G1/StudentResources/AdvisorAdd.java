package com.CMPT.G1.StudentResources;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    Bundle extras;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_add);

        // Gets username from login page
        extras = getIntent().getExtras();
        username = extras.getString("username");

        submitBtn = (Button) findViewById(R.id.submit_btn);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerFaculty = (Spinner) findViewById(R.id.spinner_faculty);

        populateFacultySpinner();
        facultySpinnerSetListener();

        submitEvent();

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
        myRef.child("advisorName").setValue(event.get(6));
    }

    private void populateFacultySpinner() {
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

    /**
     * Department spinner items are populated depending on the Faculty chosen
     */
    private void facultySpinnerSetListener() {
        spinnerFaculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                String itemName = item.toString();
                List<String> list;
                switch (itemName){
                    case("Faculty of Applied Science"):
                        list = new ArrayList<String>();
                        list.add("School of Computing Science");
                        list.add("School of Engineering Science");
                        list.add("School of Mechatronic Systems Engineering");
                        populateDepartmentSpinner(list);
                        break;
                    case("Beedie School of Business"):
                        list = new ArrayList<String>();
                        list.add("Beedie School of Business");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Education"):
                        list = new ArrayList<String>();
                        list.add("Department of Education");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Environment"):
                        list = new ArrayList<String>();
                        list.add("Department of Archaeology");
                        list.add("Centre for Sustainable Community Development");
                        list.add("Environmental Science program");
                        list.add("Department of Geography");
                        list.add("School of Resource and Environmental Management");
                        list.add("Bachelor of Environment");
                        list.add("Ecological Restoration");
                        list.add("Heritage Resource Management");
                        list.add("Resource and Environmental Planning");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Science"):
                        list = new ArrayList<String>();
                        list.add("Department of Actuarial Science and Statistics");
                        list.add("Department of Biological Sciences");
                        list.add("Department of Biomedical Physiology and Kinesiology");
                        list.add("Department of Chemistry");
                        list.add("Department of Earth Sciences");
                        list.add("Department of Mathematics");
                        list.add("Department of Molecular Biology and Biochemistry");
                        list.add("Department of Physics");
                        list.add("Department of Statistics and Actuarial Science");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Health Sciences"):
                        list = new ArrayList<String>();
                        list.add("Department of Health Sciences");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Communication, Art and Technology"):
                        list = new ArrayList<String>();
                        list.add("School of Communication");
                        list.add("School for the Contemporary Arts");
                        list.add("School of Interactive Arts and Technology");
                        list.add("Publishing program");
                        populateDepartmentSpinner(list);
                        break;
                    case("Faculty of Arts and Social Sciences"):
                        list = new ArrayList<String>();
                        list.add("Department of Sociology and Anthropology");
                        list.add("Asia-Canada program");
                        list.add("Cognitive Science program");
                        list.add("School of Criminology");
                        list.add("Department of Economics");
                        list.add("Department of English");
                        list.add("Department of First Nations Studies");
                        list.add("French Cohort program");
                        list.add("Department of French");
                        list.add("Department of Gender, Sexuality, and Women's Studies");
                        list.add("Department of Gerontology");
                        list.add("Graduate Liberal Studies program");
                        list.add("Hellenic Studies program");
                        list.add("Department of History");
                        list.add("Department of Humanities");
                        list.add("School for International Studies");
                        list.add("Labour Studies program");
                        list.add("Language Training Institute");
                        list.add("Latin American Studies program");
                        list.add("Department of Linguistics");
                        list.add("Department of Philosophy");
                        list.add("Department of Political Science");
                        list.add("Department of Psychology");
                        list.add("School of Public Policy");
                        list.add("Urban Studies program");
                        list.add("World Literature program");
                        populateDepartmentSpinner(list);
                        break;
                    default:
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void populateDepartmentSpinner(List<String> departments) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, departments);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);
    }

    private void submitEvent() {
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

                if(DatabaseEventName.equals("")){
                    Toast.makeText(AdvisorAdd.this, "You must enter an Event Name", Toast.LENGTH_LONG).show();
                    return;
                }

                List<String> eventDetails = new ArrayList<String>();
                eventDetails.add(DatabaseEventName);
                eventDetails.add(DatabaseTime);
                eventDetails.add(DatabaseDate);
                eventDetails.add(DatabaseLocation);
                eventDetails.add(DatabaseOrganizers);
                eventDetails.add(DatabaseDescription);
                eventDetails.add(username);
                eventDetails.add(department);
                eventDetails.add(faculty);

                addEvent(eventDetails);

                Toast.makeText(AdvisorAdd.this, "Event Added!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
