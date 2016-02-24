package com.webacademy.fdays.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.webacademy.fdays.R;

public class TargetsFragment extends Fragment {

    private String title;
    private int page;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_targets,container,false);

        ListView expandableListView = (ListView) view.findViewById(R.id.listView);

        return view;
    }


}
