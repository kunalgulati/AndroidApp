package com.example.myles.sprint2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kunal Gulati on 2017-03-10.
 */

public class StudentDatabaseOprations extends SQLiteOpenHelper {


    public static final int database_version = 1;

    // Creating a Query
    private static final String CREATE_QUERY = "CREATE TABLE "+TableData.TableInfo.TABLE_NAME+"("+ " TEXT,"
            + TableData.TableInfo.USER_ID+" TEXT,"+ TableData.TableInfo.USER_PASS+" TEXT,"
            + TableData.TableInfo.USER_NAME+" TEXT,"+ TableData.TableInfo.EVENT_NAME+" TEXT );";

    // Dropping the table, if we already have a table
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TableData.TableInfo.TABLE_NAME;

    public StudentDatabaseOprations(Context context) {
        super( context, TableData.TableInfo.DATABASE_NAME, null, database_version );
        Log.d( "Database operations", "Database created" );
    }



    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL( CREATE_QUERY );
        Log.d( "Database Operations", "Table Created" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void putInformation(StudentDatabaseOprations Database, String Email, String Password, String EventName)
    {
        // Gets the data repository in write mode
        SQLiteDatabase SQ = Database.getWritableDatabase();

        // Create a new map of values, where columns names are the keys
        ContentValues value = new ContentValues(  );

        // Used for adding the information to the database
        value.put( TableData.TableInfo.EVENT_NAME, Email );
        value.put( TableData.TableInfo.EVENT_NAME, Password );
        value.put( TableData.TableInfo.EVENT_NAME, EventName );

        // It returns a long value"telling weather the value has been inserted or not"
        long k = SQ.insert( TableData.TableInfo.TABLE_NAME, null, value );

        Log.d( "DataBase Operations", " One Raw Inserted" );
    }


    public Cursor getInformation(StudentDatabaseOprations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();

        // Projection that specifies which columns from the database
        // You wil actually use after this Query
        String[] coloumns = {
                TableData.TableInfo.USER_ID,
                TableData.TableInfo.USER_PASS,
                TableData.TableInfo.USER_NAME,
                TableData.TableInfo.EVENT_NAME
        };

        //Filter the results WHERE "Title" = "My Title"
        Cursor CR = SQ.query( TableData.TableInfo.TABLE_NAME, coloumns, null, null, null, null, null );

        return CR;
    }


}
