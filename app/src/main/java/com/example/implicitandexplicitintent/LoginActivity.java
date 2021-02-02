package com.example.implicitandexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
   private EditText edUsername;
   private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.ed_username);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(v -> {
           String userName = edUsername.getText().toString();
           Intent i = new Intent(this,WelcomeActivity.class);
           i.putExtra("username",userName);
           startActivity(i);
        });

    }
}