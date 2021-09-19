package com.halo.splashloginmotionlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ForgotPassword extends AppCompatActivity {
    EditText emailedittext;
    Button resetpassword;
    ProgressBar progressBar;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailedittext=findViewById(R.id.resetemail);
        resetpassword=findViewById(R.id.resetpassword);
        progressBar=findViewById(R.id.progressbar);

        auth= FirebaseAuth.getInstance();
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {
        String email = emailedittext.getText().toString().trim();

        if (email.isEmpty())
        {
            emailedittext.setError("Email is requires");
            emailedittext.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailedittext.setError("please provide proper email");
            emailedittext.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(ForgotPassword.this,"check email to reset your password",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(ForgotPassword.this,"try again! something went wrong",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}