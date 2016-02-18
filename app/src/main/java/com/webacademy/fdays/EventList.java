package com.webacademy.fdays;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class EventList extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__list);

        listView = (ListView) findViewById(R.id.listView);

        DataBaseHelper DBHelper = new DataBaseHelper(this);
        SQLiteDatabase db = DBHelper.getWritableDatabase();

        Cursor studentsCursor = db.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                studentsCursor,
                new String[]{DataBaseHelper.TITLE_COLUMN, DataBaseHelper.TEXT_COLUMN},
                new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(adapter);
    }
}
