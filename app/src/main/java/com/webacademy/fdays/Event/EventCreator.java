package com.webacademy.fdays.Event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.webacademy.fdays.R;

public class EventCreator extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);

        editTitle = (EditText) findViewById(R.id.editTextEventTitle);
        editDescription = (EditText) findViewById(R.id.editTextEventDescribe);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonSaveEvent:
                //TODO
                finish();
                break;
            case R.id.buttonChooseDate:
                //TODO
                break;
        }
    }
}
