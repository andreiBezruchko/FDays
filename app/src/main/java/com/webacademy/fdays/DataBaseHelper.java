package com.webacademy.fdays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Cursor eventCursor;
    private Event event;

    public static final String ID_COLUMN = "_id";
    public static final String TABLE_NAME = "EventStorage";
    public static final String DATE_COLUMN = "date";
    public static final String TITLE_COLUMN = "title";
    public static final String TEXT_COLUMN = "text";


    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME + ".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER , "
                + DATE_COLUMN + " INTEGER PRIMARY KEY NOT NULL, "
                + TITLE_COLUMN + " TEXT NOT NULL, "
                + TEXT_COLUMN + " TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }

    public long saveEvent(Event event) {
        db = getWritableDatabase();

        //TODO
        long id = 0;

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put(DataBaseHelper.TITLE_COLUMN, event.getTitle());
            contentValues.put(DataBaseHelper.TEXT_COLUMN, event.getText());

            db.insert(DataBaseHelper.TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int deleteEvent(long date) {

        int countOfChanges = 0;//TODO

        db = getWritableDatabase();
        try {
            db.delete(TABLE_NAME, DATE_COLUMN + "=" + date, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countOfChanges;
    }

    public ArrayList<Event> getAllEvents() {
        eventCursor = null;
        event = null;
        ArrayList<Event> eventArrayList = new ArrayList<>();


        try {
            eventCursor = db.query(TABLE_NAME, null, null, null, null, null, null);

            eventCursor.moveToFirst();
            while (! eventCursor.isAfterLast()) {
                event = new Event();

                event.setTitle(eventCursor.getString(eventCursor.getColumnIndex(TITLE_COLUMN)));
                event.setText(eventCursor.getString(eventCursor.getColumnIndex(TEXT_COLUMN)));
                event.setDate(eventCursor.getLong(eventCursor.getColumnIndex(DATE_COLUMN)));

                eventArrayList.add(event);
                eventCursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (eventCursor != null) {
                eventCursor.close();
            }
        }

        return eventArrayList;
    }

    public Event getEvent(long date) {
        eventCursor = null;
        event = null;

        try {
            eventCursor = db.query(
                    TABLE_NAME,
                    new String[]{TITLE_COLUMN, TEXT_COLUMN},
                    DATE_COLUMN + "=" + date,
                    null, null, null, null);
            if (eventCursor.moveToFirst()) {
                event = new Event();
                event.setTitle(eventCursor.getString(eventCursor.getColumnIndex(TITLE_COLUMN)));
                event.setText(eventCursor.getString(eventCursor.getColumnIndex(TEXT_COLUMN)));
                event.setDate(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (eventCursor != null) {
                eventCursor.close();
            }
        }
        return event;
    }


}
