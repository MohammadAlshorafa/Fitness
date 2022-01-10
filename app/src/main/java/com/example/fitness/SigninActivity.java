package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    private static final String PREFER_NAME = "Signup";
    EditText usernameEt, passwordEt;
    Button signinBtn;
    UserSession session;
    SharedPreferences sharedPreferences;
    Boolean saveSignin;
    CheckBox checkBox;
    String username, password;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        TextView signupTv = findViewById(R.id.signupTv);
        signupTv.setOnClickListener(v -> {
            startActivity(new Intent(this, SignupActivity.class));
        });

        usernameEt = findViewById(R.id.usernameEt);
        passwordEt = findViewById(R.id.passwordEt);
        signinBtn = findViewById(R.id.signinBtn);
        checkBox = findViewById(R.id.checkBox);

        session = new UserSession(this);
        Toast.makeText(this,"User Login Status : " + session.isUserLoggedIn(), Toast.LENGTH_SHORT).show();

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();

        signinBtn.setOnClickListener(v -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            String s_username = null;
            String s_password = null;

            if (sharedPreferences.contains("username")) {
                s_username = sharedPreferences.getString("username","");
            }
            if (sharedPreferences.contains("password")) {
                s_password = sharedPreferences.getString("password","");
            }

            if (username.equals(s_username) && password.equals(s_password)) {
                session.createUserLoginSession(s_username, s_password);

                startActivity(new Intent(SigninActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
            }


        });

//        signinBtn.setOnClickListener(this::onClick);
//
//        saveSignin = sharedPreferences.getBoolean("saveLogin", false);
//        if (saveSignin){
//            usernameEt.setText(sharedPreferences.getString("username", ""));
//            passwordEt.setText(sharedPreferences.getString("password", ""));
//            checkBox.setChecked(true);
//        }


    }

    public void onClick(View view) {
        if (view == signinBtn) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(usernameEt.getWindowToken(), 0);

            username = usernameEt.getText().toString();
            password = passwordEt.getText().toString();

            if (checkBox.isChecked()) {
                editor.putBoolean("saveLogin", true);
                editor.putString("username", username);
                editor.putString("password", password);
                editor.commit();
            } else {
                editor.clear();
                editor.commit();
            }

            startActivity(new Intent(SigninActivity.this, HomeActivity.class));
            finish();
        }
    }


}