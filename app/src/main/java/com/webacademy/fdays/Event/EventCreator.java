package com.webacademy.fdays.Event;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.webacademy.fdays.DataBaseHelper;
import com.webacademy.fdays.Fragments.TargetsFragment;
import com.webacademy.fdays.R;

public class EventCreator extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDescription;
    private CheckBox checkBox;
    private long time;
    private int checked;

    private void createTimePicker() {
        new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        time = year * 31557600000L + monthOfYear * 2629800000L + dayOfMonth * 86400000L;
                    }
                },
                2016,
                0,
                1).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);

        editTitle = (EditText) findViewById(R.id.editTextEventTitle);
        editDescription = (EditText) findViewById(R.id.editTextEventDescribe);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        Intent intent = getIntent();
        if(intent.hasExtra(TargetsFragment.EDIT_EVENT)) {
            Event editableEvent = intent.getParcelableExtra(TargetsFragment.EDIT_EVENT);
            editTitle.setText(editableEvent.getTitle());
            editDescription.setText(editableEvent.getText());
            if(editableEvent.getCheck() == 1){
                checkBox.setChecked(true);
            }
        }
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.buttonSaveEvent:
                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();
                DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

                if(checkBox.isChecked()){
                    checked = 1;
                } else {
                    checked = 0;
                }

                if(time == 0){
                    Toast.makeText(this,"Вы не указали дату", Toast.LENGTH_SHORT).show();
                }

                Event event = new Event(time, title, description, checked);

                dataBaseHelper.addEvent(event);

                ListView listView = (ListView) findViewById(R.id.listView);

                finish();
                break;

            case R.id.buttonChooseDate:
                createTimePicker();
                break;
        }
    }

}
