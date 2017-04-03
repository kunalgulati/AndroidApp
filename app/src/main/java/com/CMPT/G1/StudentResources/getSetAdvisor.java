package com.CMPT.G1.StudentResources;


import android.app.Activity;

public class getSetAdvisor extends Activity
{
    String logIn,  passWord, eventName, eventTime, eventDate, eventLocation, eventOrganizers, eventDescription;


    public void setsEventName(String eventName)
    {
        this.eventName = eventName;
    }
    public String getEventName()
    {
        return this.eventName;
    }

    public void setsEventTime(String eventTime)
    {
        this.eventTime = eventTime;
    }
    public String getEventTime()
    {
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


    public void setlogIn(String logIn){
        this.logIn = logIn;
    }
    public String getlogIn(){
        return this.logIn;
    }

    public void setpassWord(String passWord){
        this.passWord = passWord;
    }
    public String getpassWord(){
        return this.passWord;
    }
}

