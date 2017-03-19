package com.example.myles.sprint2;

import android.provider.BaseColumns;

/**
 * Created by Kunal Gulati on 2017-03-10.
 */

public class AdvisorEventData {

    public AdvisorEventData()
    {

    }

    public static abstract class AdvisorData implements BaseColumns
    {
        public static  String ADVISOR_EMAIL = "Email";
        public static  String ADVISOR_PASSWORD = "Password";

        public static String ADVISOR_NAME = "Name";
        public static  String ADVISOR_EVENT_NAME = "EventName";

        public static  String ADVISOR_EVENT_TIME = "EventTime";
        public static  String ADVISOR_EVENT_DATE = "EventDate";

        public static  String ADVISOR_EVENT_LOCTION = "EventLocation";
        public static String ADVISOR_EVENT_ORGAIZERS = "EventOrganizers";

        public static String ADVISORS_EVENT_DESCRIPTION = "EventDescription";


        public static final String DATABASE_NAME = "Adisors_Event";      // Name of the Database
        public static final String TABLE_NAME = "Event_Info";         // Name of the Table
    }

}
