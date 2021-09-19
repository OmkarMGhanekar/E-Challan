package com.halo.splashloginmotionlayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toast.makeText(getApplicationContext(),"No Live Updates",Toast.LENGTH_LONG).show();
    }
}