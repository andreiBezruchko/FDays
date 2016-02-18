package com.webacademy.fdays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.button:
                intent = new Intent(this,EventList.class);
                startActivity(intent);
                break;
            case R.id.button2:

        }

    }
}
