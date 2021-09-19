package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insert extends AppCompatActivity {
    EditText etname, etmail, etpassword;
    Button btninsert;

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        etname = findViewById(R.id.reg_edit1);
        etmail = findViewById(R.id.reg_edit2);
        etpassword = findViewById(R.id.reg_edit3);
        btninsert=findViewById(R.id.reg_register);


        db= FirebaseDatabase.getInstance().getReference().child("Database");

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStudentData();
            }
        });


    }

private void insertStudentData() {

        String name = etname.getText().toString();
        String email= etmail.getText().toString();
        String pass = etpassword.getText().toString();

        Insertion insertion = new Insertion(name, email, pass);
        // to generate unique id for data
        db.push().setValue(insertion);

        Intent intent = new Intent(insert.this, fine.class);
        startActivity(intent);


    }
}