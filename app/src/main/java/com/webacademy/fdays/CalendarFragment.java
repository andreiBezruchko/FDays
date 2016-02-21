package com.webacademy.fdays;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalendarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        TextView textButtons = (TextView) view.findViewById(R.id.textButtons);
        textButtons.setText("В этот фрагмент выводим календарь");

        return view;
    }


}
