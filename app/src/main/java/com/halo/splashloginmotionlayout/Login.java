package com.halo.splashloginmotionlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private EditText editTextEmail,editTextPass;
    private TextView text1,text2;
    private Button login_button;
    private Intent Userpage;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login_button = findViewById(R.id.b1);
        text1 = findViewById(R.id.tv_register);
        text2 = findViewById(R.id.tv_forgotPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        Userpage=new Intent(Login.this,User_Cv.class);

        mAuth=FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbar);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent by= new Intent(Login.this,regesitration.class);
                startActivity(by);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent( Login.this,ForgotPassword.class);
                startActivity(b);
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }
/*
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.b1:
                userLogin();
                break;
        }

    }*/
    private void userLogin() {
       final String email = editTextEmail.getText().toString().trim();
        final String pass = editTextPass.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            editTextPass.setError("Password is reqiured");
            editTextPass.requestFocus();
            return;
        }
        if (pass.length() < 6) {
            editTextPass.setError("min password lenth is 6 character");
            editTextPass.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()){
                        //redirect to user profile
                        progressBar.setVisibility(View.INVISIBLE);
                        login_button.setVisibility(View.VISIBLE);
                        updateUI();
                    }
                    else
                    {
                        user.sendEmailVerification();
                        Toast.makeText(Login.this,"Check you email to verify your account!",Toast.LENGTH_LONG).show();

                    }

                }
                else {
                    Toast.makeText(Login.this,"Failed to login! please check your credentials",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void updateUI() {
        startActivity(Userpage);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user =mAuth.getCurrentUser();

        if (user!=null)
        {
            updateUI();
        }
    }
}