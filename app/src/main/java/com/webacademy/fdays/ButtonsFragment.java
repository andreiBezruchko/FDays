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
 * {@link ButtonsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
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
        TextView lable = (TextView) view.findViewById(R.id.lable);
        lable.setText("В этот фрагмент выводим кнопки");

        return view;
    }
}
