package com.halo.splashloginmotionlayout;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.halo.splashloginmotionlayout.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.InputStream;

public class MainActivity1 extends AppCompatActivity {
    EditText vehicle_no;
    ImageView img;
    Uri filepath;
    Button browse,upload;
    Bitmap bitmap;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        img=findViewById(R.id.img);
        browse=findViewById(R.id.browse);
        upload=findViewById(R.id.upload);




        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(MainActivity1.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Intent intent=new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(Intent.createChooser(intent,"select image file"),1);

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();

                    }
                }).check();

            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle_no=findViewById(R.id.vehicle_no);
                String databasestring=vehicle_no.getText().toString();
                reff= FirebaseDatabase.getInstance().getReference().child(databasestring);
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String fine=snapshot.child("fine").getValue().toString();
                        String contact_no=snapshot.child("contact_no").getValue().toString();
                        String email=snapshot.child("email").getValue().toString();
                        String name=snapshot.child("name").getValue().toString();
                        //String vehicle_no=snapshot.child("vehicle_no").getValue().toString();
                        Intent intent = new Intent(MainActivity1.this,
                                add_fine.class);
                        intent.putExtra("name",name);
                        intent.putExtra("email",email);
                        intent.putExtra("contact",contact_no);
                      // intent.putExtra("vehicle",vehicle_no);
                        intent.putExtra("fine",fine);
                        startActivity(intent);


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });




    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);

            }
            catch (Exception e)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}