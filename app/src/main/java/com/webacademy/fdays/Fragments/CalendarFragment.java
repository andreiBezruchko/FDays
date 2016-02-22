package com.webacademy.fdays.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.webacademy.fdays.R;

public class CalendarFragment extends Fragment {

    private String title;
    private int page;




    public static CalendarFragment newInstance(int page, String title) {
        CalendarFragment fragmentCalendar = new CalendarFragment();
        Bundle args = new Bundle();
        args.putInt("Some Int", page);
        args.putString("Some Title", title);
        fragmentCalendar.setArguments(args);
        return fragmentCalendar;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar,container,false);

        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        calendarView.setShowWeekNumber(false);
        calendarView.setHorizontalScrollBarEnabled(true);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
