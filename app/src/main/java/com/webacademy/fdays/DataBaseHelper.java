package com.webacademy.fdays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.webacademy.fdays.Event.Event;

public class DataBaseHelper extends SQLiteOpenHelper {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase SQLdatabase;
    private ContentValues  cvEvent;
    private Cursor eventCursor;
    private Event event;

    public static final String TABLE_NAME = "EventStorage";
    public static final String ID_COLUMN = "_id";
    public static final String BAD_OR_GOOD_COLUMN = "isChecked";
    public static final String DATE_COLUMN = "date";
    public static final String TITLE_COLUMN = "title";
    public static final String DESCRIPTION_COLUMN = "description";


    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME + ".db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BAD_OR_GOOD_COLUMN + " INTEGER, "
                + DATE_COLUMN + " INTEGER NOT NULL, "
                + TITLE_COLUMN + " TEXT NOT NULL, "
                + DESCRIPTION_COLUMN + " TEXT NOT NULL );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO
    }

    public long addEvent(Event event){

        long id = 0;

        try {
            SQLdatabase = this.getWritableDatabase();

            cvEvent = new ContentValues();

            cvEvent.put(TITLE_COLUMN, event.getTitle());
            cvEvent.put(DESCRIPTION_COLUMN, event.getText());
            cvEvent.put(DATE_COLUMN, event.getDate());
            cvEvent.put(BAD_OR_GOOD_COLUMN, event.getCheck());

            id =  SQLdatabase.insert(TABLE_NAME, null, cvEvent);
        } catch (Exception e){
            e.printStackTrace();
        }

        return id;
    }

    public Event getEventToEdit(long id){

        eventCursor =  null;
        Event event = new Event();

        try {
        eventCursor = SQLdatabase.query(TABLE_NAME,
                null,
                ID_COLUMN + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if(eventCursor.moveToFirst()){
            event.setId(eventCursor.getInt(eventCursor.getColumnIndex(ID_COLUMN)));
            event.setDate(eventCursor.getLong(eventCursor.getColumnIndex(DATE_COLUMN)));
            event.setTitle(eventCursor.getString(eventCursor.getColumnIndex(DESCRIPTION_COLUMN)));
            event.setText(eventCursor.getString(eventCursor.getColumnIndex(DESCRIPTION_COLUMN)));
            event.setCheck(eventCursor.getInt(eventCursor.getColumnIndex(BAD_OR_GOOD_COLUMN)));
        }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(eventCursor != null) {
                eventCursor.close();
            }
        }

        return event;
    }

    public long deleteEvent(long id) {
        SQLdatabase = this.getWritableDatabase();
        return SQLdatabase.delete(TABLE_NAME, ID_COLUMN + "=" + id, null);
    }



}
