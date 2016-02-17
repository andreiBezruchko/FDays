package com.webacademy.fdays;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Андрей  Безручко on 17.02.2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "EventStorage";
    public static final String ID_COLUMN = "_id";
    public static final String DATE_COLUMN = "date";
    public static final String TITLE_COLUMN = "title";
    public static final String TEXT_COLUMN = "text";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, TABLE_NAME + ".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COLUMN + " INTEGER NOT NULL AUTOINCREMENT, "
                + DATE_COLUMN + " INTEGER PRIMARY KEY NOT NULL, "
                + TITLE_COLUMN + " TEXT NOT NULL, "
                + TEXT_COLUMN + " TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
