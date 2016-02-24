package com.webacademy.fdays;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.webacademy.fdays.Event.Event;

public class DataBaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Cursor eventCursor;
    private Event event;

    public static final String TABLE_NAME = "EventStorage";
    public static final String ID_COLUMN = "_id";
    public static final String BAD_OR_GOOD_COLUMN = "isChecked";
    public static final String DATE_COLUMN = "date";
    public static final String TITLE_COLUMN = "title";
    public static final String TEXT_COLUMN = "text";


    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME + ".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER, "
                + BAD_OR_GOOD_COLUMN + " INTEGER, "
                + DATE_COLUMN + " INTEGER PRIMARY KEY NOT NULL, "
                + TITLE_COLUMN + " TEXT NOT NULL, "
                + TEXT_COLUMN + " TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }




}
