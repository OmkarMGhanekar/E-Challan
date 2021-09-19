package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class add_fine extends AppCompatActivity {
    TextView name,contact,vehicle,fine;
    EditText amount,email;
    Button submit;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fine);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        contact=findViewById(R.id.contact);
      //  vehicle=findViewById(R.id.vehicle_no);
        fine=findViewById(R.id.fine);
        amount=findViewById(R.id.amount);
        submit=findViewById(R.id.enter);

        Intent intent = getIntent();


        String names= intent.getStringExtra("name");
        String emails= intent.getStringExtra("email");
        String contacts = intent.getStringExtra("contact");
       String vehicles = ("vehicle");
        String fines = intent.getStringExtra("fine");


        name.setText(names);
        email.setText(emails);
        contact.setText(contacts);
        //vehicle.setText(vehicles);
        fine.setText(fines);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int am=Integer.parseInt(amount.getText().toString());
                int f=Integer.parseInt(fines);
                am=am+f;
                HashMap hashMap=new HashMap();
                hashMap.put("fine",am);
                reff= FirebaseDatabase.getInstance().getReference();
                int finalAm = am;
                reff.child(vehicles).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        String to=email.getText().toString();
                        String message="total your fine is:"+ finalAm +"you need to clear your fine\n pay now https://paytm.com/";
                        /*Intent intent1=new Intent(Intent.ACTION_SEND, Uri.parse("mailto:omkarghanekar12@gmail.com"));
                        intent1.putExtra(Intent.EXTRA_SUBJECT,"by rto");
                        intent1.putExtra(Intent.EXTRA_TEXT,""+message+"");
                        startActivity(intent1);*/
                        Intent intent1 = new Intent(Intent.ACTION_SEND,Uri.parse("mailto:"+emails));
                        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                        intent1.putExtra(Intent.EXTRA_SUBJECT, "by rto");
                        intent1.putExtra(Intent.EXTRA_TEXT, message);
                        //need this to prompts email client only
                        intent1.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent1, "Choose an Email client :"));
                        Toast.makeText(add_fine.this,"fine added successfully",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}/*reff= FirebaseDatabase.getInstance().getReference();
                int finalAm = am;
                reff.child(vehicles).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {

                        String message="total your fine is:"+ finalAm +"you need to clear your fine\n pay now https://paytm.com/";
                        Intent intent1=new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"+emails));
                        intent1.putExtra(Intent.EXTRA_SUBJECT,"by rto");
                        intent1.putExtra(Intent.EXTRA_TEXT,""+message+"");
                        startActivity(intent1);
                        Toast.makeText(add_fine.this,"fine added successfully",Toast.LENGTH_SHORT).show();
                    }
                });*/