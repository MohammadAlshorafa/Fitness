package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText usernameEt, emailEt, passwordEt;
    Button signupBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        usernameEt = findViewById(R.id.username_Et);
        emailEt = findViewById(R.id.email_Et);
        passwordEt = findViewById(R.id.password_Et);
        signupBtn = findViewById(R.id.signup_Btn);

        sharedPreferences = this.getSharedPreferences("Signup",0);
        editor = sharedPreferences.edit();

        signupBtn.setOnClickListener(v -> {
            String username = usernameEt.getText().toString();
            String email = emailEt.getText().toString();
            String password = passwordEt.getText().toString();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            } else {
                editor.putString("username", username);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.commit();
                Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(SignupActivity.this, SigninActivity.class));

            }
        });


    }
}