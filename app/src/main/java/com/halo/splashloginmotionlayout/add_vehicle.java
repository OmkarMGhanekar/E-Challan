package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_vehicle extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    Button btnsubmit;

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

            }

    public void process(View view) {
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);

        String vehicle_no=t1.getText().toString().trim();
        String email=t2.getText().toString().trim();
        String fine=t3.getText().toString().trim();
        String name=t4.getText().toString().trim();
        String contact_no=t5.getText().toString().trim();

        AddVehicle addVehicle=new AddVehicle(email,fine,name,contact_no,vehicle_no);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference(vehicle_no);

        node.setValue(addVehicle);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        Toast.makeText(getApplicationContext(),"Vehicle added",Toast.LENGTH_LONG).show();



    }
}