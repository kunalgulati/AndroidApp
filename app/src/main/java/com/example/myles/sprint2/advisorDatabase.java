package com.example.myles.sprint2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by press on 2017-03-12.
 */

public class advisorDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_advisorID = "advisorID";
    private static final String COLUMN_firstName = "firstName";
    private static final String COLUMN_lastName = "lastName";
    private static final String COLUMN_passWord = "passWord";
    private static final String COLUMN_eventName = "eventName";
    private static final String COLUMN_eventTime = "eventTime";
    private static final String COLUMN_eventDate = "eventDate";
    private static final String COLUMN_eventLocation = "eventLocation";
    private static final String COLUMN_eventOrganizers = "eventOrganizers";
    private static final String COLUMN_eventDescription = "eventDescription";


    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (advisorID integer primary key not null auto_increment , "+
            "firstName text not null , lastName text not null , passWord text not null , eventName text not null , eventTime text not null , eventDate text not null , eventLocation text not null , eventOrganizers text not null , eventDescription text not null );";

    public advisorDatabase(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertContact(getSetAdvisor c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_advisorID, c.getsId());
        values.put(COLUMN_firstName , c.getfirstName());
        values.put(COLUMN_lastName , c.getlastName());
        values.put(COLUMN_passWord , c.getpassWord());

        db.insert(TABLE_NAME, null, values);
        db.close();
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

