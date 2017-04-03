package com.CMPT.G1.StudentResources;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by kunalgulati on 2017-03-30.
 */

public class Post implements Serializable{

    public String date;
    public String description;
    public String location;
    public String time;
    public String organizers;
    public String name;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)

        Log.d("Description :::: ", "First first first");
    }

    public Post(String tempDate, String tempDescription, String tempLocation, String tempOrganizers, String tempTime)
    {
        Log.d("Description :::: ", "entered entered ");
        this.date = tempDate;
        this.description = tempDescription;
        this.location = tempLocation;
        this.time = tempTime;
        this.organizers = tempOrganizers;

        Log.d("Description :::: ", description);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescrption() {
        return description;
    }

    public void setDescrption(String descrption) {
        this.description = descrption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOrganizers() {
        return organizers;
    }

    public void setOrganizers(String organizers) {
        this.organizers = organizers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

