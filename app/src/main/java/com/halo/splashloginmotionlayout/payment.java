package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void browse1(View view) {
        Intent bro1= new Intent(Intent.ACTION_VIEW, Uri.parse("https://paytm.com/"));
        startActivity(bro1);
    }

    public void browse2(View view) {
        Intent bro2= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.phonepe.com/"));
        startActivity(bro2);
    }

    public void browse3(View view) {
        Intent bro3= new Intent(Intent.ACTION_VIEW, Uri.parse("https://pay.google.com/intl/en_in/about/"));
        startActivity(bro3);
    }

    public void browse4(View view) {
        Intent bro4= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.freecharge.in/"));
        startActivity(bro4);
    }
}