package edu.uga.cs.project4_geography_quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GeoQuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "geoquiz.db";
    private static final int DB_VERSION = 1;

    private static GeoQuizDBHelper helperInstance;

    public GeoQuizDBHelper( Context context ) {
        super( context, DB_NAME, null, DB_VERSION );
    }

    //creates the database if it does not exist yet
    @Override
    public void onCreate( SQLiteDatabase db ) {

    }

    //upgrades the database if its version has changed
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {

    }


}

