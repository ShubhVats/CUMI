package com.example.cumi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard1 extends AppCompatActivity {

    Button NavBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1);

        NavBtn = findViewById(R.id.operations_btn);

        NavBtn.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard1.this, Dashboard2.class);
            startActivity(i);
        });

    }
}