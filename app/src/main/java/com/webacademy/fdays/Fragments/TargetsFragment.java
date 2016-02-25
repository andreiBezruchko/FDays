package com.webacademy.fdays.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SimpleCursorAdapter;

import com.webacademy.fdays.DataBaseHelper;
import com.webacademy.fdays.Event.Event;
import com.webacademy.fdays.Event.EventCreator;
import com.webacademy.fdays.R;

public class TargetsFragment extends Fragment {

    private String title;
    private int page;
    public static final String EDIT_EVENT = "EDIT_EVENT";


    public static TargetsFragment newInstance(int page, String title) {
        TargetsFragment fragmentTargets = new TargetsFragment();
        Bundle args = new Bundle();
        args.putInt("Some Int", page);
        args.putString("Some Title", title);
        fragmentTargets.setArguments(args);
        return fragmentTargets;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt("SomeInt", 0);
            title = getArguments().getString("Some Title");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_targets,container,false);
        final ListView listView = (ListView) view.findViewById(R.id.listView);


        final DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DataBaseHelper.TABLE_NAME, null, null, null, null, null, null);

        final SimpleCursorAdapter simpleCursorAdapter =
                new SimpleCursorAdapter(getContext(),
                        android.R.layout.simple_list_item_2,
                        cursor,
                        new String[]{DataBaseHelper.TITLE_COLUMN, DataBaseHelper.DESCRIPTION_COLUMN},
                        new int[]{android.R.id.text1, android.R.id.text2});

        listView.setAdapter(simpleCursorAdapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long id) {
                PopupMenu popupMenu = new PopupMenu(getContext(), view);
                popupMenu.inflate(R.menu.popup_menu);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                dataBaseHelper.deleteEvent(id);
                                //TODO update listviev
                                return true;
                            case R.id.menu2:
                                Event event = dataBaseHelper.getEventToEdit(id);
                                Intent intent = new Intent(getContext(), EventCreator.class);
                                intent.putExtra(EDIT_EVENT, event);
                                startActivity(intent);
                                dataBaseHelper.deleteEvent(id);
                                return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();

                return true;
            }
        });


        return view;
    }

}
