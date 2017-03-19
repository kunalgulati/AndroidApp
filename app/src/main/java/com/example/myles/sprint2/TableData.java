package com.example.myles.sprint2;

import android.provider.BaseColumns;

/**
 * Created by Kunal Gulati on 2017-03-10.
 */

public class TableData {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        // Add the user information you want to store
        public static final String USER_ID = "user_id";                 // E-Mail ID of the user
        public static final String USER_PASS = "user_pass";             // Password of the user
        public static final String EVENT_NAME = "event_name";           // Name of the event, selected by the user


        public static final String DATABASE_NAME = "user_info";      // Name of the Database
        public static final String TABLE_NAME = "reg_info";         // Name of the Table
    }

}
