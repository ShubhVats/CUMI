package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button NavBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        String Parent = getIntent().getStringExtra("ParentValue");

        NavBtn = findViewById(R.id.login_btn);
        NavBtn.setOnClickListener(view -> {
            Intent i = new Intent(Login.this, SelectProcess.class);
            i.putExtra("Parent", Parent);
            Log.e("Here", Parent);
            startActivity(i);
        });

    }
}