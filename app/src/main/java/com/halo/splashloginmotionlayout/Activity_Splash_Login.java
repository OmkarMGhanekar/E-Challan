package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Splash_Login extends AppCompatActivity{
    private Button button;
    private EditText et1,et2;
    private  static int Splash=10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_login);


        et1= findViewById(R.id.editTextEmail);
        et2=findViewById(R.id.editTextPass);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Activity_Splash_Login.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },Splash);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                if(et1.getText().toString().equals("admin") && et2.getText().toString().equals("admin@123"))
                {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    openNewActivity();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                }


            }
        });*/
    }

    /*public void openNewActivity()
    {
        Intent intent= new Intent(Activity_Splash_Login.this,MainActivity.class);
        startActivity(intent);
    }*/
}