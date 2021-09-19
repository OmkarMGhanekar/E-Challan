package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class information extends AppCompatActivity {
    CardView cv1,cv2,cv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        cv1=findViewById(R.id.info_cv1);
        cv2=findViewById(R.id.info_cv2);
        cv3=findViewById(R.id.info_cv3);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(information.this,notification.class);
                startActivity(b);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(information.this,traffic_education.class);
                startActivity(a);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(information.this,fine.class);
                startActivity(a);
            }
        });

    }
}