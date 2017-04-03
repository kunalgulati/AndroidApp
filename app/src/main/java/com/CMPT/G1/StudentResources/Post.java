package com.CMPT.G1.StudentResources;

import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by kunalgulati on 2017-03-30.
 */

public class Post implements Serializable{

    private String date;
    private String description;
    private String location;
    private String time;
    private String organizers;
    private String advisorName;
    private String eventName;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)

        Log.d("Description :::: ", "First first first");
    }

    public Post(String tempDate, String tempDescription, String tempLocation, String tempOrganizers, String tempTime, String tempEventName, String tempAdvisorName)
    {
        Log.d("Description :::: ", "entered entered ");
        this.date = tempDate;
        this.description = tempDescription;
        this.location = tempLocation;
        this.time = tempTime;
        this.organizers = tempOrganizers;
        this.advisorName = tempAdvisorName;
        this.eventName = tempEventName;

        Log.d("Description :::: ", description);
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String newDate) {
        this.date = newDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) { this.description = newDescription;  }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String newTime) {
        this.time = newTime;
    }

    public String getOrganizers() {
        return this.organizers;
    }

    public void setOrganizers(String newOrganizers) {
        this.organizers = newOrganizers;
    }

    public String getEventName() { return this.eventName; }

    public void setEventName(String newEventName) { this.eventName = newEventName; }

    public String getAdvisorName() { return this.advisorName; }

    public void setAdvisorName(String newAdvisorName) {this.advisorName = newAdvisorName; }

    // Used for passing Post objects to other activities
    public void writeToBundle(Bundle bundle){
        bundle.putString("date", this.date);
        bundle.putString("time", this.time);
        bundle.putString("location", this.location);
        bundle.putString("organizers", this.organizers);
        bundle.putString("description", this.description);
        bundle.putString("eventName", this.eventName);
        bundle.putString("advisorName", this.advisorName);
    }

    public void readFromBundle(Bundle bundle){
        this.date = bundle.getString("date");
        this.time = bundle.getString("time");
        this.location = bundle.getString("location");
        this.organizers = bundle.getString("organizers");
        this.description = bundle.getString("description");
        this.eventName = bundle.getString("eventName");
        this.advisorName = bundle.getString("advisorName");
    }
}

