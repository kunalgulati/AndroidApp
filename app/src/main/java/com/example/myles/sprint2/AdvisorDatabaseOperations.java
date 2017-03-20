package com.example.myles.sprint2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kunal Gulati on 2017-03-17.
 */

public class AdvisorDatabaseOperations extends SQLiteOpenHelper
{
    public static final int database_version = 1;

    // Creating a Query
    private static final String CREATE_QUERY = "CREATE TABLE "+AdvisorEventData.AdvisorData.TABLE_NAME
            +"("+  AdvisorEventData.AdvisorData.ADVISOR_NAME+" TEXT, "
            + AdvisorEventData.AdvisorData.ADVISOR_EVENT_NAME+" TEXT, "+ AdvisorEventData.AdvisorData.ADVISOR_EVENT_TIME+" TEXT, "
            + AdvisorEventData.AdvisorData.ADVISOR_EVENT_DATE+" TEXT, "+ AdvisorEventData.AdvisorData.ADVISOR_EVENT_LOCTION+" TEXT, "
            + AdvisorEventData.AdvisorData.ADVISOR_EVENT_ORGANIZERS+" TEXT, "+ AdvisorEventData.AdvisorData.ADVISORS_EVENT_DESCRIPTION+" TEXT );";

    public AdvisorDatabaseOperations(Context context) {
        super(context, AdvisorEventData.AdvisorData.DATABASE_NAME, null, database_version);
        Log.d( "Database Operations", "Database created" );
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL(CREATE_QUERY);
        Log.d( "Database Operations", "Table Created" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(AdvisorDatabaseOperations Database, String Name, /*String Password,*/ String EventName,
                               String EventTime, String EventDate, String EventLocation, String EventOrganizer, String EventDescription )
    {
        // Gets the data repository in write mode
        SQLiteDatabase SQ = Database.getWritableDatabase();

        // Create a new map of values, where columns names are the keys
        ContentValues value = new ContentValues();

        // Used for adding the information to the database
        value.put(AdvisorEventData.AdvisorData.ADVISOR_NAME, Name );
        value.put(AdvisorEventData.AdvisorData.ADVISOR_EVENT_NAME, EventName);

        value.put(AdvisorEventData.AdvisorData.ADVISOR_EVENT_TIME, EventTime);
        value.put( AdvisorEventData.AdvisorData.ADVISOR_EVENT_DATE, EventDate );

        value.put(AdvisorEventData.AdvisorData.ADVISOR_EVENT_LOCTION, EventLocation);
        value.put( AdvisorEventData.AdvisorData.ADVISOR_EVENT_ORGANIZERS, EventOrganizer);

        value.put( AdvisorEventData.AdvisorData.ADVISORS_EVENT_DESCRIPTION, EventDescription );

        // It returns a long value "telling whether the value has been inserted or not"
        long k = SQ.insert( AdvisorEventData.AdvisorData.TABLE_NAME, null, value );

        Log.d( "DataBase Operations", " One Raw Inserted" );
    }

    public Cursor getInformation(AdvisorDatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();

        // Projection that specifies which columns from the database
        // You wil actually use after this Query
        String[] coloumns = {
                AdvisorEventData.AdvisorData.ADVISOR_NAME,
                AdvisorEventData.AdvisorData.ADVISOR_EVENT_NAME,
                AdvisorEventData.AdvisorData.ADVISOR_EVENT_TIME,
                AdvisorEventData.AdvisorData.ADVISOR_EVENT_DATE,
                AdvisorEventData.AdvisorData.ADVISOR_EVENT_LOCTION,
                AdvisorEventData.AdvisorData.ADVISOR_EVENT_ORGANIZERS,
                AdvisorEventData.AdvisorData.ADVISORS_EVENT_DESCRIPTION
        };

        //Filter the results WHERE "Title" = "My Title"
        Cursor CR = SQ.query( AdvisorEventData.AdvisorData.TABLE_NAME, coloumns, null, null, null, null, null );
        return CR;
    }
}
