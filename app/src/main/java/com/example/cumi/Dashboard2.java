package com.example.cumi;

import static com.example.cumi.R.layout.activity_dashboard2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Dashboard2 extends AppCompatActivity {

    String Parent = "";
    Button NavBtn_1, NavBtn_2, NavBtn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_dashboard2);

        NavBtn_1 = findViewById(R.id.production_btn);
        NavBtn_1.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard2.this, Login.class);
            Parent = "Production";
            i.putExtra("ParentValue", Parent);
            Log.e("Here", Parent);
            startActivity(i);
        });

        NavBtn_2 = findViewById(R.id.quality_btn);
        NavBtn_2.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard2.this, Login.class);
            Parent = "Quality";
            i.putExtra("ParentValue", Parent);
            Log.e("Here", Parent);
            startActivity(i);
        });

        NavBtn_3 = findViewById(R.id.material_store_btn);
        NavBtn_3.setOnClickListener(view -> {
            Intent i = new Intent(Dashboard2.this, Login.class);
            Parent = "Material_Store";
            i.putExtra("ParentValue", Parent);
            Log.e("Here", Parent);
            startActivity(i);
        });
    }
}