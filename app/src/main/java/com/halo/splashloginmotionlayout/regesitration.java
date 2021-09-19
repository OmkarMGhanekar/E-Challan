package com.halo.splashloginmotionlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

public class regesitration extends AppCompatActivity implements View.OnClickListener {
    private TextView banner;
    private FirebaseAuth mAuth;
    private EditText username, password, name;
    private Button login;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regesitration);


        mAuth= FirebaseAuth.getInstance();
        username = findViewById(R.id.reg_edit2);
        password = findViewById(R.id.reg_edit3);
        name = findViewById(R.id.reg_edit1);
        login = findViewById(R.id.reg_register);
       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               registerUser();
                Intent intent = new Intent(regesitration.this,Login.class);
                startActivity(intent);
           }
       });

        progressBar = findViewById(R.id.progressbar);
        banner=findViewById(R.id.banner);
        banner.setOnClickListener((View.OnClickListener) regesitration.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.banner:
                startActivity(new Intent(regesitration.this,MainActivity.class));


        }
    }

    private void registerUser() {
       final String fullname= name.getText().toString().trim();
       final String email=username.getText().toString().trim();
      final String pass= password.getText().toString().trim();

       if (fullname.isEmpty())
       {
           name.setError("Full Name is Required");
           name.requestFocus();
           return;
       }
       if (email.isEmpty())
       {
           username.setError("Email is required");
           username.requestFocus();
           return;
       }
       if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           username.setError("please provide valid email");
           username.requestFocus();
           return;
       }

       if (pass.isEmpty())
       {
           password.setError("password is required");
           password.requestFocus();
           return;
       }
       if (pass.length()<6)
       {
           password.setError("min length should be 6 character");
           password.requestFocus();
           return;
       }

       progressBar.setVisibility(View.VISIBLE);
       mAuth.createUserWithEmailAndPassword(email,pass)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful())
                       {
                           User user= new User(fullname,email);

                           FirebaseDatabase.getInstance().getReference("Users")
                                   .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                   .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   if (task.isSuccessful())
                                   {
                                       Toast.makeText(getApplicationContext(),"User has been registered succesfully!", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.VISIBLE);

                                   }
                                   else
                                   {
                                       Toast.makeText(regesitration.this, "Failed to register!", Toast.LENGTH_LONG).show();
                                       progressBar.setVisibility(View.GONE);
                                   }
                               }
                           });
                       }
                       else
                       {
                           Toast.makeText(regesitration.this, "Failed! Already registered, Try to Login", Toast.LENGTH_LONG).show();
                           progressBar.setVisibility(View.GONE);
                       }
                   }
               });

    }
}