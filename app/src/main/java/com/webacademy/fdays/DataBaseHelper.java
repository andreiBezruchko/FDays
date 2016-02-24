package com.webacademy.fdays;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.webacademy.fdays.Event.Event;

import java.util.ArrayList;

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

    public Event getEvent(long date){
        SQLiteDatabase db = getWritableDatabase();
        Event event = null;
        Cursor cursor = null;

        try{
            cursor = db.query(TABLE_NAME,null,DATE_COLUMN + "=" + String.valueOf(date),null,null,null,null);
            if(cursor.moveToFirst()){

                event = new Event();


                event.Id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
                event.Date = cursor.getLong(cursor.getColumnIndex(DATE_COLUMN));
                event.Title = cursor.getString(cursor.getColumnIndex(TITLE_COLUMN));
                event.Text = cursor.getString(cursor.getColumnIndex(TEXT_COLUMN));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(cursor !=null){
                cursor.close();
            }
        }

        return event;
    }


    public ArrayList<Event> getEvent(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Event> events = new ArrayList<>();
        Event event = null;
        Cursor cursor = null;

        try{
            cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
            if(cursor.moveToFirst()){
                while (!cursor.isAfterLast()){
                    event = new Event();
                    event.Id = cursor.getLong(cursor.getColumnIndex(ID_COLUMN));
                    event.Date = cursor.getLong(cursor.getColumnIndex(DATE_COLUMN));
                    event.Title = cursor.getString(cursor.getColumnIndex(TITLE_COLUMN));
                    event.Text = cursor.getString(cursor.getColumnIndex(TEXT_COLUMN));
                    events.add(event);
                }}
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            if(cursor !=null){
                cursor.close();
            }
        }

        return events;
    }
    public long saveStudent(Event event){
        SQLiteDatabase db = getWritableDatabase();
        long date = 0;
        try{
            ContentValues values = new ContentValues();
            values.put(DATE_COLUMN,event.Date);
            values.put(TITLE_COLUMN,event.Title);
            values.put(TEXT_COLUMN,event.Text);
            date = db.insert(TABLE_NAME,null,values);


        }catch (Exception e){
            e.printStackTrace();
        }return date;
    }


}
