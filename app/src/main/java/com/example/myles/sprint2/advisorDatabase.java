package com.example.myles.sprint2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by press on 2017-03-12.
 */

public class advisorDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_Id = "id";
    private static final String COLUMN_logIn = "logIn";
    private static final String COLUMN_passWord = "passWord";
    private static final String COLUMN_eventName = "eventName";
    private static final String COLUMN_eventTime = "eventTime";
    private static final String COLUMN_eventDate = "eventDate";
    private static final String COLUMN_eventLocation = "eventLocation";
    private static final String COLUMN_eventOrganizers = "eventOrganizers";
    private static final String COLUMN_eventDescription = "eventDescription";


    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null auto_increment , "+
            "logIn text not null , passWord text not null , eventName text not null , eventTime text not null , eventDate text not null , eventLocation text not null , eventOrganizers text not null , eventDescription text not null );";

    public advisorDatabase(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(getSetAdvisor c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_Id, count);
        values.put(COLUMN_logIn, c.getlogIn());
        values.put(COLUMN_passWord , c.getpassWord());
        values.put(COLUMN_eventName , c.getEventName());
        values.put(COLUMN_eventDate , c.getEventDate());
        values.put(COLUMN_eventTime , c.getEventTime());
        values.put(COLUMN_eventLocation , c.getEventLocation());
        values.put(COLUMN_eventOrganizers , c.getEventOrganizers());
        values.put(COLUMN_eventDescription , c.getEventDescription());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void putInformation(advisorDatabase Database, String Email, String Password, String EventName)
    {
        // Gets the data repository in write mode
        SQLiteDatabase SQ = Database.getWritableDatabase();

        // Create a new map of values, where columns names are the keys
        ContentValues value = new ContentValues(  );

        // Used for adding the information to the database
        value.put( COLUMN_logIn, Email );
        value.put( COLUMN_passWord, Password );
        value.put( COLUMN_eventName, EventName );

        // It returns a long value"telling weather the value has been inserted or not"
        long k = SQ.insert( TABLE_NAME, null, value );

        Log.d( "DataBase Operations", " One Raw Inserted" );
    }

    public String searchPass(String name){
        db = this.getReadableDatabase();
        String query = "select firstName, passWord from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if(a.equals(name)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}

