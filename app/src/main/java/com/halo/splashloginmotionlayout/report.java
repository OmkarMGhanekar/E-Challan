package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toast.makeText(getApplicationContext(),"Latest Report !",Toast.LENGTH_LONG).show();
    }
}