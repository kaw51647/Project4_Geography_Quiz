package edu.uga.cs.project4_geography_quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GeoQuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "geoquiz.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_GEOQUIZ = "geoquiz";
    public static final String GEOQUIZ_COLUMN_ID = "id";
    public static final String GEOQUIZ_COLUMN_COUNTRY = "country";
    public static final String GEOQUIZ_COLUMN_CONTINENT = "continent";

    private static GeoQuizDBHelper helperInstance;

    private static final String CREATE_GEOQUIZ =
            "create table " + TABLE_GEOQUIZ + " ("
                    + GEOQUIZ_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + GEOQUIZ_COLUMN_COUNTRY + " TEXT, "
                    + GEOQUIZ_COLUMN_CONTINENT + " TEXT"
                    + ")";


    private GeoQuizDBHelper( Context context ) {
        super( context, DB_NAME, null, DB_VERSION );
    }

    public static synchronized GeoQuizDBHelper getInstance( Context context ) {
        // check if the instance already exists and if not, create the instance
        if( helperInstance == null ) {
            helperInstance = new GeoQuizDBHelper( context.getApplicationContext() );
        }
        return helperInstance;
    }

    //creates the database if it does not exist yet
    @Override
    public void onCreate( SQLiteDatabase db ) {
        db.execSQL( CREATE_GEOQUIZ );
    }

    //upgrades the database if its version has changed
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL( "drop table if exists " + TABLE_GEOQUIZ );
        onCreate( db );
    }


}

