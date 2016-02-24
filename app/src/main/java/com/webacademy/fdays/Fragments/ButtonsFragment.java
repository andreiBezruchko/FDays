package com.webacademy.fdays.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.webacademy.fdays.R;


public class ButtonsFragment extends Fragment {

    private String title;
    private int page;

    public static ButtonsFragment newInstance(int page, String title) {
        ButtonsFragment fragmentButton = new ButtonsFragment();
        Bundle args = new Bundle();
        args.putInt("Some Int", page);
        args.putString("Some Title", title);
        fragmentButton.setArguments(args);
        return fragmentButton;
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
        View view = inflater.inflate(R.layout.fragment_buttons,container,false);

        Button buttonGoodDay = (Button) view.findViewById(R.id.buttonGoodDay);
        Button buttonBadDay = (Button) view.findViewById(R.id.buttonBadDay);

        return view;
    }
}
