package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    CardView cv1,cv3,cv5,cv6,cv2,cv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv1 = findViewById(R.id.cv1);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a1= new Intent(MainActivity.this,Police_CV.class);
                startActivity(a1);
            }
        });

        cv6=findViewById(R.id.cv6);
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a5=new Intent(MainActivity.this,Contact_us.class);
                startActivity(a5);
            }
        });

        cv2=findViewById(R.id.cv2);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a2= new Intent(MainActivity.this,Login.class);
                startActivity(a2);
            }
        });
        cv3=findViewById(R.id.cv3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a3= new Intent(MainActivity.this,payment.class);
                startActivity(a3);
            }
        });

        cv4=findViewById(R.id.cv4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a4 = new Intent(MainActivity.this,news.class);
                startActivity(a4);
            }
        });
        cv5=findViewById(R.id.cv5);
                cv5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent a5 = new Intent(MainActivity.this,information.class);
                        startActivity(a5);
                    }
                });




    }
}