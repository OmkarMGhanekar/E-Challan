package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class next extends AppCompatActivity {
    EditText et1,et2, et3;
    String string;
    Button btnadd;

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);



        et1=findViewById(R.id.editextnext);
        string=getIntent().getExtras().getString("value");
        et1.setText(string);

        et2=findViewById(R.id.edit1);
        et3=findViewById(R.id.edit2);
        btnadd=findViewById(R.id.add);

        db= FirebaseDatabase.getInstance().getReference().child("Fine");
        btnadd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               insertamount();

            }
        });



    }

    private void insertamount() {
        String v = et1.getText().toString();
        String p = et2.getText().toString();
        String f= et3.getText().toString();

        Amount amount = new Amount(v,p,f);
        db.push().setValue(amount);


        Intent a = new Intent(next.this,Police_CV.class);
        Toast.makeText(getApplicationContext(),"Check E-Challan Payment for Fine",Toast.LENGTH_LONG).show();
        startActivity(a);
    }
}