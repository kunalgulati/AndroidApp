package com.CMPT.G1.StudentResources;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdvisorLogin extends AppCompatActivity {

    Button loginBtn;
    EditText Username, Password;
    List<List<String>> advisor_list ;
    List<String> advisor_data;
    int i, num_advisors;
    Context cxt;
    Boolean login_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_advisor);
        cxt = getApplicationContext();
        advisor_list = new ArrayList<>();
        advisor_data = new ArrayList<>();
        advisor_data.add("colin");
        advisor_data.add("12345");
        advisor_data.add("Faculty of Applied Science");
        advisor_data.add("School of Computing Science");
        advisor_list.add(advisor_data);
        i = 0 ;
        num_advisors = advisor_list.size();
        login_success = false;



        Username = (EditText) findViewById(R.id.advisor_username);
        Password = (EditText) findViewById(R.id.advisor_password);
        loginBtn = (Button) findViewById(R.id.advisor_login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                while (i<num_advisors){
                    if(username.equals(advisor_list.get(i).get(0))){
                        if(password.equals(advisor_list.get(i).get(1)) ){
                            Log.d("LoginEvent", "Username & Password match");
                            login_success = true ;
                            Intent intent = new Intent(getApplicationContext(), AdvisorManagement.class);
                            intent.putExtra("username", username);
                            intent.putExtra("faculty", advisor_list.get(i).get(2));
                            intent.putExtra("department", advisor_list.get(i).get(3));
                            startActivity(intent);
                            break;
                        }
                        else{
                            break;
                        }
                    }
                    i++;
                }
                if(login_success == false){
                    Toast.makeText(cxt, "Invalid Login Information", Toast.LENGTH_SHORT).show();
                }
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

}
