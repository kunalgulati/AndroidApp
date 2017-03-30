package com.SFU.G1.SFUResources;

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
        public static final String ADVISOR_EMAIL = "Email";
        public static final String ADVISOR_PASSWORD = "Password";

        public static final String ADVISOR_NAME = "Name";
        public static final String ADVISOR_EVENT_NAME = "EventName";

        public static final String ADVISOR_EVENT_TIME = "EventTime";
        public static final String ADVISOR_EVENT_DATE = "EventDate";

        public static final String ADVISOR_EVENT_LOCTION = "EventLocation";
        public static final String ADVISOR_EVENT_ORGANIZERS = "EventOrganizers";

        public static final String ADVISORS_EVENT_DESCRIPTION = "EventDescription";


        public static final String DATABASE_NAME = "Advisors_Event";      // Name of the Database
        public static final String TABLE_NAME = "Event_Info";         // Name of the Table
    }

}
