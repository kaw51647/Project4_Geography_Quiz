package edu.uga.cs.project4_geography_quiz;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GeoQuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "geoquiz.db";
    private static final int DB_VERSION = 1;
    private static String DB_PATH = "";
    private final Context context;
    private SQLiteDatabase database;

    public GeoQuizDBHelper( Context context ) {
        super( context, DB_NAME, null, DB_VERSION );
        this.context = context;
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    }


    public boolean openDatabase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
        return database != null;
    }

    public synchronized void closeDatabase() {
        if(database != null) {
            database.close();
        }
        super.close();
    }

    //creates the database if it does not exist yet
    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    //upgrades the database if its version has changed
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {

    }


}


