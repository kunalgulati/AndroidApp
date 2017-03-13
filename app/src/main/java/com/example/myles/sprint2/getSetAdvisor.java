package com.example.myles.sprint2;

/**
 * Created by press on 2017-03-12.
 */
import android.app.Activity;

public class getSetAdvisor extends Activity{
    int id;
    String firstName, sID, lastName, passWord, eventName, eventTime, eventDate, eventLocation, eventOrganizers, eventDescription;

    public void setid(int id){
        this.id = id;
    }
    public int getid(){
        return this.id;
    }

    public void setsEventName(String eventName){
        this.eventName = eventName;
    }
    public String getEventName(){
        return this.eventName;
    }

    public void setsEventTime(String eventTime){
        this.eventTime = eventTime;
    }
    public String getEventTime(){
        return this.eventTime;
    }

    public void setsEventDate(String eventDate){
        this.eventDate = eventDate;
    }
    public String getEventDate(){
        return this.eventDate;
    }

    public void setsEventLocation(String eventLocation){
        this.eventLocation = eventLocation;
    }
    public String getEventLocation(){
        return this.eventLocation;
    }

    public void setsEventOrganizers(String eventOrganizers){
        this.eventOrganizers = eventOrganizers;
    }
    public String getEventOrganizers(){
        return this.eventOrganizers;
    }

    public void setsEventDescription(String eventDescription){
        this.eventDescription = eventDescription;
    }
    public String getEventDescription(){
        return this.eventDescription;
    }

    public void setsId(String sID){
        this.sID = sID;
    }
    public String getsId(){
        return this.sID;
    }

    public void setfirstName(String firstName){
        this.firstName = firstName;
    }
    public String getfirstName(){
        return this.firstName;
    }

    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    public String getlastName(){
        return this.lastName;
    }

    public void setpassWord(String passWord){
        this.passWord = passWord;
    }
    public String getpassWord(){
        return this.passWord;
    }
}

