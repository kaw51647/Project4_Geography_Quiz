package edu.uga.cs.project4_geography_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GeoQuizData {

    private SQLiteDatabase db;
    private SQLiteOpenHelper geoQuizDbHelper;
    private GeoQuizDBHelper helper;
    private static GeoQuizData instance;
    private final Context context;
    Cursor cursor = null;
    int counter = 0;
    int maxCountryCount = 6;

    public GeoQuizData(Context context) {
        this.geoQuizDbHelper = new GeoQuizDBHelper(context);
        this.context = context;
    }

    //open database
    public GeoQuizData open() {
        helper.openDatabase();
        helper.close();
        db = helper.getWritableDatabase();
        return this;
    }

    //close database
    public void close() {
        if(db != null) {
            db.close();
        }
    }


    //query result from database
    //must pick 6 countries randomly
    public List<Country> retrieveCountries() {
        ArrayList<Country> countries = new ArrayList<>();

        try {
            // Execute the select query and get the Cursor to iterate over the retrieved rows
            cursor = db.rawQuery("SELECT * FROM quiz1 ORDER BY RANDOM() LIMIT 1", null);

            // collect 6 countries into a List
            if( cursor.getCount() > 0 ) {
                while( cursor.moveToNext() && counter < maxCountryCount) {
                    // get all attribute values of this country object
                    int id = cursor.getInt(cursor.getColumnIndex("id"));
                    String country = cursor.getString(cursor.getColumnIndex("country"));
                    String continent = cursor.getString(cursor.getColumnIndex("continent"));

                    // create a new Country object and set its state to the retrieved values
                    Country countryObj = new Country(country, continent);
                    countryObj.setId(id); // set the id (the primary key) of this object
                    // add it to the list
                    countries.add(countryObj);
                    counter++;
                }
            }
        }
        catch( Exception e ){
        }
        finally{
            // we should close the cursor
            if (cursor != null) {
                cursor.close();
            }
        }
        // return a list of retrieved countries
        return countries;
    }



}

